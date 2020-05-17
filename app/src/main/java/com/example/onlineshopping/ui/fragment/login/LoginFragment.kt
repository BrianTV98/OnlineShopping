package com.example.onlineshopping.ui.fragment.login

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.onlineshopping.BR
import com.example.onlineshopping.R
import com.example.onlineshopping.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment(), LoginListenner {

    lateinit var binding: FragmentLoginBinding

    private val auth: FirebaseAuth = Firebase.auth

    val viewModel: LoginViewModel by viewModels<LoginViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, container, false)

        binding.setVariable(BR.loginListenner, this)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainLayout.setOnTouchListener { v, event ->
            val imm =
                requireActivity().getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
            true
        }

    }

    override fun btnLogin(view: View) {
        val username = binding.editEmail.text.toString();
        val password = binding.editPassword.text.toString();
        val check = viewModel.checkValidate(username, password)

        Log.d("Login", " check State: $check")
        if (check) {
            auth.signInWithEmailAndPassword(username, password).addOnSuccessListener {
                Log.d("Login", "Thanh Cong")
            }
                .addOnFailureListener {
                    Log.d("Login", it.toString())
                }

        }
        else{
            // set String helpt text
            binding.loPassword.helperText =resources.getString(R.string.err_login)
            //set color help text
            val states = arrayOf(
                intArrayOf(android.R.attr.state_enabled)
            )
            val colors = intArrayOf(
                Color.RED
            )
            binding.loPassword.setHelperTextColor(ColorStateList(states, colors))
        }
    }

}

