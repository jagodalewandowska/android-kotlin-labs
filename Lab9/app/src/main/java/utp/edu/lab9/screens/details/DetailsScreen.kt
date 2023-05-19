package utp.edu.lab9.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import utp.edu.lab9.model.Photo
import utp.edu.lab9.model.getPhotos
import utp.edu.lab9.widgets.PhotoRow

@SuppressLint("UnusedMateralScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController, photoId: Int?) {
    val myRed = Color(0xff830e21);
    val newPhotoList = getPhotos().filter{photo -> photo.id == photoId}
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = myRed, elevation = 5.dp) {
               Row(horizontalArrangement = Arrangement.Start) {
                   Icon(imageVector = Icons.Default.ArrowBack,
                       contentDescription = "Arrow Back",
                       Modifier.clickable {
                           navController.popBackStack()
                       })
                   Spacer(modifier = Modifier.width(50.dp))
                   Text(text = "Zdjęcia", style = MaterialTheme.typography.h6,
                       color = Color.White)
               }
            }
        },
    ) { it ->
        Column(
            modifier = Modifier.padding(it)
        ) {
           Surface(
               modifier = Modifier
                   .fillMaxHeight()
                   .fillMaxWidth()
           ) {
               Column(
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Center
               ) {
                   PhotoRow(photo = newPhotoList.first())
                   Text(text = newPhotoList[0].title, style = MaterialTheme.typography.h5)
                   Spacer(modifier = Modifier.height(8.dp))
                   Divider()
                   Text(text = "Galeria zdjęć")
                   HorizontalScrollableImageView(newPhotoList)
               }
           }
        }
    }
}

@Composable
private fun HorizontalScrollableImageView(newPhotoList: List<Photo>) {
    LazyRow {
        items(newPhotoList[0].images) {
                image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp), elevation = 5.dp
            ) {
                val painter = rememberAsyncImagePainter(image)
                val state = painter.state
                if (state is AsyncImagePainter.State.Success) {
                    // Perfom the transition animation
                }
                Image (
                    painter = painter,
                    contentDescription = "Photo Poster"
                )
                Image (
                    painter = rememberImagePainter(data = image),
                    contentDescription = "Photo Poster"
                )
            }
        }
    }
}