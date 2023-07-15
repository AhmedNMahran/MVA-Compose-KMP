package ui

import Consumption
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Tile(consumption: Consumption) {
    Card(modifier = Modifier.fillMaxWidth().height(150.dp).padding(16.dp)) {
        Row {
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = consumption.title, style = TextStyle(fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.height(20.dp))
                LinearProgressIndicator(
                    progress = consumption.usage.div(consumption.total),
                    color = Color.Red,
                    backgroundColor = Color.Red.copy(alpha = 0.25f),
                    modifier = Modifier.fillMaxWidth(.9f)
                )
                Text(
                    text = "${consumption.usage}/${consumption.total} ${consumption.unit}",
                    style = TextStyle(fontWeight = FontWeight.Medium)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}