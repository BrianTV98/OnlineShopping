package com.example.onlineshopping.ui.fragment.snack

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshopping.R
import com.example.onlineshopping.databinding.ItemNewFeedLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class SnackAdapter(val fragment: Fragment, val viewModel: SnackViewModel) :
    RecyclerView.Adapter<SnackAdapter.NewFeedViewHolder>() {

    class NewFeedViewHolder(view: ItemNewFeedLayoutBinding) : RecyclerView.ViewHolder(view.root) {

        val binding: ItemNewFeedLayoutBinding = view

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewFeedViewHolder {
        val binding: ItemNewFeedLayoutBinding = DataBindingUtil.inflate(

            LayoutInflater.from(fragment.context),
            R.layout.item_new_feed_layout, parent, false
        )

        binding.btnCommnent.setOnClickListener {

            val bottomSheetDialog: BottomSheetDialog =
                BottomSheetDialog(fragment.requireContext(), R.style.BottomSheetDialogTheme)

            val bottomSheetView: View = LayoutInflater.from(fragment.context)
                .inflate(R.layout.layout_bottom_sheet_comment, parent, false)

//            bottomSheetView.findViewById<Button>(R.id.btn_send).setOnClickListener {
//                Toast.makeText(fragment.context, "Share", Toast.LENGTH_SHORT).show()
//                bottomSheetDialog.dismiss()
//            }

            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }

        return NewFeedViewHolder(binding)

    }

    override fun getItemCount(): Int {
        Log.d("newfeeds", "hodel ${viewModel.listNewFeed.size}")

        return viewModel.listNewFeed.size

    }

    override fun onBindViewHolder(holder: NewFeedViewHolder, position: Int) {
        holder.binding.viewModel = viewModel.listNewFeed[position]
        Log.d("newfeeds", "hodel ${viewModel.listNewFeed[position].content}")

        holder.itemView.setOnClickListener {
            Toast.makeText(fragment.context, position.toString(), Toast.LENGTH_LONG).show()
        }
    }

}