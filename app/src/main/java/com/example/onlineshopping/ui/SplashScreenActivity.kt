package com.example.onlineshopping.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.example.onlineshopping.R
import com.example.onlineshopping.data.model.NewFeed
import com.example.onlineshopping.databinding.ItemNewFeedLayoutBinding
import com.example.onlineshopping.ui.base.BaseActivity
import com.example.onlineshopping.ui.fragment.MainActivity
import com.example.onlineshopping.ui.fragment.snack.SnackViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.fragment_main.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1000)
    }

}
