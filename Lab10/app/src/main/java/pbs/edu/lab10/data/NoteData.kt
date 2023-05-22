package pbs.edu.lab10
import pbs.edu.lab10.model.Note

class NotesDataSource {
    fun loadNotes():List<Note> {
        return listOf(
            Note(title = "Mobilne", description = "Wykład"),
            Note(title = "Skarbowi Państwa", description = "Ministerstwo Finansów do przesyłania klientom e-paragonu na telefon.")
        )
    }
}