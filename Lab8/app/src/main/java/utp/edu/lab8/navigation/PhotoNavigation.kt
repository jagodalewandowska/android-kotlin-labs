package utp.edu.lab8.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import utp.edu.lab8.screens.details.DetailsScreen
import utp.edu.lab8.screens.home.HomeScreen

@Preview
@Composable
fun PhotoNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = PhotoScreens.HomeScreen.name
    ) {
        composable(PhotoScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(
            PhotoScreens.DetailsScreen.name + "/{photo}",
            arguments = listOf(navArgument(name = "photo") {type = NavType.StringType})
        ) {
            backStackEntry ->
                DetailsScreen(
                    navController = navController,
                    backStackEntry.arguments?.getString("photo")
                )
        }
    }
}