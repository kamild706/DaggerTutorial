import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class LoginCommandModule {
    @IntoMap
    @StringKey("login")
    @Binds abstract fun loginCommand(command: LoginCommand): Command
}