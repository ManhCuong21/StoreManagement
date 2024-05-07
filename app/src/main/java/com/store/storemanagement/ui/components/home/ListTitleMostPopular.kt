package com.store.storemanagement.ui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.store.storemanagement.domain.model.TitleMostPopularPlant

fun LazyListScope.listTitleMostPopular(
    item: List<TitleMostPopularPlant>,
    selectedIndex: Int,
    clickAction: (Int) -> Unit
) {
    itemsIndexed(item) { index, list ->
        ItemListTitleMostPopular(list,
            selected = selectedIndex == index,
            clickAction = { clickAction(index) })
    }
}

@Composable
fun ItemListTitleMostPopular(
    item: TitleMostPopularPlant,
    selected: Boolean = false,
    clickAction: () -> Unit
) {
    ClickableText(
        text = AnnotatedString(item.title),
        modifier = Modifier
            .padding(end = 8.dp)
            .width(70.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onTertiary)
            .padding(8.dp),
        onClick = { clickAction() },
        style = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = if (selected) MaterialTheme.colorScheme.onTertiary else MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}