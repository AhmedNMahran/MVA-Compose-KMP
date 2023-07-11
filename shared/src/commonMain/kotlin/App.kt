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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
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

@OptIn(ExperimentalResourceApi::class, ExperimentalFoundationApi::class)
@Composable
fun App() {
    MaterialTheme {
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            ConsumptionTiles()
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

@ExperimentalFoundationApi
@Composable
fun ConsumptionTiles() {
    val list = listOf(
        Consumption("Data", 90.9f,100f,"GB"),
        Consumption("Minutes", 334f,1000f,"Min."),
        Consumption("Social", 113f,400f,"MB")
    )
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(items = list, itemContent = { item ->
            Tile(item)
        })
    }
}
@Composable
fun Tile(consumption: Consumption) {
    Card(modifier = Modifier.fillMaxWidth().height(150.dp).padding(16.dp)) {
        Row {
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.fillMaxWidth(.8f)) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = consumption.title, style = TextStyle(fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.height(20.dp))
                LinearProgressIndicator(progress = consumption.usage.div(consumption.total), color = Color.Red,
                    backgroundColor = Color.Red.copy(alpha = 0.25f), modifier = Modifier.fillMaxWidth(.9f))
                Text(text = "${consumption.usage}/${consumption.total} ${consumption.unit}",
                    style = TextStyle(fontWeight = FontWeight.Medium))
                Spacer(modifier = Modifier.height(16.dp))
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

expect fun getPlatformName(): String

data class Consumption(val title: String,val usage: Float, val total: Float, val unit: String)