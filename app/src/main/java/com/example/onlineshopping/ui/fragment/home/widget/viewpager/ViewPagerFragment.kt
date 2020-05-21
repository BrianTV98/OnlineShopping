package com.example.onlineshopping.ui.fragment.home.widget.viewpager

import CustomViewPagerApdater
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.marginStart
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager

import com.example.onlineshopping.R
import com.example.onlineshopping.databinding.FragmentViewPagerBinding
import kotlinx.android.synthetic.main.fragment_view_pager.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class ViewPagerFragment : Fragment() {

    lateinit var binding : FragmentViewPagerBinding
    var current_position =0
    var time = Timer()
    val handler = Handler()
    var Update =Runnable{}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragmen
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_view_pager, container, false)
        
        val adapter =CustomViewPagerApdater(requireContext())

        binding.pager.adapter= adapter
        prepareDots(current_position,adapter.count);
        createSlideShow(adapter.count)
        binding.pager.addOnPageChangeListener(object  : ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                prepareDots(current_position-1,adapter.count);
            }

        })

        return binding.root
    }

    private fun prepareDots(currentSlidePosition: Int, count: Int) {
        if (binding.dotsContainer.childCount > 0) {
            binding.dotsContainer.removeAllViews()
        }

        for (i in 0..4){
            val imageView = ImageView(requireContext())
            var param :LinearLayout.LayoutParams=LinearLayout.LayoutParams(20, 20)
            param.setMargins(10,0,10,5)
            imageView.layoutParams = param // value is in pixels
            if(i==currentSlidePosition){
                imageView.setImageResource(R.drawable.active_dot)
            }
            else
                imageView.setImageResource(R.drawable.inactive_dot)
            binding.dotsContainer.addView(imageView)
        }

    }
    private var runnable: Runnable = object : Runnable {
        override fun run() {
            /* Do something very important */
//            handler.postDelayed(this, 5000)
        }
    }
    private fun createSlideShow(maxSize :Int) {

        Update = Runnable {
            if (current_position == maxSize) {
                current_position = 0
            }
            binding.pager.setCurrentItem(current_position++, true)
        }

        time.schedule(object : TimerTask() {
            // task to be scheduled
            override fun run() {
                handler.post(Update)
            }
        }, 500, 2500)
    }

    override fun onPause() {
        super.onPause()
        time.cancel()
    }

}
