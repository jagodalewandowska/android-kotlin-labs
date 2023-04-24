package utp.edu.lab6

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import utp.edu.lab6.ui.theme.Lab6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun MainContent(photoList:List<String> = listOf("Anglia", "Francja", "Polska", "Niemcy")) {
    Column (modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = photoList) {
                PhotoRow(photo = it) { photo -> Log.d("TAG", "MainContent:$photo")}
            }
        }
    }
}

@Composable
fun PhotoRow(photo: String, onItemClick:(String) -> Unit = {}) {
    Card (
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick(photo)
            },
        shape = RoundedCornerShape(corner = CornerSize(26.dp)), elevation = CardDefaults.cardElevation(
            defaultElevation = 16.dp
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp), shape = RectangleShape) {
                    Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Photo image")
                }
            Text(text = photo)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab6Theme {
        Greeting("Android")
    }
}