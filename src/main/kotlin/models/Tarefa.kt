package models

data class Tarefa(
    val titulo:String = "Titulo da tarefa",
    val descricao: String? = "Descrição",
    val concluido: Boolean = false,
    val id: Int = 0) {

    override fun toString(): String {
        return  "Titulo: $titulo\n" +
                "Descrição: $descricao\n" +
                "Concluido: ${if (concluido) "Sim" else "Não"}"
    }
}