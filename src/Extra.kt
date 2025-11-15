interface CreateCommands {

    fun createCommand(str: String): String

}

class CommandCreationUser : CreateCommands {

    override fun createCommand(str: String): String = str

    fun printValues(str: String) {
        println(str)
    }
}
