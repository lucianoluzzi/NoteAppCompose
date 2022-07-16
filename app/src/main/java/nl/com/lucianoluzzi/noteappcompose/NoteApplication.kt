package nl.com.lucianoluzzi.noteappcompose

import android.app.Application
import nl.com.lucianoluzzi.noteappcompose.dependencyInjection.databaseModule
import nl.com.lucianoluzzi.noteappcompose.dependencyInjection.repositoryModule
import nl.com.lucianoluzzi.noteappcompose.dependencyInjection.useCaseModule
import nl.com.lucianoluzzi.noteappcompose.dependencyInjection.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class NoteApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidLogger()
            androidContext(this@NoteApplication)
            modules(
                viewModelModule,
                repositoryModule,
                databaseModule,
                useCaseModule,
            )
        }
    }
}