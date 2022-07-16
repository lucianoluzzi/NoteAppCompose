package nl.com.lucianoluzzi.noteappcompose.di

import nl.com.lucianoluzzi.noteappcompose.domail.useCase.GetNotesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single {
        GetNotesUseCase(noteRepository = get())
    }
}