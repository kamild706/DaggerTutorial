import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [LoginCommandModule::class, HelloWorldModule::class, UserCommandModule::class, SystemOutModule::class])
interface CommandProcessorFactory {
    fun processor(): CommandProcessor
}