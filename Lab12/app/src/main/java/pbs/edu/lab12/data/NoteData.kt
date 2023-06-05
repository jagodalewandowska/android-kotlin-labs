package pbs.edu.lab12.data
import pbs.edu.lab12.model.Note

class NotesDataSource {
    fun loadNotes():List<Note> {
        return listOf(
            Note(title = "Mobilne", description = "Wykład"),
            Note(title = "Notatka", description = "Opis notatki")
        )
    }
}