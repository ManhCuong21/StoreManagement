package com.store.storemanagement.ui.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.store.storemanagement.screens.home.HomeScreen
import com.store.storemanagement.screens.wishlist.WishListScreen

@Stable
@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(route = Screens.Home.route)
        {
            HomeScreen()
        }
        composable(route = Screens.Favorite.route)
        {
            WishListScreen()
        }
        composable(route = Screens.Cart.route)
        {
            HomeScreen()
        }
        composable(route = Screens.Category.route)
        {
            HomeScreen()
        }
        composable(route = Screens.Profile.route)
        {
            HomeScreen()
        }
    }
}