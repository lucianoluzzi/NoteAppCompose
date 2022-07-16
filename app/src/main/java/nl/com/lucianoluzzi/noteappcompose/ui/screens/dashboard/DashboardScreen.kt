package nl.com.lucianoluzzi.noteappcompose.ui.screens.dashboard

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import nl.com.lucianoluzzi.noteappcompose.domail.model.Note
import nl.com.lucianoluzzi.noteappcompose.ui.theme.NoteAppComposeTheme

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel,
    onNoteClick: (noteId: Long) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Edit, contentDescription = null)
            }
        }
    ) { contentPadding ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(12.dp),
            columns = GridCells.Fixed(2),
        ) {
            items(viewModel.notes) { note ->
                DashboardItem(
                    note = note,
                    onNoteClick = onNoteClick,
                )
            }
        }
    }
}

@Composable
private fun DashboardItem(
    note: Note,
    onNoteClick: (noteId: Long) -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(all = 4.dp)
            .clickable {
                onNoteClick(note.id)
            },
        elevation = 8.dp,
    ) {
        Column(modifier = Modifier.padding(all = 8.dp)) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.h3,
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = note.description,
                style = MaterialTheme.typography.body1,
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
private fun DashboardScreenPreview() {
    NoteAppComposeTheme {
        DashboardScreen(
            viewModel = DashboardViewModel(),
            onNoteClick = {}
        )
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
        DashboardItem(
            note = note,
            onNoteClick = {},
        )
    }
}