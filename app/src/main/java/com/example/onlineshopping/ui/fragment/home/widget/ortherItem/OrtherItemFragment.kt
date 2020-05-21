package com.example.onlineshopping.ui.fragment.home.widget.ortherItem

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.example.onlineshopping.R
import com.example.onlineshopping.data.model.Appliances
import com.example.onlineshopping.databinding.FragmentAppliancesBinding
import com.example.onlineshopping.databinding.FragmentOrtherItemBinding
import com.example.onlineshopping.ui.fragment.home.widget.appliances.AppliancesAdapters
import com.example.onlineshopping.ui.fragment.home.widget.appliances.AppliancesViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass.
 */
class OrtherItemFragment : Fragment() {


    //using Model of Appliance

    lateinit var binding: FragmentOrtherItemBinding
    val viewModel : OtherItemViewModel by viewModels<OtherItemViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= DataBindingUtil.inflate(layoutInflater,R.layout.fragment_orther_item, container, false)

        binding.lifecycleOwner = viewLifecycleOwner

        val adapters= OrtherItemAdapter(this)

        binding.rcv.adapter= adapters

        binding.viewModel = viewModel

        binding.rcv.layoutManager= StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)


        Log.d("OrtherItem", viewModel.listItem.size.toString())

        return binding.root

    }
    override fun onStart() {
        super.onStart()
        getData()
    }
    private fun getData() {
        Firebase.database.reference.child("appliances").addValueEventListener(object :
            ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Log.d("OrtherItem","Load Data :False")
            }

            override fun onDataChange(p0: DataSnapshot) {
                Log.d("OrtherItem", " Load Data: Success")

                val data = p0.children
                Log.d("OrtherItem", p0.value.toString())
                viewModel.listItem.clear()
                data.forEach{
                    val tmp = it.getValue(Appliances::class.java)
                    Log.d("OrtherItem", tmp!!.name)
                    viewModel.addItem(tmp)
                }
                binding.rcv.adapter?.notifyDataSetChanged()
            }
        })
    }


}
