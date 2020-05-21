package com.example.onlineshopping.ui.fragment.home.widget.appliances

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlineshopping.BR
import com.example.onlineshopping.data.model.Appliances

class AppliancesViewModel : ViewModel(){
    var appliances  = ArrayList<Appliances>()


    fun  addItem(item : Appliances){
        appliances.add(item)
    }

}