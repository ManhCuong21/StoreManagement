package com.store.storemanagement.ui.navigations

sealed class Screens(var route: String) {
    object  Home : Screens("home_screen")
    object  Favorite : Screens("favorite_screen")
    object  Cart : Screens("cart_screen")
    object  Profile : Screens("profile_screen")
}