package nl.com.lucianoluzzi.noteappcompose.dependencyInjection

import nl.com.lucianoluzzi.noteappcompose.data.repository.NoteRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        NoteRepository(noteLocalDataSource = get())
    }
}