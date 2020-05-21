package com.example.onlineshopping.ui.fragment.home.widget.flash_sale

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshopping.R
import com.example.onlineshopping.data.model.FlashSale
import com.example.onlineshopping.databinding.ItemFlashSaleLayoutBinding

class RecycleViewFlashSaleApdater (val context: Context,val  list: List<FlashSale>) : RecyclerView.Adapter<RecycleViewFlashSaleApdater.ViewHolder>(){


    class ViewHolder(view : ItemFlashSaleLayoutBinding)  : RecyclerView.ViewHolder(view.root){
        val binding : ItemFlashSaleLayoutBinding = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemFlashSaleLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.item_flash_sale_layout,parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("AdapterFlashSale",list[position].imagUrl)
        Log.d("AdapterFlashSale",list[position].discount.toString())
        holder.binding.flashViewModel= list[position]
    }

}