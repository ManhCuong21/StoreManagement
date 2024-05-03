package com.store.storemanagement.ui.components.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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
                Text(
                    text = list[page].title,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    modifier = Modifier.width(200.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "\$${list[page].price}",
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "\$${(list[page].price * 1.2).roundToInt()}",
                        style = TextStyle(
                            textDecoration = TextDecoration.LineThrough,
                            color = Color.Gray,
                            fontStyle = FontStyle.Italic
                        )
                    )
                }
                TextButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Add, contentDescription = null)
                    Text(text = "Add")
                }
            }
        }
        Box(contentAlignment = Alignment.CenterEnd) {
            CircleBackground()
        }
    }
}

