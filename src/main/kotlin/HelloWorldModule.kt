import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class HelloWorldModule {
    @IntoMap
    @StringKey("hello")
    @Binds abstract fun helloWorldCommand(command: HelloWorldCommand): Command
}