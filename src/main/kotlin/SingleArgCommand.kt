import Command.Result

abstract class SingleArgCommand : Command {
    abstract override fun key(): String

    override fun handleInput(input: List<String>): Result {
        return if (input.size == 1) handleArg(input[0]) else Result.invalid()
    }

    protected abstract fun handleArg(arg: String): Result

}