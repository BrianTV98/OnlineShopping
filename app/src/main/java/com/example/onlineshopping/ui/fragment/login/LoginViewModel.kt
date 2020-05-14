package com.example.onlineshopping.ui.fragment.login

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.onlineshopping.utils.extention.isEmailValid
import com.example.onlineshopping.utils.extention.isPasswordValid

class LoginViewModel  :ViewModel(){
    var username  = ObservableField<String>()
    var password  =""

    fun checkValidate(username : String , password : String): Boolean {
        if(username.isEmailValid()&& isPasswordValid(password)) {
            this.username.set(username)
            return true
        }
        return  false
    }
}