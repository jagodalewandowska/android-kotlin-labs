package utp.edu.lab9.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import utp.edu.lab9.PhotoRow
import utp.edu.lab9.navigation.PhotoScreens

@Composable
fun HomeScreen(navController: NavController)
{
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
                Text(text = "Photos")
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
                photoList: List<String> = listOf(
                    "Anglia",
                    "Niemcy",
                    "Polska",
                    "Francja"
                )
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