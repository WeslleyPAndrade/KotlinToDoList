package application

import data.Banco
import data.TarefaDAO
import models.Tarefa

fun main() {

    val manager = Banco.getEntityManager()
    val tarefaDAO = TarefaDAO(manager)

    val tarefa1 = Tarefa("Estudar Kotlin", "Estudando Update com Kotlin", true, id = 1)
//    tarefaDAO.update(tarefa1)

    val listaTarefas = tarefaDAO.getList()
    println(listaTarefas)
}