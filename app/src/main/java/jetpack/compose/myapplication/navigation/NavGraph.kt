package jetpack.compose.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import jetpack.compose.myapplication.ui.screens.HomeScreen
import jetpack.compose.myapplication.ui.screens.ProfileScreen
import jetpack.compose.myapplication.ui.screens.SettingsScreen
import jetpack.compose.myapplication.ui.screens.SettingsSubScreen

@Composable
fun AppNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = Screen.Home.route, modifier = modifier) {

        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }

        composable(Screen.Settings.route) {
            SettingsScreen(navController)
        }

        composable(
            route = Screen.SettingsSub.route,
            arguments = listOf(navArgument("message") { type = NavType.StringType })
        ) { backStackEntry ->
            val message = backStackEntry.arguments?.getString("message") ?: ""
            SettingsSubScreen(message)
        }
    }
}


sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Profile : Screen("profile")
    data object Settings : Screen("settings")
    data object SettingsSub : Screen("settings_sub/{message}") {
        fun passMessage(message: String) = "settings_sub/$message"
    }
}
