package com.store.storemanagement.ui.components.home.navigationdrawer

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationDrawerItem(
    val title: String,
    val route: String,
    val selectedIcon: Int,
    val unSelectedIcon: Int,
    val contentDescription: String
)