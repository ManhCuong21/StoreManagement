package com.store.storemanagement.ui.components.home.listoutstanding

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DotsIndicator(
    count: Int,
    pagerState: PagerState,
    modifier: Modifier
) {
    val circleSpacing = 8.dp
    val circleSize = 16.dp
    val innerCircle = 14.dp

    fun PagerState.calculateCurrentOffsetForPage(page: Int): Float {
        return (currentPage - page) + currentPageOffsetFraction
    }

    Canvas(modifier = modifier.height(48.dp)) {
        val distance = (circleSize + circleSpacing).toPx()

        val centerX = size.width / 2
        val centerY = size.height / 2

        val totalWidth = distance * count
        val startX = centerX - (totalWidth / 2) + (circleSize / 2).toPx()

        rotate(degrees = 90F) {
            repeat(count) {
                val pageOffset = pagerState.calculateCurrentOffsetForPage(it)

                val alpha = 0.8f.coerceAtLeast(1 - pageOffset.absoluteValue)
                val scale = 1f.coerceAtMost(pageOffset.absoluteValue)

                val x = startX + (it * distance)
                val circleCenter = Offset(x, centerY)
                val radius = circleSize.toPx() / 2
                val innerRadius = (innerCircle.toPx() * scale) / 2

                drawCircle(
                    color = Color(0xFF006C51), center = circleCenter,
                    radius = radius, alpha = alpha,
                )

                drawCircle(color = Color.White, center = circleCenter, radius = innerRadius)
            }
        }
    }
}