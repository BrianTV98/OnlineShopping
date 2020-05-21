package com.example.onlineshopping.ui.fragment.home.widget.ortherItem

import androidx.lifecycle.ViewModel
import com.example.onlineshopping.data.model.Appliances


class OtherItemViewModel : ViewModel(){
    var listItem  = ArrayList<Appliances>()


    fun  addItem(item : Appliances){
        listItem.add(item)
    }

}