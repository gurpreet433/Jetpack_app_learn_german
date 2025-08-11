package jetpack.compose.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import jetpack.compose.myapplication.navigation.Screen
import jetpack.compose.myapplication.ui.theme.MyApplicationTheme

@Composable
fun SettingsScreen (navController: NavController) {
    Column {
        Text("ProfileScreen Screen")
        Button(onClick = {navController.navigate(Screen.SettingsSub.passMessage("Hello from Settings!"))}) {
            Text("Go to setting sub screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    MyApplicationTheme {
        val navController = rememberNavController()
        SettingsScreen(navController)
    }
}