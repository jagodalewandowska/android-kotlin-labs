package utp.edu.lab6.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import utp.edu.lab6.MainContent

@Composable
fun HomeScreen(navController: NavController)
{
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
                Text(text = "Photos TopAppBar")
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
fun MainContent(navController: navController,
photoList: List<S>)