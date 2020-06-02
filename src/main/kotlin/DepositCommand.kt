import Command.Result
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(private val database: Database, private val outputter: Outputter): Command {
    override fun key() = "deposit"

    override fun handleInput(input: List<String>): Result {
        if (input.size != 2)
            return Result.invalid()

        val account = database.getAccount(input[0])
        account.deposit(BigDecimal(input[1]))
        outputter.output("${account.username} now has: ${account.balance}")
        return Result.handled()
    }
}