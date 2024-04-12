package com.store.storemanagement.domain.model

data class Plant(
    val title: String,
    val image: String,
    val categoryPlant: CategoryPlant,
    val price: Int,
    val review: Int
)