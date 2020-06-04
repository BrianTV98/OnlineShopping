package com.example.onlineshopping.data.model

data class Item(
    val id: Long,
    val name: String,
    val description: String,
    val price: Float,
    val imageUrl: String,
    val idStore: Long,
    val madeIn: String,
    val addressShop : String
){

    constructor(): this(id=0L, name = "",description = "", price = 0F, imageUrl = "", idStore=0L,madeIn = "", addressShop = "")

}