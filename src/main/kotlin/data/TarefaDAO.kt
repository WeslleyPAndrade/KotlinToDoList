package data

import Extensions.toEntity
import Extensions.toModel
import models.Tarefa
import javax.persistence.EntityManager

class TarefaDAO(manager: EntityManager): DAO<Tarefa,TarefaEntity>(manager,TarefaEntity::class.java) {
    override fun toEntity(model: Tarefa): TarefaEntity {
        return model.toEntity()
    }

    override fun toModel(entity: TarefaEntity): Tarefa {
        return entity.toModel()
    }

    override fun getIdFromModel(model: Tarefa): Int {
        return model.id
    }

    override fun updateEntityFromModel(entity: TarefaEntity, model: Tarefa) {
        entity.titulo = model.titulo
        entity.descricao = model.descricao
        entity.concluido = model.concluido
    }


}