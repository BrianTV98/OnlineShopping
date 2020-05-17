package com.example.onlineshopping.ui.fragment.home

import CustomViewPagerApdater
import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.onlineshopping.R
import com.example.onlineshopping.data.model.Banner
import com.example.onlineshopping.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.banner_viewpager_layout.*
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_home, container, false)
        binding.lifecycleOwner= viewLifecycleOwner

        return binding.root
    }


}

