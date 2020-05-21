package com.example.onlineshopping.data.remote

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.onlineshopping.data.model.FlashSale
import com.example.onlineshopping.ui.fragment.home.widget.flash_sale.FlashViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_flash_sale.*

class API {
    private fun getData( fragment: Fragment) {
        val viewModel : FlashViewModel = ViewModelProviders.of(fragment).get(FlashViewModel::class.java)
        Firebase.database.reference.child("flashSale").addValueEventListener(object :
            ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Log.d("FlashShale","Load Data :False")
            }

            override fun onDataChange(p0: DataSnapshot) {
                Log.d("FlashShale", " Load Data: Success")

                val data = p0.children

                data.forEach{
                    val tmp = it.getValue(FlashSale::class.java)
                    Log.d("FlashShale", tmp!!.imagUrl)
                    viewModel.flashSale.add(tmp!!)
                }
                rcv_flash_sale.adapter?.notifyDataSetChanged()
            }
        })
    }
}