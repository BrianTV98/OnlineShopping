package com.example.onlineshopping.data.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(var uuid : String? ,var name : String, var email: String,var phone: String, var password :String){
    constructor() : this(uuid="",name="", email="", phone="", password="")
}