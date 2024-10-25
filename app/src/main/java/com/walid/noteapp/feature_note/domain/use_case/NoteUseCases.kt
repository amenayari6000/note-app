package com.walid.noteapp.feature_note.domain.use_case

data class NoteUseCases (
val getNotes: GetNotes,
    val deletNote: DeletNote,
    val addNote: AddNote,
    val getNote: GetNote

)
