package utp.edu.lab6.ui.theme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import utp.edu.lab6.R
import java.lang.reflect.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContent {
            Lab6Theme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                    ) {
                        Greeting("Android")
                        DefaultPreview()
                        MainContent()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting (name: String) {
    Text(text = "Hello $name!")
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