package com.store.storemanagement.ui.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.store.storemanagement.screens.cart.CartScreen
import com.store.storemanagement.screens.home.HomeScreen
import com.store.storemanagement.screens.main.MainScreen
import com.store.storemanagement.screens.wishlist.WishListScreen

@Stable
@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Main.route
    ) {
        composable(route = Screens.Main.route)
        {
            MainScreen(navController)
        }
        composable(route = Screens.Cart.route)
        {
            CartScreen()
        }
        mainNavGraph(navController)
    }
}

fun NavGraphBuilder.mainNavGraph(navController: NavController) {
    navigation(startDestination = Screens.Home.route, route = Screens.Main.route) {
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
            CartScreen()
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