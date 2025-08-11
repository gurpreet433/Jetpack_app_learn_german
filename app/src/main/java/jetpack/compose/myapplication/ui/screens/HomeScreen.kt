package jetpack.compose.myapplication.ui.screens

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import jetpack.compose.myapplication.R
import jetpack.compose.myapplication.ui.components.ImageCard
import jetpack.compose.myapplication.ui.components.ImageTileSmall
import jetpack.compose.myapplication.ui.theme.MyApplicationTheme

@Composable
fun HomeScreen(navController: NavController) {

        val name = "Shahid"
        val greeting = stringResource(id = R.string.greetings)
        var count by remember { mutableIntStateOf(0) }

        var selectedTabIndex by remember { mutableIntStateOf(1) }
        val tabs = listOf("Speaking", "Listening", "Writing", "Reading")

        Column(modifier = Modifier.fillMaxWidth()
            .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$greeting $name!",
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Button(onClick = { count++ }) {
                    Text("🔥 $count")
                }
            }

            TabRow(selectedTabIndex = selectedTabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(title) }
                    )
                }
            }

            ImageCard(
                imageResId = R.drawable.ic_launcher_background,
                heading = "Welcome to Jetpack Compose",
                subheading = "Build beautiful native apps",
                buttonText = "Get Started",
                onButtonClick = {}
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(5) { index ->
                    ImageTileSmall(
                        imageResId = R.drawable.ic_launcher_background,
                        heading = "Heading $index",
                        subheading = "Subheading $index",
                        buttonText = "Click",
                        onButtonClick = {}
                    )
                }
            }

            Text(
                text = "Second heading",
                fontSize = 15.sp
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(5) { index ->
                    ImageTileSmall(
                        imageResId = R.drawable.ic_launcher_background,
                        heading = "Heading $index",
                        subheading = "Subheading $index",
                        buttonText = "Click",
                        onButtonClick = {}
                    )
                }
            }

            Text(
                text = "Second heading",
                fontSize = 15.sp
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(5) { index ->
                    ImageTileSmall(
                        imageResId = R.drawable.ic_launcher_background,
                        heading = "Heading $index",
                        subheading = "Subheading $index",
                        buttonText = "Click",
                        onButtonClick = {}
                    )
                }
            }
        }

}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyApplicationTheme {
        val navController = rememberNavController()
        HomeScreen(navController)
    }
}