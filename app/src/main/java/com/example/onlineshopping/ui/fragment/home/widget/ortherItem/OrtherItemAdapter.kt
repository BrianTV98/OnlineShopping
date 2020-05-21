package com.example.onlineshopping.ui.fragment.home.widget.ortherItem

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshopping.R
import com.example.onlineshopping.data.model.Appliances
import com.example.onlineshopping.databinding.ItemOrtherLayoutBinding

class OrtherItemAdapter(val fragment: Fragment) : RecyclerView.Adapter<OrtherItemAdapter.ViewHolder>(){
    var viewModel  : OtherItemViewModel = ViewModelProviders.of(fragment).get(OtherItemViewModel::class.java)

    fun setData(item: Appliances){
        viewModel.addItem(item)
        notifyDataSetChanged()
    }
    class ViewHolder(view: ItemOrtherLayoutBinding): RecyclerView.ViewHolder(view.root) {
        val binding : ItemOrtherLayoutBinding = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemOrtherLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(fragment.context),
            R.layout.item_orther_layout,parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return viewModel.listItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.viewModel = viewModel.listItem[position]
        holder.itemView.setOnClickListener{
            Toast.makeText(fragment.context,position.toString(), Toast.LENGTH_LONG ).show()
        }

    }

}