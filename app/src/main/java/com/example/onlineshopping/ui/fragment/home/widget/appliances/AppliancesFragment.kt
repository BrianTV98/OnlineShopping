package com.example.onlineshopping.ui.fragment.home.widget.appliances

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager

import com.example.onlineshopping.R
import com.example.onlineshopping.data.model.Appliances
import com.example.onlineshopping.data.model.FlashSale
import com.example.onlineshopping.databinding.FragmentAppliancesBinding
import com.example.onlineshopping.ui.fragment.home.widget.flash_sale.FlashViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_appliances.*
import kotlinx.android.synthetic.main.fragment_flash_sale.*

/**
 * A simple [Fragment] subclass.
 */
class AppliancesFragment : Fragment() , AdapterView.OnItemClickListener{

    lateinit var binding: FragmentAppliancesBinding
    val viewModel : AppliancesViewModel by viewModels<AppliancesViewModel>()

    companion object{
        var  listItem = ArrayList<Appliances>()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(layoutInflater,R.layout.fragment_appliances, container, false)

        binding.lifecycleOwner = viewLifecycleOwner

        val adapters= AppliancesAdapters(this)

        binding.rcvAppliances.adapter= adapters

        binding.viewModel = viewModel

        binding.rcvAppliances.layoutManager= GridLayoutManager(context,2, GridLayoutManager.HORIZONTAL,false)

        Log.d("Appliances", viewModel.appliances.size.toString())

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
                Log.d("Appliances","Load Data :False")
            }

            override fun onDataChange(p0: DataSnapshot) {
                Log.d("Appliances", " Load Data: Success")

                val data = p0.children
                Log.d("Appliances", p0.value.toString())
                viewModel.appliances.clear()
                listItem.clear()

                data.forEach{
                    val tmp = it.getValue(Appliances::class.java)
                    Log.d("FlashShale", tmp!!.name)
                    viewModel.addItem(tmp)
                    listItem.add(tmp);
                }

                binding.rcvAppliances.adapter?.notifyDataSetChanged()

            }
        })
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

}
