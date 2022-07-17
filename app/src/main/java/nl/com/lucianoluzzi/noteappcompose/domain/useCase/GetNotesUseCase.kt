package nl.com.lucianoluzzi.noteappcompose.domain.useCase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import nl.com.lucianoluzzi.noteappcompose.data.repository.NoteRepository
import nl.com.lucianoluzzi.noteappcompose.domain.mapper.NoteMapper
import nl.com.lucianoluzzi.noteappcompose.domain.model.Note

class GetNotesUseCase(private val noteRepository: NoteRepository) {
    operator fun invoke(): Flow<List<Note>> {
        val noteMapper = NoteMapper()
        return noteRepository.getNotes()
            .catch { emit(emptyList()) }
            .map { it.map(noteMapper::mapFromEntity) }
    }
}
