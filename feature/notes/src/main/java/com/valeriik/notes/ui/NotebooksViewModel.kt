package com.valeriik.notes.ui

import androidx.lifecycle.ViewModel
import com.valeriik.notes.domain.GetNotebooksUseCase

class NotebooksViewModel(
    getNotebooksUseCase: GetNotebooksUseCase
): ViewModel() {
    val notebooks = getNotebooksUseCase.invoke()
}