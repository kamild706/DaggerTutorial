interface Command {
    fun key(): String
    fun handleInput(input: List<String>): Result

    class Result private constructor(
        val status: Status, val nestedCommandRouter: CommandRouter?
    ) {
        companion object {
            fun invalid() = Result(Status.INVALID, null)
            fun handled() = Result(Status.HANDLED, null)
            fun inputCompleted() = Result(Status.INPUT_COMPLETED, null)
            fun enterNestedCommandSet(nestedCommandRouter: CommandRouter) = Result(Status.HANDLED, nestedCommandRouter)
        }
    }

    enum class Status {
        INVALID, HANDLED, INPUT_COMPLETED
    }
}