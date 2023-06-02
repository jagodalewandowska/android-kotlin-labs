package pbs.edu.lab11

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import pbs.edu.lab11.data.NotesDataSource
import pbs.edu.lab11.model.Note
import pbs.edu.lab11.screen.NoteScreen
import pbs.edu.lab11.screen.NoteViewModel
import pbs.edu.lab11.ui.theme.Lab11Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab11Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val noteViewModel:NoteViewModel by viewModels()
                    NotesApp(noteViewModel=noteViewModel)
                }
            }
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel= viewModel())
{
    val notesList = noteViewModel.getAllNotes()
    NoteScreen(notes = notesList,
        onAddNotes = {
            noteViewModel.addNote(it)
                     },
        onRemoveNote = {
            noteViewModel.removeNote(it)
        })
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab11Theme {
        Greeting("Android")
    }
}