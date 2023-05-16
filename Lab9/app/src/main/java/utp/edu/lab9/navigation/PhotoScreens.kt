package utp.edu.lab9.navigation

enum class PhotoScreens {
    HomeScreen,
    DetailsScreen;
    companion object {
        fun fromRoute(route:String?):PhotoScreens =
            when (route?.substringBefore(delimiter ="/"))
            {
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognized")
            }
    }
}
