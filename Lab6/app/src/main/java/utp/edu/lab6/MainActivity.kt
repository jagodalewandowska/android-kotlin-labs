package utp.edu.lab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
fun MainContent(photoList:List<String> = listOf("Anglia", "Francja", "Polska")) {
    Column (modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = photoList) {
                PhotoRow(photo = it) { photo -> Log.d("TAG", "MainContent:$photo")}
            }
        }
    }
}

@Composable
fun PhotoRow(photo: String, onItemClick(String) -> Unit = {}) {
    Card (
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick(photo)
            },
        shape = RoundedCornerShape(corner = CornerSize(26.dp)), elevation = 16.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(12,dp)
                .size(100.dp), shape = RectangleShape,
                elevation = 4.dp {
                    Icon(imageVector = Icnos.Default.AccountBox, contentDescription = "Photo image")
                }
                        Text(text = photo)
            )
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