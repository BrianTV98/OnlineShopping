package com.example.onlineshopping.data.remote

import android.util.Log
import android.widget.Toast
import androidx.constraintlayout.widget.Constraints.TAG
import com.example.onlineshopping.data.model.FlashSale
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FlashSaleApi  {
//    fun allData() : List<FlashSale> {
//        postListener= Firebase.database.reference.child("flashSale").
//        return
//    }
//    val postListener = object : ValueEventListener {
////
//
//        override fun onDataChange(dataSnapshot: DataSnapshot) {
//            // Get Post object and use the values to update the UI
//            val post = dataSnapshot.value as FlashSale
//            // [START_EXCLUDE]
//
//            // [END_EXCLUDE]
//        }
//
//        override fun onCancelled(databaseError: DatabaseError) {
//            // Getting Post failed, log a message
//            Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
//        }
//    }
//    companion object {
//        val instant : List<FlashSale> by lazy {  }
//    }
}