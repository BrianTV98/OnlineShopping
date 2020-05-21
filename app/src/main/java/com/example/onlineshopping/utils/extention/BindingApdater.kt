package com.example.onlineshopping.utils.extention

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

@BindingAdapter("android:imageUrl")
fun ImageView.bindImageFromUrl(imageUrl: String?) {
    imageUrl?.let {
        Picasso.get()
            .load(imageUrl)
            .into(this)
    }
}


@BindingAdapter("android:src")
fun ImageView.bindImageResource(resource: Int) {
    this.setImageResource(resource)
}


interface BindableAdapter<T> {
    fun setData(data: T)
}

@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: T) {
    if (recyclerView.adapter is BindableAdapter<*>) {
        (recyclerView.adapter as BindableAdapter<T>).setData(data)
    }
}