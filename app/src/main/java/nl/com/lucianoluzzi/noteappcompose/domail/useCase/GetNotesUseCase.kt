package nl.com.lucianoluzzi.noteappcompose.domail.useCase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import nl.com.lucianoluzzi.noteappcompose.data.entity.NoteEntity
import nl.com.lucianoluzzi.noteappcompose.data.repository.NoteRepository
import nl.com.lucianoluzzi.noteappcompose.domail.model.Note

class GetNotesUseCase(private val noteRepository: NoteRepository) {
    operator fun invoke(): Flow<List<Note>> {
        val noteMapper = NoteMapper()
        return noteRepository.getNotes()
            .catch { emit(emptyList()) }
            .map { it.map(noteMapper::mapFromEntity) }
    }

    inner class NoteMapper {
        fun mapFromEntity(noteEntity: NoteEntity) = Note(
            id = noteEntity.id,
            title = noteEntity.title,
            description = noteEntity.description,
        )
    }
}
