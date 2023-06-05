package pbs.edu.lab12.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import pbs.edu.lab12.data.NotesDataSource
import pbs.edu.lab12.model.Note

class NoteViewModel: ViewModel() {
    private var noteList = mutableStateListOf<Note>()
    init {
        noteList.addAll(NotesDataSource().loadNotes())
    }
    fun addNote(note:Note) {
        noteList.add(note)
    }
    fun removeNote(note:Note) {
        noteList.remove(note)
        Log.d("xd", "cos robi")
    }
    fun getAllNotes():List<Note> {
        return noteList
    }
}