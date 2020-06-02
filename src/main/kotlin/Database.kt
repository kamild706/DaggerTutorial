import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Database @Inject constructor(){
    private val accounts: MutableMap<String, Account> = mutableMapOf()

    fun getAccount(username: String) = accounts.computeIfAbsent(username) { Account(it) }

    class Account(val username: String) {
        var balance: BigDecimal = BigDecimal.ZERO
            private set

        fun deposit(amount: BigDecimal) {
            balance = balance.add(amount)
        }
    }
}