package nl.com.lucianoluzzi.noteappcompose.data.dataSource

import kotlinx.coroutines.flow.Flow
import nl.com.lucianoluzzi.noteappcompose.data.entity.NoteEntity

interface NoteLocalDataSource {
    fun getNotes(): Flow<List<NoteEntity>>

    fun getNote(id: Long): NoteEntity?
}