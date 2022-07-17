package nl.com.lucianoluzzi.noteappcompose.domain.mapper

import nl.com.lucianoluzzi.noteappcompose.data.entity.NoteEntity
import nl.com.lucianoluzzi.noteappcompose.domain.model.Note

class NoteMapper {
    fun mapFromEntity(noteEntity: NoteEntity) = Note(
        id = noteEntity.id,
        title = noteEntity.title,
        description = noteEntity.description,
    )
}