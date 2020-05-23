package com.example.onlineshopping.ui.fragment.snack

import android.content.Context
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
import com.example.onlineshopping.data.model.NewFeed
import com.example.onlineshopping.databinding.FragmentSnackBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass.
 */
class SnackFragment : Fragment() {

    lateinit var binding: FragmentSnackBinding
    val viewModel : SnackViewModel by viewModels<SnackViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_snack, container, false)
        binding.lifecycleOwner= viewLifecycleOwner


        binding.viewModel = viewModel

        binding.rcv.adapter=SnackAdapter(this, viewModel)

        (binding.rcv.adapter as SnackAdapter).notifyDataSetChanged()

        binding.rcv.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        return binding.root

    }

    override fun onStart() {
        super.onStart()
        Log.d("Snack", "Onstart")
        Log.d("Snack",  viewModel.listNewFeed.size.toString())
    }

    private fun getData() {
        Firebase.database.reference.child("newfeeds").addValueEventListener(object :
            ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {
                Log.d("newfeeds","Load Data :False")
            }

            override fun onDataChange(p0: DataSnapshot) {
                Log.d("newfeeds", " Load Data: Success")
                Log.d("newfeeds", " Chay Vao Ham Nay")

                val data = p0.children
                Log.d("newfeeds", p0.value.toString())
                    viewModel.listNewFeed.clear()
                data.forEach{
                    val tmp = it.getValue(NewFeed::class.java)
                    Log.d("newfeeds", tmp!!.content)
                    viewModel.addItem(tmp)
                }
                binding.rcv.adapter?.notifyDataSetChanged()
            }

        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getData()
        Log.d("Snack", "Attach")
        Log.d("Snack",  viewModel.listNewFeed.size.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Snack", "Oncreate")
        Log.d("Snack",  viewModel.listNewFeed.size.toString())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("Snack", "onActivityCreated")
        Log.d("Snack",  viewModel.listNewFeed.size.toString())
    }

    override fun onPause() {
        super.onPause()
        Log.d("Snack", "OnPause")
        Log.d("Snack",  viewModel.listNewFeed.size.toString())
    }

    override fun onStop() {
        super.onStop()
        Log.d("Snack", "OnStop")
        Log.d("Snack",  viewModel.listNewFeed.size.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Snack", "OnDetroyView")
        Log.d("Snack",  viewModel.listNewFeed.size.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Snack", "OnDetroy")
        Log.d("Snack",  viewModel.listNewFeed.size.toString())
    }

    override fun onResume() {
        super.onResume()
        Log.d("Snack", "OnResume")
        Log.d("Snack",  viewModel.listNewFeed.size.toString())
    }

}

