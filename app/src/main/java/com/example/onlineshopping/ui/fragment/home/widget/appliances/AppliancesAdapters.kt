package com.example.onlineshopping.ui.fragment.home.widget.appliances

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshopping.R
import com.example.onlineshopping.data.model.Appliances
import com.example.onlineshopping.databinding.ItemAppliancesLayoutBinding


class AppliancesAdapters(val fragment: Fragment) : RecyclerView.Adapter<AppliancesAdapters.ViewHolder>(){
    var viewModel  : AppliancesViewModel = ViewModelProviders.of(fragment).get(AppliancesViewModel::class.java)

    fun setData(item: Appliances){
        viewModel.addItem(item)
        notifyDataSetChanged()
    }
    class ViewHolder(view: ItemAppliancesLayoutBinding): RecyclerView.ViewHolder(view.root) {
        val binding : ItemAppliancesLayoutBinding = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemAppliancesLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(fragment.context),
            R.layout.item_appliances_layout,parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return viewModel.appliances.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.viewModel = viewModel.appliances[position]
        holder.itemView.setOnClickListener{
            NavController(fragment.context).navigate(R.id.detailItemFragment)
        }

    }

}