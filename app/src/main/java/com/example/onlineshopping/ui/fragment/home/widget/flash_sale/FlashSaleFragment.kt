package com.example.onlineshopping.ui.fragment.home.widget.flash_sale

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.onlineshopping.R
import com.example.onlineshopping.data.model.FlashSale
import com.example.onlineshopping.databinding.FragmentFlashSaleBinding
import com.google.android.play.core.internal.k
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_flash_sale.*
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class FlashSaleFragment : Fragment() {

    lateinit var binding : FragmentFlashSaleBinding
     var listFlashSaleItem = ArrayList<FlashSale>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_flash_sale, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
//        getData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    private fun initView() {

        rcv_flash_sale.apply {
            adapter = RecycleViewFlashSaleApdater(context,listFlashSaleItem)
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }

    }
    private fun getData() {
        val viewModel : FlashViewModel by viewModels<FlashViewModel>()
        Firebase.database.reference.child("flashSale").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                Log.d("FlashShale","Load Data :False")
            }

            override fun onDataChange(p0: DataSnapshot) {
                Log.d("FlashShale", " Load Data: Success")

                val data = p0.children

                data.forEach{
                    val tmp = it.getValue(FlashSale::class.java)
                    Log.d("FlashShale", tmp!!.imagUrl)
                    listFlashSaleItem.add(tmp!!)
                }
                rcv_flash_sale.adapter?.notifyDataSetChanged()
            }
        })
    }

}
