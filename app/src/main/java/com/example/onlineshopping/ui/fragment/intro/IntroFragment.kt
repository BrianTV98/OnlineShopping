package com.example.onlineshopping.ui.fragment.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.fragment.findNavController
import com.example.onlineshopping.R
import com.example.onlineshopping.databinding.FragmentIntroBinding

/**
 * A simple [Fragment] subclass.
 */
class IntroFragment : Fragment(), IntroListenner {

    lateinit var binding : FragmentIntroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_intro,container, false)
        binding.setVariable(BR.introListenner, this)
        return binding.root
    }

    override fun btnLogin(view: View) {
        findNavController().navigate(R.id.loginFragment)
    }

    override fun btnRegister(view: View) {
        findNavController().navigate(R.id.registerFragment)
    }

}
