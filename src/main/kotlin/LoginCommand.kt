import Command.Result
import javax.inject.Inject

class LoginCommand @Inject constructor(private val database: Database, private val outputter: Outputter) : SingleArgCommand() {
    override fun key() = "login"

    override fun handleArg(username: String): Result {
        val account = database.getAccount(username)
        outputter.output("$username is logged in with balance ${account.balance}.")
        return Result.handled()
    }
}