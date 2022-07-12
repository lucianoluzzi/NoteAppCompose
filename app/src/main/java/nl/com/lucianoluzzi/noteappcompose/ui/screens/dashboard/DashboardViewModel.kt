package nl.com.lucianoluzzi.noteappcompose.ui.screens.dashboard

import androidx.lifecycle.ViewModel
import nl.com.lucianoluzzi.noteappcompose.domail.model.Note

class DashboardViewModel : ViewModel() {
    val notes = listOf(
        Note(
            title = "#1",
            description = "First card",
        ),
        Note(
            title = "Groceries",
            description = "Onions, garlic, ground beef",
        ),
        Note(
            title = "TODO",
            description = "Hire a paid ads specialist",
        ),
        Note(
            title = "TODO",
            description = "Hire a paid ads specialist",
        ),
    )
}