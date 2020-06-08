package com.example.onlineshopping.ui.fragment.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshopping.R
import com.example.onlineshopping.data.model.Appliances
import com.example.onlineshopping.data.model.Item
import com.example.onlineshopping.databinding.ItemAppliancesLayoutBinding
import com.example.onlineshopping.databinding.ItemCartLayoutBinding
import com.example.onlineshopping.ui.fragment.home.widget.appliances.AppliancesViewModel
import com.example.onlineshopping.ui.fragment.main.MainFragmentDirections
import com.squareup.picasso.Picasso

class CartAdapter(val fragment: Fragment, val list : ArrayList<Item>) : RecyclerView.Adapter<CartAdapter.ViewHolder>(){

    class ViewHolder(view : View): RecyclerView.ViewHolder(view) {
        var name = view.findViewById<TextView>(R.id.name)
        var amount = view.findViewById<TextView>(R.id.amount)
        var price  = view.findViewById<TextView>(R.id.price)
        var imvAvata =view.findViewById<ImageView>(R.id.imv_avata)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_cart_layout, parent, false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var itemSelected =list[position];
        holder.name.text =itemSelected.name
        holder.amount.text = "1"
        holder.price.text= itemSelected.price.toString();
        Picasso.get().load(itemSelected.imageUrl).into(holder.imvAvata)

        holder.itemView.setOnClickListener{
            Toast.makeText(fragment.context, "${list.size}", Toast.LENGTH_LONG).show()
        }

    }

}