package com.store.storemanagement.ui.components.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun BannerImageHome() {
    Row(
        Modifier
            .padding(horizontal = 16.dp)
            .height(IntrinsicSize.Min)
    ) {
        Column(
            Modifier
                .weight(3f, true)
                .fillMaxSize()
        ) {
            Row(
                Modifier
                    .weight(4f, true)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            ) {
                AsyncImage(
                    modifier = Modifier.weight(1f, true),
                    model = "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/gallery/1.png",
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.width(8.dp))
                AsyncImage(
                    modifier = Modifier.weight(1f, true),
                    model = "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/gallery/2.png",
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                Modifier
                    .weight(3f, true)
                    .fillMaxSize()
            ) {
                AsyncImage(
                    modifier = Modifier
                        .clip(RoundedCornerShape(bottomEnd = 32.dp))
                        .weight(1f, true),
                    model = "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/gallery/3.png",
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.width(8.dp))
                AsyncImage(
                    modifier = Modifier
                        .clip(RoundedCornerShape(bottomStart = 32.dp))
                        .weight(1f, true),
                    model = "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/gallery/4.png",
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        AsyncImage(
            modifier = Modifier
                .height(170.dp)
                .weight(2f, true)
                .clip(RoundedCornerShape(topStart = 300.dp, topEnd = 300.dp)),
            model = "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/gallery/5.png",
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Column(
            Modifier
                .weight(1.5f)
                .padding(start = 8.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
                    .clip(RoundedCornerShape(100.dp)),
                model = "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/gallery/6.png",
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.3f)
                    .clip(RoundedCornerShape(topStart = 100.dp, topEnd = 100.dp)),
                model = "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/gallery/7.png",
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}