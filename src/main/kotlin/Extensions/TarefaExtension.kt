package Extensions

import data.TarefaEntity
import models.Tarefa

fun Tarefa.toEntity(): TarefaEntity {
    return TarefaEntity(this.titulo,this.descricao,this.concluido,this.id)
}

fun TarefaEntity.toModel() : Tarefa {
    return Tarefa(this.titulo,this.descricao,this.concluido,this.id)
}