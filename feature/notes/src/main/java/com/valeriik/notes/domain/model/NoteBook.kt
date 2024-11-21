package com.valeriik.notes.domain.model

import java.util.Date
import java.util.UUID

data class NoteBook(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val date: Date,
    val notes: List<Note> = emptyList()
)