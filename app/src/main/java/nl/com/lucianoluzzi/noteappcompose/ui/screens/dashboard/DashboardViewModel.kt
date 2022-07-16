package nl.com.lucianoluzzi.noteappcompose.ui.screens.dashboard

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nl.com.lucianoluzzi.noteappcompose.domail.useCase.GetNotesUseCase

class DashboardViewModel(
    private val getNotesUseCase: GetNotesUseCase
) : ViewModel() {
    private val _uiState = mutableStateOf<DashboardUIState>(DashboardUIState.Loading)
    val uiState: State<DashboardUIState> = _uiState

    init {
        viewModelScope.launch {
            getNotesUseCase().collect { notes ->
                _uiState.value = DashboardUIState.DashboardData(notes)
            }
        }
    }
}