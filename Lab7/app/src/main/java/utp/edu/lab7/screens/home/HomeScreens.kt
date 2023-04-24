package utp.edu.lab7.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import utp.edu.lab7.PhotoRow
import utp.edu.lab7.navigation.PhotoScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController)
{
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Photos TopAppBar")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Magenta)
            )
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