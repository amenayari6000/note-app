package com.walid.noteapp.feature_note.domain.util

 sealed class NoteOrdre(val ordreType: OrdreType) {
     class Title(ordreType: OrdreType):NoteOrdre(ordreType)
     class Date(ordreType: OrdreType):NoteOrdre(ordreType)
     class Color(ordreType: OrdreType):NoteOrdre(ordreType)

     fun copy(ordreType: OrdreType):NoteOrdre {
         return when (this ){
             is Title->Title(ordreType)
             is Date ->Date(ordreType)
             is Color->Color(ordreType)
         }
     }



}