package com.store.storemanagement.ui.components.home.navigationdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.store.storemanagement.R

@Composable
fun ListNavigationDrawer(list: List<NavigationDrawerItem>, onItemClick: (String) -> Unit) {
    LazyColumn {
        items(list) { item ->
            ItemListNavigationDrawer(item, onItemClick = onItemClick)
        }
    }
}

@Composable
fun ItemListNavigationDrawer(
    item: NavigationDrawerItem,
    onItemClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onItemClick(item.route) },
        verticalAlignment = CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .padding(end = 16.dp)
                .background(MaterialTheme.colorScheme.onTertiary, RoundedCornerShape(16.dp))
                .padding(12.dp),
            painter = painterResource(id = item.selectedIcon),
            contentDescription = item.contentDescription
        )
        Text(
            text = item.title,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_navigate_next_24),
            contentDescription = item.contentDescription
        )
    }
}