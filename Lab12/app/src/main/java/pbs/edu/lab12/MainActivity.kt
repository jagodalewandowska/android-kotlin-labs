package pbs.edu.lab12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import pbs.edu.lab12.screen.NoteScreen
import pbs.edu.lab12.screen.NoteViewModel
import pbs.edu.lab12.ui.theme.Lab12Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab12Theme {
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
    Lab12Theme {
        Greeting("Android")
    }
}