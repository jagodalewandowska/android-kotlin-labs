package pbs.edu.lab11.data
import pbs.edu.lab11.model.Note

class NotesDataSource {
    fun loadNotes():List<Note> {
        return listOf(
            Note(title = "Mobilne", description = "Wykład"),
            Note(title = "Notatka", description = "Opis notatki")
        )
    }
}