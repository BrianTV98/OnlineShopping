package com.example.onlineshopping.ui.fragment.home

import CustomViewPagerApdater
import android.content.Context
import android.os.Binder
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
//        hideKeyboardTouchScreen()
        binding.imvScannerQrCode.setOnClickListener {
            findNavController().navigate(R.id.qrCodeFragment)
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Snack", "Attach")
    }

    private fun hideKeyboardTouchScreen() {
        lo_main_home.setOnTouchListener { v, event ->
            if (event != null && event.action == MotionEvent.ACTION_MOVE) {
                val imm =
                    requireActivity().getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                val isHide = imm!!.isAcceptingText()
                if (isHide) {
                    imm?.hideSoftInputFromWindow(requireActivity()!!.currentFocus?.windowToken, 0)
                }
                true
            }
            false
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d("Snack", "OnStart")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Snack", "Oncreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("Home", "onActivityCreated")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Home", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Home", "OnStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Home", "OnDetroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Home", "OnDetroy")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Home", "OnResume")
    }

}

