package data

import javax.persistence.*

@Entity
@Table(name = "tarefas")
class TarefaEntity(
    val titulo: String = "Titulo da tarefa",
    val descricao: String? = "descrição",
    val concluido: Boolean = false,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {
}