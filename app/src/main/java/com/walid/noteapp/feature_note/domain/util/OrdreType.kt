package com.walid.noteapp.feature_note.domain.util

 sealed class OrdreType {
     object  Ascending : OrdreType()
     object  Descending : OrdreType()

}