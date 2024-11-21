package com.valeriik.notes.domain

import com.valeriik.notes.data.NotebookRepository
import com.valeriik.notes.domain.model.NoteBook
import com.valeriik.core.feature.state.AppState
import kotlinx.coroutines.flow.Flow

class GetNotebooksUseCase(
    val notebookRepository: NotebookRepository,
) {
    operator fun invoke(): Flow<AppState<List<NoteBook>, String>> = notebookRepository.fetchNotebooks()
}