package nl.com.lucianoluzzi.noteappcompose.dependencyInjection

import nl.com.lucianoluzzi.noteappcompose.domain.useCase.GetNoteUseCase
import nl.com.lucianoluzzi.noteappcompose.domain.useCase.GetNotesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single {
        GetNotesUseCase(noteRepository = get())
    }

    single {
        GetNoteUseCase(noteRepository = get())
    }
}