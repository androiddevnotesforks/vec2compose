package parser

fun parsePath(pathCode: String): List<Command> {
    if (pathCode.isEmpty()) return emptyList()

    val command = pathCode.first()

    val commandValues = pathCode.drop(1).let {
        it.substring(range = 0 until (it.indexOfFirst { c -> c in Command.chars }.takeIf { it != -1 } ?: it.length))
    }
    val tail = pathCode.drop(1).substring(commandValues.length)
    return listOf(parseCommand(command + commandValues)) + parsePath(tail)
}
                                                                                                                               