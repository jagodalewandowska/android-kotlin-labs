package utp.edu.lab8.screens.details

import android.graphics.drawable.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
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

@Composable
fun DetailsScreen(navController: NavController, photoData: String?) {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.LightGray, elevation = 5.dp) {
               Row(horizontalArrangement = Arrangement.Start) {
                   Icon(imageVector = Icons.Default.ArrowBack,
                       contentDescription = "Arrow Back",
                       Modifier.clickable {
                           navController.popBackStack()
                       })
                   Spacer(modifier = Modifier.width(50.dp))
                   Text(text = "Photos!")
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
                   Text(text = photoData.toString(), style = MaterialTheme.typography.h5)
                   Spacer(modifier = Modifier.height(23.dp))
                   Button(onClick = {navController.popBackStack()}) {
                       Text(text = "Go Back")
                   }
               }
           }
        }
    }
}