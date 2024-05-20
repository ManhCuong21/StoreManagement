package com.store.storemanagement.ui.components.home.navigationdrawer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    onItemClick: (String) -> Unit
) {
    ListNavigationDrawer(navigationDrawerItems, onItemClick = onItemClick)
}

val navigationDrawerItems = listOf(
    NavigationDrawerItem(
        title = Screens.Home.title,
        route = Screens.Home.route,
        selectedIcon = Screens.Home.icon,
        unSelectedIcon = Screens.Home.iconFocused,
        contentDescription = ""
    ),
    NavigationDrawerItem(
        title = Screens.Product.title,
        route = Screens.Product.route,
        selectedIcon = Screens.Product.icon,
        unSelectedIcon = Screens.Product.iconFocused,
        contentDescription = ""
    ),
    NavigationDrawerItem(
        title = Screens.Featured.title,
        route = Screens.Featured.route,
        selectedIcon = Screens.Featured.icon,
        unSelectedIcon = Screens.Featured.iconFocused,
        contentDescription = ""
    ),
    NavigationDrawerItem(
        title = Screens.Profile.title,
        route = Screens.Profile.route,
        selectedIcon = Screens.Profile.icon,
        unSelectedIcon = Screens.Profile.iconFocused,
        contentDescription = ""
    )
)