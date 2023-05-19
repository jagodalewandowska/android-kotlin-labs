package utp.edu.lab9.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import utp.edu.lab9.navigation.PhotoScreens
import utp.edu.lab9.model.Photo
import utp.edu.lab9.model.getPhotos
import utp.edu.lab9.widgets.PhotoRow

@Composable
fun HomeScreen(navController: NavController)
{
    val myRed = Color(0xff830e21);
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = myRed, elevation = 5.dp) {
                Text(text = " Zdjęcia z wakacji", style = MaterialTheme.typography.h6,
                    color = Color.White)
            }
        },
    ) { it -> Column (
        modifier = Modifier
            .padding(it)) {
            MainContent(navController = navController)
        }
    }
}

@Composable
fun MainContent(navController: NavController,
                photoList: List<Photo> = getPhotos()
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = photoList) {
                PhotoRow(photo = it) {
                    photo -> navController.navigate(route = PhotoScreens.DetailsScreen.name + "/$photo")
                }
            }
        }
    }
}