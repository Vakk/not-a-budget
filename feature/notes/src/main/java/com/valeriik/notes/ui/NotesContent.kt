package com.valeriik.notes.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.valeriik.core.feature.state.AnimatedStateComponent
import com.valeriik.notes.domain.model.Note
import com.valeriik.notes.domain.model.NoteBook
import com.valeriik.core.feature.state.AppState
import org.koin.androidx.compose.koinViewModel
import java.util.Date
import java.util.Locale

@Composable
fun NotesContent(
    modifier: Modifier = Modifier,
    navController: NavController,
    vm: NotebooksViewModel = koinViewModel()
) {
    val notebooks by vm.notebooks.collectAsState(AppState.Loading())

    AnimatedStateComponent(
        modifier = modifier,
        state = notebooks,
        onSuccess = {
            if (it.isEmpty()) {
                Text(modifier = modifier, text = "No notebooks found")
            } else {
                LazyColumn(modifier) {
                    items(it) {
                        NoteBookItem(noteBook = it, onClick = {
                            navController.navigate("note/${it.id}")
                        })
                    }
                }
            }
        })
}

@Composable
private fun NoteBookItem(
    noteBook: NoteBook, onClick: () -> Unit = {}
) {
    val description: String = remember(noteBook.notes.size) {
        noteBook.notes.take(3).joinToString(separator = ", ") { it.title }
    }
    val price: Double = remember(noteBook.notes) {
        noteBook.notes.sumOf { it.price }
    }
    OutlinedCard(onClick = { onClick() }) {
        ListItem(headlineContent = {
            Text(text = noteBook.title)
        }, supportingContent = if (description.length == 0) null else {
            { Text(text = description) }
        }, trailingContent = {
            Text(text = "~${String.format(Locale.getDefault(), "%.1f", price)}")
        })
    }
}

@Preview
@Composable
private fun NoteBookItem_preview() {
    NoteBookItem(
        noteBook = NoteBook(
            title = "Default shopping list",
            notes = listOf(Note(title = "Milk"), Note(title = "Bread")),
            date = Date(System.currentTimeMillis())
        )
    )
}