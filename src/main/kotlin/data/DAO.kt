package data

import javax.persistence.EntityManager

abstract class DAO<TModel,TEntity>(
    val manager: EntityManager,
    val entityType: Class<TEntity>) {

    abstract fun toEntity(model: TModel) : TEntity
    abstract fun toModel(entity:TEntity) : TModel

    open fun getList() : List<TModel> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        return  query.resultList.map{entity -> toModel(entity)}
    }

    open fun searchById(id:Int): TEntity {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id = :id", entityType)
        query.setParameter("id",id)

        return query.singleResult
    }

    open fun add(model: TModel) {
        val entity = toEntity(model)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    open fun update(model: TModel) {
        val id =getIdFromModel(model)
            if (id <= 0) {
                throw IllegalArgumentException("ID inválido: $id")
            }

        val entity = searchById(id)
        updateEntityFromModel(entity,model)
        manager.transaction.begin()
        manager.merge(entity)
        manager.transaction.commit()
    }

    open fun delete(id: Int) {
        val entity = searchById(id)
        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }

    abstract fun getIdFromModel(model: TModel) : Int
    abstract fun updateEntityFromModel(entity: TEntity,model: TModel)


}