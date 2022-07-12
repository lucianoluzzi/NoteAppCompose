package nl.com.lucianoluzzi.noteappcompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nl.com.lucianoluzzi.noteappcompose.domail.model.Note
import nl.com.lucianoluzzi.noteappcompose.ui.theme.NoteAppComposeTheme

@Composable
fun DashboardScreen() {

}

@Composable
private fun DashboardItem(
    note: Note,
) {
    Card(modifier = Modifier.padding(all = 8.dp)) {
        Column {
            Text(
                text = note.title,
                style = MaterialTheme.typography.h2,
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = note.description,
                style = MaterialTheme.typography.body1,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardItemPreview() {
    val note = Note(
        title = "I'm the first card",
        description = "The first card I'm!",
    )
    NoteAppComposeTheme {
        DashboardItem(note = note)
    }
}