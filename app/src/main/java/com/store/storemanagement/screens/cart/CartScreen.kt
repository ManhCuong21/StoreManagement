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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.store.storemanagement.domain.model.CategoryPlant
import com.store.storemanagement.domain.model.Plant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen() {
    var totalAmount by remember { mutableStateOf(0) }
    var totalCount by remember { mutableStateOf(0) }
    val listCart = remember {
        listOf(
            Plant(
                "Emerald Fern Fronds (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic1.png",
                CategoryPlant("", ""),
                80,
                0
            ),
            Plant(
                "Scarlet Petal Paradise (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic2.png",
                CategoryPlant("", ""),
                99,
                0
            ),
            Plant(
                "Silver Leaf Serenity (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic3.png",
                CategoryPlant("", ""),
                49,
                0
            ),
            Plant(
                "Royal Bluebell Bliss (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic4.png",
                CategoryPlant("", ""),
                80,
                0
            ),
            Plant(
                "Emerald Fern Fronds (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic1.png",
                CategoryPlant("", ""),
                80,
                0
            ),
            Plant(
                "Scarlet Petal Paradise (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic2.png",
                CategoryPlant("", ""),
                99,
                0
            ),
            Plant(
                "Silver Leaf Serenity (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic3.png",
                CategoryPlant("", ""),
                49,
                0
            ),
            Plant(
                "Royal Bluebell Bliss (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic4.png",
                CategoryPlant("", ""),
                80,
                0
            )
        )
    }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBarCart(onClickBack = {})
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
            items(listCart) { plant ->
                ItemListCart(plant, totalAmount = { type, money ->
                    if (type == "Add") {
                        totalAmount += money
                    } else {
                        totalAmount -= money
                    }
                })
            }
        }
    }
}