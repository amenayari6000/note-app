package com.walid.noteapp.feature_note.presentation.notes.compoents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.walid.noteapp.feature_note.domain.util.NoteOrdre
import com.walid.noteapp.feature_note.domain.util.OrdreType

@Composable

fun OrderSection(
    modifier: Modifier=Modifier,
    noteOrdre: NoteOrdre=NoteOrdre.Date(OrdreType.Descending),
    onOrderChange:(NoteOrdre)->Unit

){
    Column(
        modifier=modifier

    ) {
        Row(
            modifier=Modifier.fillMaxWidth()
        ){
            DefaultRadioButton(
                text="Title",
                selected=noteOrdre is NoteOrdre.Title,
                onSelected = { onOrderChange(NoteOrdre.Title(noteOrdre.ordreType))}
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text="Date",
                selected=noteOrdre is NoteOrdre.Date,
                onSelected = { onOrderChange(NoteOrdre.Date(noteOrdre.ordreType))}
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text="Color",
                selected=noteOrdre is NoteOrdre.Color,
                onSelected = { onOrderChange(NoteOrdre.Color(noteOrdre.ordreType))}
            )
        }

        Spacer(modifier=Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
            // Inmportant to show the second row fillMaxWidth()
        ){
            DefaultRadioButton(
                text="Ascending",
                selected=noteOrdre.ordreType is OrdreType.Ascending,
                onSelected = {
                    onOrderChange(noteOrdre.copy(OrdreType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text="Descending",
                selected=noteOrdre.ordreType is OrdreType.Descending,
                onSelected = {
                    onOrderChange(noteOrdre.copy(OrdreType.Descending))
                }
            )
        }

    }

}