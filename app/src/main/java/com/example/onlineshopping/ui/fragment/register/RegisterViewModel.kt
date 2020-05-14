package com.example.onlineshopping.ui.fragment.register

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.onlineshopping.data.model.User

class RegisterViewModel : ViewModel() {
    var user = User()
    var confirmPassword =""
    fun checkValidate(name :String ,email: String , pass : String, phone: String ){

    }

    fun saveModel( name: String, email: String, pass: String, phone: String){
        user.name= name
        user.email= email
        user.password=pass
        user.phone= phone
    }
}