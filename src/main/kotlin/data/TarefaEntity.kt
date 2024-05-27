package data

import javax.persistence.*

@Entity
@Table(name = "tarefas")
class TarefaEntity(
    var titulo: String = "Titulo da tarefa",
    var descricao: String? = "descrição",
    var concluido: Boolean = false,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {
}