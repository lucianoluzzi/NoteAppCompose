package nl.com.lucianoluzzi.noteappcompose.domain.model

data class Note(
    val id: Long = 0,
    val title: String,
    val description: String,
)
