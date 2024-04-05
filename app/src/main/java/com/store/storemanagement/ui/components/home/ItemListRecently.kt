package com.store.storemanagement.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.store.storemanagement.R
import com.store.storemanagement.domain.model.CategoryPlant
import com.store.storemanagement.domain.model.Plant

@Composable
fun ItemListRecently(item: Plant) {
    Column(
        Modifier
            .width(IntrinsicSize.Min)
            .padding(start = 8.dp, end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(MaterialTheme.colorScheme.onTertiary)
                .padding(horizontal = 32.dp, vertical = 16.dp)
        ) {
            AsyncImage(
                modifier = Modifier.size(110.dp, 192.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.title,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                text = "\$${item.price}",
                style = TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "\$${item.price * 1.2}",
                style = TextStyle(
                    textDecoration = TextDecoration.LineThrough,
                    color = Color.Gray,
                    fontStyle = FontStyle.Italic
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewItemListRecently() {
    ItemListRecently(
        Plant(
            "Royal Bluebell Bliss (M)",
            "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic4.png",
            CategoryPlant("", ""),
            80
        )
    )
}