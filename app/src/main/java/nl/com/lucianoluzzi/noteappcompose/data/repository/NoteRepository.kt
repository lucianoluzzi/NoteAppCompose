package nl.com.lucianoluzzi.noteappcompose.data.repository

import kotlinx.coroutines.flow.Flow
import nl.com.lucianoluzzi.noteappcompose.data.dataSource.NoteLocalDataSource
import nl.com.lucianoluzzi.noteappcompose.data.entity.NoteEntity

class NoteRepository(private val noteLocalDataSource: NoteLocalDataSource) {
    fun getNotes(): Flow<List<NoteEntity>> = noteLocalDataSource.getNotes()
}