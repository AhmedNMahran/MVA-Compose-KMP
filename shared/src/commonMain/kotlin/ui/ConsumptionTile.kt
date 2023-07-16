package ui

import Consumption
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun ConsumptionTile(consumption: Consumption, backgroundColor: Color = Color.Transparent) {
    Card(modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(16.dp), elevation = 4.dp) {
        Box(modifier = Modifier.padding(8.dp)) {

            Column(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = consumption.title, style = TextStyle(fontWeight = FontWeight.Light))
                Spacer(modifier = Modifier.height(16.dp))
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = "${((consumption.total - consumption.usage)*10000).roundToInt().toDouble()/10000}",
                        style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 28.sp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = consumption.unit, fontSize = 22.sp,
                        style = TextStyle(fontWeight = FontWeight.Medium)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "remaining out of ${consumption.total} ${consumption.unit}", fontSize = 12.sp,
                        style = TextStyle(fontWeight = FontWeight.Light)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = consumption.usage.div(consumption.total),
                    color = Color(0,138,0,100),
                    backgroundColor = Color(0, 8,0,0).copy(alpha = 0.25f),
                    modifier = Modifier.height(5.dp).fillMaxWidth(.9f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Available until 25 07 2023", fontSize = 12.sp,
                    style = TextStyle(fontWeight = FontWeight.Light, color = Color.Gray)
                )
            }
        }
    }
}