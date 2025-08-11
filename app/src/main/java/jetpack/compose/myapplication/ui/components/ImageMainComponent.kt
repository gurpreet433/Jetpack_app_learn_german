package jetpack.compose.myapplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jetpack.compose.myapplication.R

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    imageResId: Int,
    heading: String,
    subheading: String,
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)

    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {

                Text(
                    text = heading,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = subheading,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
                )

                Button(onClick = onButtonClick) {
                    Text(buttonText)
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ImageCardPreview() {
    ImageCard(
        imageResId = R.drawable.ic_launcher_background,
        heading = "Welcome to Jetpack Compose",
        subheading = "Build beautiful native apps",
        buttonText = "Get Started",
        onButtonClick = {}
    )
}