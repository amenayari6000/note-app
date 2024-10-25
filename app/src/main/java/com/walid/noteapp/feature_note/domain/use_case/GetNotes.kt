package com.walid.noteapp.feature_note.domain.use_case

import com.walid.noteapp.feature_note.domain.model.Note
import com.walid.noteapp.feature_note.domain.repository.NoteRepository
import com.walid.noteapp.feature_note.domain.util.NoteOrdre
import com.walid.noteapp.feature_note.domain.util.OrdreType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private val repository:NoteRepository

) {

    operator fun invoke(
        noteOrdre: NoteOrdre = NoteOrdre.Date(OrdreType.Descending)
    ): Flow<List<Note>> {

        return repository.getNotes().map { notes ->
            when (noteOrdre.ordreType) {
                is OrdreType.Ascending -> {
                    when (noteOrdre) {
                        is NoteOrdre.Title -> notes.sortedBy { it.title }
                        is NoteOrdre.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrdre.Color -> notes.sortedBy { it.color }
                    }
                }

                is OrdreType.Descending -> {
                    when (noteOrdre) {
                        is NoteOrdre.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrdre.Date -> notes.sortedByDescending  { it.timestamp }
                        is NoteOrdre.Color -> notes.sortedByDescending { it.color }

                    }
                }
            }

        }


    }
}