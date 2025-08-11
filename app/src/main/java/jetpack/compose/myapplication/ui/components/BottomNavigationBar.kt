package jetpack.compose.myapplication.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf("home", "profile", "settings")
    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                selected = navController.currentDestination?.route == screen,
                onClick = { navController.navigate(screen) },
                icon = { Icon(Icons.Default.Home, contentDescription = null) },
                label = { Text(screen) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    val navController = rememberNavController()
    BottomNavigationBar(navController = navController)
}