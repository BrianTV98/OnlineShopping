package com.example.onlineshopping.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class NewFeed(
    val id : String,
    val imageUrl : String,
    val comments : List<String>,
    val date_created : String,
    val title : String,
    val slug : String,
    val content : String,
    val tags : String,
    val owner : Int){
    constructor(): this(id="",imageUrl = "", comments = emptyList(), content = "",owner = 123, title = "", date_created = "", tags = "", slug = "")
}
