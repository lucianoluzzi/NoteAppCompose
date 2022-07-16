package nl.com.lucianoluzzi.noteappcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import nl.com.lucianoluzzi.noteappcompose.data.dataSource.NoteDao
import nl.com.lucianoluzzi.noteappcompose.data.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}