package com.valeriik.notes.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.valeriik.notes.domain.model.Note
import com.valeriik.notes.domain.model.NoteBook

@Composable
fun NotebookItemsScreen(noteBook: NoteBook) {
    Scaffold(
        topBar = { Text(noteBook.title) }
    ) { paddingValue ->
        LazyColumn(modifier = Modifier.padding(paddingValue).fillMaxSize()) {
            items(noteBook.notes) {
                NoteItem(note = it)
            }
        }
    }
}

@Composable
private fun NoteItem(note: Note) {
    ListItem(headlineContent = { Text(note.title) })
}

@Preview
@Composable
private fun NoteItem_preview() {
    NoteItem(note = Note(title = "Milk"))
}