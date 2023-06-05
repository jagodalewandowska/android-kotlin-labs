package pbs.edu.lab12.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pbs.edu.lab12.model.Note
import pbs.edu.lab12.util.DateConverter
import pbs.edu.lab12.util.UUIDConverter
@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}