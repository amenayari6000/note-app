package com.walid.noteapp.feature_note.presentation.notes


import com.walid.noteapp.feature_note.domain.model.Note
import com.walid.noteapp.feature_note.domain.util.NoteOrdre
import com.walid.noteapp.feature_note.domain.util.OrdreType

data class NotesState (
    val notes:List<Note> = emptyList(),
    val noteOrdre: NoteOrdre = NoteOrdre.Date(OrdreType.Descending),
    val isOrdreSectionVisible:Boolean=false

    )

