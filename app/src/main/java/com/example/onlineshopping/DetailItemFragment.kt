package com.example.onlineshopping

import android.content.ClipData
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.onlineshopping.data.model.Item
import com.example.onlineshopping.databinding.FragmentDetailItemBinding
import com.example.onlineshopping.ui.fragment.cart.CartFragment
import com.example.onlineshopping.ui.fragment.home.widget.appliances.AppliancesAdapters
import com.example.onlineshopping.ui.fragment.home.widget.appliances.AppliancesFragment
import com.example.onlineshopping.ui.fragment.home.widget.appliances.AppliancesViewModel
import com.example.onlineshopping.ui.fragment.main.MainFragment

/**
 * A simple [Fragment] subclass.
 */
class DetailItemFragment : Fragment() {

    lateinit var binding: FragmentDetailItemBinding
    val viewModel: AppliancesViewModel by viewModels<AppliancesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_detail_item, container, false)


        binding.btnComback.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }

        Toast.makeText(context, "${AppliancesFragment.listItem.size}", Toast.LENGTH_LONG).show();

        binding.viewModel = AppliancesFragment.listItem[AppliancesAdapters.positionSelected];

//        findNavController().popBackStack(R.id.mainFragment,true)

        binding.btnAddItem.setOnClickListener {
                val tmp = AppliancesFragment.listItem[AppliancesAdapters.positionSelected]
                val item = Item(tmp.id, tmp.name,tmp.description, tmp.price, tmp.imageUrl, tmp.idStore,tmp.madeIn, tmp.addressShop) // fix
                CartFragment.listItem.add(item);

                findNavController().navigate(R.id.cartFragment)
        }
        return binding.root
    }


}
