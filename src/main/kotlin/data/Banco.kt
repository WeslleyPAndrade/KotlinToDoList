package data

import javax.persistence.EntityManager
import javax.persistence.Persistence

object Banco {
    fun getEntityManager(): EntityManager {
        val factory = Persistence.createEntityManagerFactory("tarefas")
        return factory.createEntityManager()
    }
}