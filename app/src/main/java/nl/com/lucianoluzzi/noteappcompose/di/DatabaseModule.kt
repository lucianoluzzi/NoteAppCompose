package nl.com.lucianoluzzi.noteappcompose.di

import androidx.room.Room
import nl.com.lucianoluzzi.noteappcompose.data.NoteDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            NoteDatabase::class.java, "note-database"
        ).build()
    }

    single {
        val noteDatabase = get<NoteDatabase>()
        noteDatabase.getNoteDao()
    }
}