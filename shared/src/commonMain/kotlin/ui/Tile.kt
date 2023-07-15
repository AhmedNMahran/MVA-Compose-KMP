package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Tile(modifier: Modifier = Modifier,data: TileData, backgroundColor: Color = Color.Transparent) {
    Card(
        modifier = modifier
    ) {
        Row(modifier = Modifier.background(backgroundColor)) {
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = data.title, style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = data.description, style = TextStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 13.sp
                    )
                )
                data.largeDetail?.let {
                    if (data.size == TileSize.MEDIUM) {
                        Text(
                            text = data.largeDetail, style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

            }
        }
    }
}

data class TileData(
    val title: String,
    val description: String,
    val size: TileSize,
    val largeDetail: String? = null
)

enum class TileSize {
    SMALL, MEDIUM
}