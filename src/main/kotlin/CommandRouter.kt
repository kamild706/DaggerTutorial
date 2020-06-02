import Command.Result
import Command.Status
import java.util.regex.Pattern
import javax.inject.Inject

class CommandRouter @Inject constructor(private val commands: Map<String, @JvmSuppressWildcards Command>) {
    fun route(input: String): Result {
        val splitInput = split(input)
        if (splitInput.isEmpty()) return invalidCommand(input)

        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)

        val result = command.handleInput(splitInput.subList(1, splitInput.size))
        if (result.status == Status.INVALID)
            println("$commandKey: invalid arguments")

        return result
    }

    private fun invalidCommand(input: String): Result {
        println("couldn't understand $input. please try again.")
        return Result.invalid()
    }

    private fun split(string: String): List<String> {
        return string.trim().split(SPLIT_PATTERN)
    }

    companion object {
        val SPLIT_PATTERN: Pattern = Pattern.compile("\\s+")
    }
}