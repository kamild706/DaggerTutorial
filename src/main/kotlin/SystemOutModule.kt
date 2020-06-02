import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object SystemOutModule {
    @Singleton
    @Provides fun textOutputter() = object : Outputter {
        override fun output(output: String) = println(output)
    }
}