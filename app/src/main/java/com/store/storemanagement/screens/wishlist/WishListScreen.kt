package com.store.storemanagement.screens.wishlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.store.storemanagement.domain.model.CategoryPlant
import com.store.storemanagement.domain.model.Plant

@Composable
fun WishListScreen() {
    val wishList = remember {
        listOf(
            Plant(1,
                "Emerald Fern Fronds (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic1.png",
                CategoryPlant("", ""),
                80,
                0
            ),
            Plant(2,
                "Scarlet Petal Paradise (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic2.png",
                CategoryPlant("", ""),
                99,
                0
            ),
            Plant(3,
                "Silver Leaf Serenity (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic3.png",
                CategoryPlant("", ""),
                49,
                0
            ),
            Plant(4,
                "Royal Bluebell Bliss (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic4.png",
                CategoryPlant("", ""),
                80,
                0
            ),
            Plant(5,
                "Emerald Fern Fronds (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic1.png",
                CategoryPlant("", ""),
                80,
                0
            ),
            Plant(6,
                "Scarlet Petal Paradise (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic2.png",
                CategoryPlant("", ""),
                99,
                0
            ),
            Plant(7,
                "Silver Leaf Serenity (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic3.png",
                CategoryPlant("", ""),
                49,
                0
            ),
            Plant(8,
                "Royal Bluebell Bliss (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic4.png",
                CategoryPlant("", ""),
                80,
                0
            )
        )
    }

    LazyColumn {
        wishList(wishList)
    }
}