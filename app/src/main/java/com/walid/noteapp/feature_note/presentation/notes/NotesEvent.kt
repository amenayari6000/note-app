package com.walid.noteapp.feature_note.presentation.notes

import com.walid.noteapp.feature_note.domain.model.Note
import com.walid.noteapp.feature_note.domain.util.NoteOrdre

sealed class NotesEvent {
     data class Ordre(val noteOrdre: NoteOrdre):NotesEvent()
    data class DeletNote(val note:Note):NotesEvent()
    object RestoreNote:NotesEvent()
    object ToggleOrdreSection:NotesEvent()


}