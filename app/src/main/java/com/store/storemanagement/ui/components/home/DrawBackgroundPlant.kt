package com.store.storemanagement.ui.components.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CircleBackground() {
    val configuration = LocalConfiguration.current
    val width = (configuration.screenWidthDp / 2.5).dp
    val height = 215.dp
    val cornerRadius = 400f

    Canvas(
        Modifier
            .size(width = width, height = height)
            .clipToBounds()
    ) {
        drawOutline(
            color = Color.White,
            outline = Outline.Rounded(
                RoundRect(
                    rect = Rect(
                        offset = Offset(16.dp.toPx(), 16.dp.toPx()),
                        size = Size(
                            size.width - 32.dp.toPx(),
                            size.height * 2 - 16.dp.toPx()
                        )
                    ),
                    topLeft = CornerRadius(cornerRadius, cornerRadius),
                    topRight = CornerRadius(cornerRadius, cornerRadius)
                )
            )
        )
        drawOutline(
            color = Color.White,
            outline = Outline.Rounded(
                RoundRect(
                    rect = Rect(
                        offset = Offset(1.dp.toPx(), 4.dp.toPx()),
                        size = Size(size.width - 2.5.dp.toPx(), size.height * 2 - 12.dp.toPx())
                    ),
                    topLeft = CornerRadius(cornerRadius, cornerRadius),
                    topRight = CornerRadius(cornerRadius, cornerRadius)
                )
            ),
            style = Stroke(
                width = 3.dp.toPx(),
                cap = StrokeCap.Round
            )
        )
        drawLine(
            Color.White,
            strokeWidth = 5.dp.toPx(),
            start = Offset(0f, size.height),
            end = Offset(size.width, size.height)
        )
    }
}

@Preview
@Composable
fun PreviewCircleBackground() {
    CircleBackground()
}