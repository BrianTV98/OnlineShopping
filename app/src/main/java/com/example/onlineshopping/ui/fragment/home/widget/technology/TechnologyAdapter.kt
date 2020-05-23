package com.example.onlineshopping.ui.fragment.home.widget.technology

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshopping.R
import com.example.onlineshopping.databinding.ItemTechnologyLayoutBinding


class TechnologyAdapter (val fragment: Fragment): RecyclerView.Adapter<TechnologyAdapter.ViewHolder>(){
    var viewModel  : TechnologyViewModel = ViewModelProviders.of(fragment).get(TechnologyViewModel::class.java)

    class ViewHolder(view : ItemTechnologyLayoutBinding) : RecyclerView.ViewHolder(view.root){
        val binding : ItemTechnologyLayoutBinding = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemTechnologyLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(fragment.context),
            R.layout.item_technology_layout,parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return viewModel.listItemTechnology.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewModel = viewModel.listItemTechnology[position]
        Log.d("Technology",viewModel.listItemTechnology[position].imageUrl)
        holder.itemView.setOnClickListener{
            Toast.makeText(fragment.context,position.toString(), Toast.LENGTH_LONG ).show()
        }
    }

}