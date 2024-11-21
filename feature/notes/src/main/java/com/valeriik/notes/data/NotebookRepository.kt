package com.valeriik.notes.data

import com.valeriik.notes.domain.model.Note
import com.valeriik.notes.domain.model.NoteBook
import com.valeriik.core.feature.state.AppState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

interface NotebookRepository {
    fun fetchNotebooks(): Flow<AppState<List<NoteBook>, String>>

    fun fetchNotebook(): Flow<AppState<NoteBook?, String>>

    fun fetchNotes(notebookId: String): Flow<AppState<List<Note>, String>>
}

class NotebookRepositoryImpl(
    val context: CoroutineContext
) : NotebookRepository {
    override fun fetchNotebooks(): Flow<AppState<List<NoteBook>, String>> = flow {
        emit(AppState.Loading())
        delay(2000)
        emit(AppState.Success(emptyList()))
    }

    override fun fetchNotes(notebookId: String): Flow<AppState<List<Note>, String>> = flow {
        emit(AppState.Loading())
        delay(2000)
        emit(AppState.Success(emptyList()))
    }

    override fun fetchNotebook(): Flow<AppState<NoteBook?, String>> = flow {
        emit(AppState.Loading())
        delay(2000)
        emit(AppState.Success(null))
    }
}