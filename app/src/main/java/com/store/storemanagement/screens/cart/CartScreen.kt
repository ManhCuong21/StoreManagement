package com.store.storemanagement.screens.cart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.store.storemanagement.domain.model.Cart
import com.store.storemanagement.domain.model.CategoryPlant
import com.store.storemanagement.domain.model.Plant
import com.store.storemanagement.ui.components.cart.BottomAppBarCart
import com.store.storemanagement.ui.components.cart.ItemListCart
import com.store.storemanagement.ui.components.cart.TopAppBarCart

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavController) {
    val listCart = remember {
        mutableStateListOf(
            Cart(
                quantity = 2,
                plant = Plant(
                    1,
                    "Emerald Fern Fronds (M)",
                    "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic1.png",
                    CategoryPlant("", ""),
                    80,
                    0
                )
            ),
            Cart(
                quantity = 1,
                plant = Plant(
                    2,
                    "Scarlet Petal Paradise (M)",
                    "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic2.png",
                    CategoryPlant("", ""),
                    99,
                    0
                )
            ),
            Cart(
                quantity = 1,
                plant = Plant(
                    3,
                    "Silver Leaf Serenity (M)",
                    "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic3.png",
                    CategoryPlant("", ""),
                    49,
                    0
                )
            ),
            Cart(
                quantity = 1,
                plant = Plant(
                    4,
                    "Royal Bluebell Bliss (M)",
                    "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic4.png",
                    CategoryPlant("", ""),
                    80,
                    0
                )
            ),
            Cart(
                quantity = 1,
                plant = Plant(
                    5,
                    "Emerald Fern Fronds (M)",
                    "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic1.png",
                    CategoryPlant("", ""),
                    80,
                    0
                )
            ),
            Cart(
                quantity = 1,
                plant = Plant(
                    6,
                    "Scarlet Petal Paradise (M)",
                    "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic2.png",
                    CategoryPlant("", ""),
                    99,
                    0
                )
            ),
            Cart(
                quantity = 1,
                plant = Plant(
                    7,
                    "Silver Leaf Serenity (M)",
                    "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic3.png",
                    CategoryPlant("", ""),
                    49,
                    0
                )
            ),
            Cart(
                quantity = 1,
                plant = Plant(
                    8,
                    "Royal Bluebell Bliss (M)",
                    "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic4.png",
                    CategoryPlant("", ""),
                    80,
                    0
                )
            )
        )
    }
    var totalCount by remember { mutableStateOf(listCart.sumOf { it.quantity }) }
    var totalAmount by remember { mutableStateOf(listCart.sumOf { it.quantity * it.plant.price }) }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBarCart(onClickBack = { navController.popBackStack() })
        },
        bottomBar = {
            BottomAppBarCart(totalCount, totalAmount)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(listCart, key = { it.plant.id }) { cart ->
                ItemListCart(cart, countQuantity = { type, count ->
                    if (type == "Add") {
                        totalCount += count
                    } else {
                        totalCount -= count
                    }
                }, totalAmount = { type, money ->
                    if (type == "Add") {
                        totalAmount += money
                    } else {
                        totalAmount -= money
                    }
                }, onClickRemove = { id ->
                    listCart.removeIf { it.plant.id == id }
                })
            }
        }
    }
}