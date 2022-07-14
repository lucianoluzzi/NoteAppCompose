package nl.com.lucianoluzzi.noteappcompose.ui.screens.details

import nl.com.lucianoluzzi.noteappcompose.domail.model.Note

sealed class DetailsUIState {
    object Loading : DetailsUIState()
    data class Error(val errorMessage: String) : DetailsUIState()
    data class NoteDetails(val note: Note) : DetailsUIState()
}
