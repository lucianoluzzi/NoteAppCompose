package nl.com.lucianoluzzi.noteappcompose.ui.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nl.com.lucianoluzzi.noteappcompose.domail.model.Note
import nl.com.lucianoluzzi.noteappcompose.ui.theme.NoteAppComposeTheme
import nl.com.lucianoluzzi.noteappcompose.ui.widgets.TopBar

@Composable
fun DetailsScreen(
    noteId: String,
    onBackPressed: () -> Unit,
) {
    val detailsViewModel = DetailsViewModel(noteId)
    Scaffold(
        topBar = {
            TopBar(
                title = "Note details",
                onBackPressed = onBackPressed
            )
        }
    ) { paddingValues ->
        when (val uiState = detailsViewModel.uiState.value) {
            DetailsUIState.Loading -> {}
            is DetailsUIState.Error -> {}
            is DetailsUIState.NoteDetails -> NoteDetails(
                modifier = Modifier.padding(paddingValues),
                note = uiState.note
            )
        }
    }
}

@Composable
private fun NoteDetails(
    modifier: Modifier = Modifier,
    note: Note,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 12.dp),
    ) {
        NoteTitle(title = note.title)

        Spacer(modifier = Modifier.size(4.dp))

        NoteDescription(description = note.description)
    }
}

@Composable
private fun NoteTitle(
    modifier: Modifier = Modifier,
    title: String,
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        enabled = false,
        value = title,
        maxLines = 1,
        onValueChange = { },
        label = {
            Text("Title")
        }
    )
}

@Composable
private fun ColumnScope.NoteDescription(
    modifier: Modifier = Modifier,
    description: String,
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxSize()
            .weight(1f),
        enabled = false,
        value = description,
        onValueChange = { },
        label = {
            Text("Description")
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun DetailsScreenPreview() {
    NoteAppComposeTheme {
        DetailsScreen(
            noteId = "teste",
            onBackPressed = {},
        )
    }
}