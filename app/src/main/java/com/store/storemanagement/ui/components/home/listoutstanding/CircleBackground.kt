package com.store.storemanagement.ui.components.home.listoutstanding

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun CircleBackground(imageUrl: String) {
    val configuration = LocalConfiguration.current
    val width = (configuration.screenWidthDp / 2.5).dp
    val height = 250.dp
    val cornerRadius = 400f
    Box(contentAlignment = Alignment.BottomCenter) {
        Canvas(
            Modifier
                .size(width = width, height = height - 60.dp)
                .clipToBounds()
        ) {
            drawOutline(
                color = Color.White,
                outline = Outline.Rounded(
                    RoundRect(
                        rect = Rect(
                            offset = Offset(16.dp.toPx(), 20.dp.toPx()),
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
        AnimatedContent(
            targetState = imageUrl,
            transitionSpec = {
                fadeIn(
                    animationSpec = tween(1200)
                ) togetherWith fadeOut(animationSpec = tween(1200))
            },
            modifier = Modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {

            },
            label = "Animated Image"
        ) { imageUrl ->
            AsyncImage(
                modifier = Modifier
                    .size(width, height),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Preview
@Composable
fun PreviewCircleBackground() {
    CircleBackground("https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic1.png")
}