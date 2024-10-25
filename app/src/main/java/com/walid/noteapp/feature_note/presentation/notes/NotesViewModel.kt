package com.walid.noteapp.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walid.noteapp.feature_note.domain.model.Note
import com.walid.noteapp.feature_note.domain.use_case.NoteUseCases
import com.walid.noteapp.feature_note.domain.util.NoteOrdre
import com.walid.noteapp.feature_note.domain.util.OrdreType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases


) :ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> =_state
    private var recentlyDeletNote:Note?=null
    private var getNotesJob: Job?=null
    init{
       getNotes(NoteOrdre.Date(OrdreType.Descending))
    }



    fun onEvent(event: NotesEvent) {

        when (event) {

            is NotesEvent.Ordre -> {
                if (state.value.noteOrdre::class == event.noteOrdre::class &&
                    state.value.noteOrdre.ordreType::class == event.noteOrdre.ordreType
                ) {
                    return
                }
                getNotes(event.noteOrdre)

            }

            is NotesEvent.DeletNote -> {
                viewModelScope.launch {
                    noteUseCases.deletNote(event.note)
                    recentlyDeletNote = event.note
                }


            }

            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(recentlyDeletNote ?: return@launch)
                    recentlyDeletNote = null

                }

            }

            is NotesEvent.ToggleOrdreSection -> {
                _state.value = state.value.copy(
                    isOrdreSectionVisible = !state.value.isOrdreSectionVisible
                )

            }
        }

    }

    private fun getNotes(noteOrdre: NoteOrdre) {
        getNotesJob?.cancel()

       getNotesJob = noteUseCases.getNotes(noteOrdre)
            .onEach { notes ->

                _state.value = state.value.copy(
                    notes =notes,
                    noteOrdre = noteOrdre
                )
            }
            .launchIn(viewModelScope)

    }

}
