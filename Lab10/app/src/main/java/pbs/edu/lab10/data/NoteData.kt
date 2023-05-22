package pbs.edu.lab10.data
import pbs.edu.lab10.model.Note

class NotesDataSource {
    fun loadNotes():List<Note> {
        return listOf(
            Note(title = "Mobilne", description = "Wykład"),
            Note(title = "Notatka", description = "Opis notatki")
        )
    }
}