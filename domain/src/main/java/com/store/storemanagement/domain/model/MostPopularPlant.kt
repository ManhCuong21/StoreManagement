package com.store.storemanagement.domain.model

data class MostPopularPlant(
    val title: String,
    val image: String,
    val categoryPlant: CategoryPlant,
    val price: Int
)