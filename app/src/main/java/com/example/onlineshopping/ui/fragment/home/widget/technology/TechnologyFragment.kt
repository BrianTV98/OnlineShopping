package com.example.onlineshopping.ui.fragment.home.widget.technology

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager

import com.example.onlineshopping.R
import com.example.onlineshopping.data.model.Appliances
import com.example.onlineshopping.data.model.Technology
import com.example.onlineshopping.databinding.FragmentTechnologyBinding
import com.example.onlineshopping.ui.fragment.home.widget.appliances.AppliancesViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class TechnologyFragment : Fragment() {

    lateinit var binding : FragmentTechnologyBinding
    val viewModel : TechnologyViewModel by viewModels<TechnologyViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_technology, container, false)

        binding.rcv.adapter = TechnologyAdapter(this, viewModel.listItemTechnology)

        binding.rcv.layoutManager= GridLayoutManager(context,2, GridLayoutManager.HORIZONTAL,false)


        viewModel.progress.observe(viewLifecycleOwner, Observer {
            if(it == 0){

            }

        })

        return binding.root

    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun getData() {
        Firebase.database.reference.child("technologys").addValueEventListener(object :
            ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Log.d("technologys","Load Data :False")
            }

            override fun onDataChange(p0: DataSnapshot) {
                Log.d("technologys", " Load Data: Success")

                val data = p0.children
                Log.d("technologys", p0.value.toString())
                viewModel.listItemTechnology.clear()
                data.forEach{
                    val tmp = it.getValue(Technology::class.java)
                    Log.d("FlashShale", tmp!!.name)
                    viewModel.addItem(tmp)
                }

                binding.rcv.adapter?.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE

            }
        })
    }

}
