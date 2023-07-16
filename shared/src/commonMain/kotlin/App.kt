import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.ConsumptionTiles
import ui.Tile
import ui.TileData
import ui.TileSize
import ui.VOV

@OptIn(ExperimentalResourceApi::class, ExperimentalFoundationApi::class)
@Composable
fun App() {
    MaterialTheme {
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            ConsumptionTiles(
                listOf(
                    Consumption("Data", 90.9f, 100f, "GB"),
                    Consumption("Minutes", 334f, 1000f, "Min."),
                    Consumption("Social", 113f, 400f, "MB")
                )
            )
            Row(Modifier.padding(16.dp).fillMaxWidth().height(150.dp)) {
                Tile(
                    Modifier.fillMaxWidth(.5f).fillMaxHeight(),
                    TileData(
                        "Mobile Costs",
                        "Additional connection costs",
                        TileSize.MEDIUM,
                        "11.30 €"
                    )
                )
                Spacer(Modifier.width(16.dp))
                Column {
                    Tile(
                        Modifier.height(67.dp).fillMaxWidth(),
                        TileData("Partnercards", "Save together", TileSize.SMALL), Color.Red,
                        Color.White
                    )
                    Spacer(Modifier.height(16.dp))
                    Tile(
                        Modifier.height(67.dp).fillMaxWidth(),
                        TileData("Vodafone Happy", "Dein vorteilsprogramm", TileSize.SMALL),
                        Color.Red,
                        Color.White
                    )
                }
            }

            Text(modifier = Modifier.padding(16.dp).align(Alignment.Start),
                text = "More for you", fontSize = 24.sp,
                style = TextStyle(fontWeight = FontWeight.ExtraBold)
            )

            VOV(listOf("vov-1.jpg","vov-2.jpg","vov-3.jpg","vov-4.png"))


            Button(onClick = {
                greetingText = "Hello, ${getPlatformName()}"
                showImage = !showImage
            }) {
                Text(greetingText)
            }
            AnimatedVisibility(showImage) {
                Image(
                    painterResource("compose-multiplatform.xml"),
                    null
                )
            }

        }
    }
}

expect fun getPlatformName(): String

data class Consumption(val title: String, val usage: Float, val total: Float, val unit: String)