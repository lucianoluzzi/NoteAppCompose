package nl.com.lucianoluzzi.noteappcompose.ui.screens.dashboard

import nl.com.lucianoluzzi.noteappcompose.domail.model.Note

sealed class DashboardUIState {
    object Loading : DashboardUIState()
    data class DashboardData(val notes: List<Note>) : DashboardUIState()
}
