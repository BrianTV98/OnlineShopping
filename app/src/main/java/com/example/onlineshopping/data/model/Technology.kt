package com.example.onlineshopping.data.model

data class Technology(
    val id: Long,
    val name: String,
    val description: String,
    val price: Float,
    val imageUrl: String,
    val idStore: Long
){
    constructor(): this(id=0L, name = "",description = "", price = 0F, imageUrl = "", idStore=0L)
}