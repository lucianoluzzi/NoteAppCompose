package nl.com.lucianoluzzi.noteappcompose.ui.screens.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import nl.com.lucianoluzzi.noteappcompose.domail.model.Note

class DetailsViewModel(private val noteId: String) : ViewModel() {
    private val _uiState = mutableStateOf<DetailsUIState>(DetailsUIState.Loading)
    val uiState: State<DetailsUIState> = _uiState

    init {
        _uiState.value = DetailsUIState.NoteDetails(
            Note(
                id = 0,
                title = "I'm the note title",
                description = "And I'm the note description",
            )
        )
    }
}