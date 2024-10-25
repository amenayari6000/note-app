package com.walid.noteapp.di

import android.app.Application
import androidx.room.Room
import com.walid.noteapp.feature_note.data.data_source.NoteDataBase
import com.walid.noteapp.feature_note.data.repostory.NoteRepositoryImpl
import com.walid.noteapp.feature_note.domain.repository.NoteRepository
import com.walid.noteapp.feature_note.domain.use_case.AddNote
import com.walid.noteapp.feature_note.domain.use_case.DeletNote
import com.walid.noteapp.feature_note.domain.use_case.GetNote
import com.walid.noteapp.feature_note.domain.use_case.GetNotes
import com.walid.noteapp.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app:Application):NoteDataBase{

        return Room.databaseBuilder(
                app,
                NoteDataBase::class.java,
        NoteDataBase.database_NAME

        ).build()
        }
    @Provides
    @Singleton
    fun provideNoteRepository(db:NoteDataBase):NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }
    @Provides
    @Singleton
    fun provideNoteUseCase(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deletNote=DeletNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )

    }
    }

