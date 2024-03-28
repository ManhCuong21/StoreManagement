package com.store.storemanagement.ui.components.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.store.storemanagement.ui.navigations.Screens

@Composable
fun NavigationDrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Header", fontSize = 60.sp)
    }
}

@Composable
fun NavigationDrawerBody(
    modifier: Modifier = Modifier,
    onItemClick: (NavigationDrawerItem) -> Unit
) {
    LazyColumn(modifier) {
        items(navigationDrawerItems) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { onItemClick(it) }) {
                Icon(
                    imageVector = it.selectedIcon,
                    contentDescription = it.contentDescription
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = it.title,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

val navigationDrawerItems = listOf(
    NavigationDrawerItem(
        title = "Home",
        route = Screens.Home.route,
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
        contentDescription = ""
    ),
    NavigationDrawerItem(
        title = "Profile",
        route = Screens.Profile.route,
        selectedIcon = Icons.Filled.Person,
        unSelectedIcon = Icons.Outlined.Person,
        contentDescription = ""
    )
)

data class NavigationDrawerItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val contentDescription: String
)