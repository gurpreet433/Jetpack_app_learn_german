package jetpack.compose.myapplication.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import jetpack.compose.myapplication.ui.theme.MyApplicationTheme

@Composable
fun SettingsSubScreen(message: String) {
    Text(text = "Message received is: $message")
}

@Preview(showBackground = true)
@Composable
fun SettingsSubScreen() {
    MyApplicationTheme {
        val navController = rememberNavController()
        SettingsScreen(navController)
    }
}