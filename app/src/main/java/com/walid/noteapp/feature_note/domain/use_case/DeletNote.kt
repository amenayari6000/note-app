package com.walid.noteapp.feature_note.domain.use_case

import com.walid.noteapp.feature_note.domain.model.Note
import com.walid.noteapp.feature_note.domain.repository.NoteRepository

class DeletNote(private val repository: NoteRepository) {

suspend  operator fun invoke(note: Note){
    repository.deleteNote(note)

}

}