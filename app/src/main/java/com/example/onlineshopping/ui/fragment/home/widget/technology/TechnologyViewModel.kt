package com.example.onlineshopping.ui.fragment.home.widget.technology

import androidx.lifecycle.ViewModel
import com.example.onlineshopping.data.model.Technology

class TechnologyViewModel : ViewModel(){

    var listItemTechnology  = ArrayList<Technology>()

    fun addItem(item : Technology){
        this.listItemTechnology.add(item)
    }

}