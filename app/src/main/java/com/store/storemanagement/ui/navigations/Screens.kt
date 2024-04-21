package com.store.storemanagement.ui.navigations

import androidx.annotation.DrawableRes
import com.store.storemanagement.R

sealed class Screens(
    val route: String,
    val title: String,
    @DrawableRes val icon: Int? = null,
    @DrawableRes val iconFocused: Int? = null
) {
    data object Main : Screens(
        route = "main_screen",
        title = "Main"
    )

    data object Home : Screens(
        route = "home_screen",
        title = "Home",
        icon = R.drawable.ic_home_24,
        iconFocused = R.drawable.ic_home_24
    )

    data object Favorite : Screens(
        route = "favorite_screen",
        title = "Wishlist",
        icon = R.drawable.baseline_favorite_border_24,
        iconFocused = R.drawable.baseline_favorite_border_24
    )

    data object Cart : Screens(
        route = "cart_screen",
        title = "Cart",
        icon = R.drawable.ic_shopping_cart_24,
        iconFocused = R.drawable.ic_shopping_cart_24
    )

    data object Category : Screens(
        route = "category_screen",
        title = "Category",
        icon = R.drawable.ic_category_24,
        iconFocused = R.drawable.ic_category_24
    )

    data object Profile : Screens(
        route = "profile_screen",
        title = "Profile",
        icon = R.drawable.ic_account_circle_24,
        iconFocused = R.drawable.ic_account_circle_24
    )
}