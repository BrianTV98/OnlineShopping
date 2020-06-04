package com.example.onlineshopping.ui.fragment.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onlineshopping.R
import com.example.onlineshopping.databinding.FragmentMainBinding
import com.example.onlineshopping.ui.fragment.account.AccountFragment
import com.example.onlineshopping.ui.fragment.snack.SnackFragment
import com.example.onlineshopping.ui.fragment.cart.CartFragment
import com.example.onlineshopping.ui.fragment.home.HomeFragment
import com.example.onlineshopping.ui.fragment.message.MessageFragment


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    var idMenuSelected: Int = R.id.hom_nav

    private val homeFragment
            by lazy { HomeFragment() }

    private val snackFragment
            by lazy { SnackFragment() }
    private val messageFragment
            by lazy { MessageFragment() }
    private val cartFragment
            by lazy { CartFragment() }
    private val accountFragment
            by lazy { AccountFragment() }

    lateinit var binding : FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= DataBindingUtil.inflate(layoutInflater,R.layout.fragment_main, container, false )

        binding.lifecycleOwner =viewLifecycleOwner

        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.container, homeFragment)
            .commit()



        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBottom()
    }
    private fun initBottom() {

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.hom_nav -> {
                    if (idMenuSelected != R.id.hom_nav) {
                        idMenuSelected = R.id.hom_nav
                        openFragment(homeFragment)
                    }
                    true
                }

                R.id.live_nav -> {
                    if (idMenuSelected != R.id.live_nav) {
                        idMenuSelected = R.id.live_nav
                        openFragment(snackFragment)
                    }
                    true
                }

                R.id.cart_nav -> {
                    Log.d("MainFragment", "car_nav")
                    if (idMenuSelected != R.id.cartFragment) {
                        idMenuSelected = R.id.cartFragment
                        openFragment(cartFragment)
                    }
                    true
                }

                R.id.account_nav -> {
                    Log.d("MainFragment", "car_nav")
                    if (idMenuSelected != R.id.account_nav) {
                        idMenuSelected = R.id.account_nav
                        openFragment(accountFragment)
                    }
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

}
