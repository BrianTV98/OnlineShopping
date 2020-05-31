package com.example.onlineshopping.ui.fragment.home.widget.technology

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlineshopping.data.model.Technology


class TechnologyViewModel : ViewModel(){

    var listItemTechnology  = ArrayList<Technology>()
    var progress = MutableLiveData<Int>()
    fun addItem(item : Technology){
        this.listItemTechnology.add(item)
    }

    init {
        progress.value=0;
    }

}