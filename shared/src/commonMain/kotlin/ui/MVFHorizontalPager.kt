package ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VOV(items: List<String>) {
    val pagerState = rememberPagerState()
    HorizontalPager(pageCount = items.size, state = pagerState) { index ->
        Box(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Transparent),
            contentAlignment = Alignment.Center
        ) {
            VovItem(items[index])
        }
    }
}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun VovItem(imageName: String){
    Card (modifier = Modifier.padding(16.dp).fillMaxWidth().height(150.dp), elevation = 8.dp){
        Image(
            painterResource(imageName),
            null,Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds
        )
    }
}

