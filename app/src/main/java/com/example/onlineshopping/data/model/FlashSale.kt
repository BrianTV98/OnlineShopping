package com.example.onlineshopping.data.model

import com.google.gson.annotations.SerializedName

data class FlashSale( val name : String, val  imagUrl : String, val discount: Int, val price : Float, val Inventory  : Int ){
    constructor(): this(name="", imagUrl="", discount= 0, price=0F, Inventory=0)
}
