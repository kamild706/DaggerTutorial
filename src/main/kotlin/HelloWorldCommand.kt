import Command.Result
import javax.inject.Inject

class HelloWorldCommand @Inject constructor(private val outputter: Outputter): Command {
    override fun key() = "hello"

    override fun handleInput(input: List<String>): Result {
        if (input.isNotEmpty())
            return Result.invalid()

        outputter.output("world!")
        return Result.handled()
    }
}