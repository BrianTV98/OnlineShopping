package com.example.onlineshopping.ui.fragment.snack

import androidx.lifecycle.ViewModel
import com.example.onlineshopping.data.model.NewFeed

class SnackViewModel : ViewModel(){

    var listNewFeed = ArrayList<NewFeed>()

    fun addItem(item : NewFeed){
        this.listNewFeed.add(item)
    }

}