package utp.edu.lab8.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import utp.edu.lab8.screens.home.HomeScreen

@Preview
@Composable
fun PhotoNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
    startDestination = PhotoScreens.HomeScreen.name) {
        composable(PhotoScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
    }
}