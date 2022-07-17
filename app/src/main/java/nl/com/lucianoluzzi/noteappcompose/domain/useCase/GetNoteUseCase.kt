package nl.com.lucianoluzzi.noteappcompose.domain.useCase

import nl.com.lucianoluzzi.noteappcompose.data.repository.NoteRepository
import nl.com.lucianoluzzi.noteappcompose.domain.mapper.NoteMapper
import nl.com.lucianoluzzi.noteappcompose.domain.model.Note

class GetNoteUseCase(private val noteRepository: NoteRepository) {
    fun getNote(id: Long): Note? {
        return try {
            noteRepository.getNote(id)?.let {
                val noteMapper = NoteMapper()
                noteMapper.mapFromEntity(it)
            }
        } catch (exception: Exception) {
            null
        }
    }
}