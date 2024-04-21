package com.store.storemanagement.ui.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.store.storemanagement.screens.cart.CartScreen
import com.store.storemanagement.screens.main.MainScreen

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
    }
}