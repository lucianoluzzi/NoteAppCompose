package nl.com.lucianoluzzi.noteappcompose.data.dataSource

import kotlinx.coroutines.flow.Flow
import nl.com.lucianoluzzi.noteappcompose.data.entity.NoteEntity

class NoteLocalDataSourceImpl(private val noteDao: NoteDao) : NoteLocalDataSource {
    override fun getNotes(): Flow<List<NoteEntity>> = noteDao.getNotes()
}