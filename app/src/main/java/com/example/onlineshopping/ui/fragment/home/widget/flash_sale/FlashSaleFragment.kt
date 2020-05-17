package com.example.onlineshopping.ui.fragment.home.widget.flash_sale

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.onlineshopping.R
import com.example.onlineshopping.databinding.FragmentFlashSaleBinding

/**
 * A simple [Fragment] subclass.
 */
class FlashSaleFragment : Fragment() {

    lateinit var binding : FragmentFlashSaleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_flash_sale, container, false)

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

}
