package com.example.onlineshopping.ui.fragment.forgotpassword

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.onlineshopping.BR
import com.example.onlineshopping.R
import com.example.onlineshopping.databinding.FragmentForgotPassWordBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass.
 */
class ForgotPassWordFragment : Fragment(), ForgotPasswordListenner {

    lateinit var binding :FragmentForgotPassWordBinding
    val viewModel :ForgotPasswordViewModel  by viewModels<ForgotPasswordViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_forgot_pass_word, container, false)
        binding.viewModel = viewModel
        binding.setVariable(BR.forgotPasswordListenner, this)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun btnSend(view: View) {
        val email =binding.emailVerification.text.toString()
        FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnSuccessListener {
            Log.d("ForgotPassword ", "Send email forgot success")
        }
            .addOnFailureListener {
                Log.d("ForgotPassword ", "Send email forgot fail")
            }
    }

}
