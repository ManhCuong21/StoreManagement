package com.store.storemanagement.ui.components.home.listoutstanding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.store.storemanagement.domain.model.Plant
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListOutstandingPlant(list: List<Plant>) {
    val pagerState = rememberPagerState(0) { list.size }
    Box(Modifier.fillMaxSize()) {
        HorizontalPager(state = pagerState) { page ->
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "Indoor Plants",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = list[page].title,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    modifier = Modifier.width(200.dp)
                )
                Row(
                    modifier = Modifier.padding(vertical = 18.dp),
                    verticalAlignment = CenterVertically
                ) {
                    Text(
                        text = "\$${list[page].price}",
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = 26.sp,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "\$${(list[page].price * 1.2).roundToInt()}",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Gray,
                        textDecoration = TextDecoration.LineThrough,
                        fontStyle = FontStyle.Italic
                    )
                }
                TextButton(
                    modifier = Modifier.background(
                        MaterialTheme.colorScheme.primary,
                        RoundedCornerShape(16)
                    ), onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Add, contentDescription = null, tint = Color.White)
                    Text(
                        text = "ADD",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
        Row(modifier = Modifier.align(Alignment.BottomEnd)) {
            CircleBackground(imageUrl = list[pagerState.currentPage].image)
            DotsIndicator(
                count = list.size,
                pagerState = pagerState,
                modifier = Modifier
                    .align(CenterVertically)
                    .padding(20.dp)
            )
        }
    }
}