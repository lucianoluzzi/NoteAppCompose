package nl.com.lucianoluzzi.noteappcompose.domail.useCase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import nl.com.lucianoluzzi.noteappcompose.data.repository.NoteRepository
import nl.com.lucianoluzzi.noteappcompose.domail.model.Note

class GetNotesUseCase(private val noteRepository: NoteRepository) {
    operator fun invoke(): Flow<List<Note>> {
        return noteRepository.getNotes().map { noteEntities ->
            noteEntities.map { noteEntity ->
                Note(
                    id = noteEntity.id,
                    title = noteEntity.title,
                    description = noteEntity.description,
                )
            }
        }
    }
}