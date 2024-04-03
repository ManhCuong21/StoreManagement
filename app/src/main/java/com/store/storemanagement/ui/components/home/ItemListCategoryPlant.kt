package com.store.storemanagement.ui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.store.storemanagement.domain.model.CategoryPlant
import com.store.storemanagement.ui.theme.StoreManagementTheme

@Composable
fun ItemListCategoryPlant(item: CategoryPlant) {
    Column(
        Modifier
            .padding(end = 10.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.onTertiary)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = item.title,
            style = MaterialTheme.typography.labelMedium
        )
        AsyncImage(
            modifier = Modifier
                .size(155.dp, 200.dp)
                .padding(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(item.image)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview
@Composable
fun PreviewItemListCategoryPlant() {
    StoreManagementTheme {
        ItemListCategoryPlant(
            item = CategoryPlant(
                "Indoor Plants",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/category/pic1.png"
            )
        )
    }
}