package com.example.onlineshopping.ui.fragment.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import com.example.onlineshopping.R
import com.example.onlineshopping.data.model.User
import com.example.onlineshopping.databinding.FragmentRegisterBinding
import com.example.onlineshopping.utils.extention.isEmailValid
import com.example.onlineshopping.utils.extention.isPasswordValid
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment(), RegisterListenner {

    lateinit var binding: FragmentRegisterBinding
    val auth = Firebase.auth
    var database = Firebase.database.reference
    val viewmodel: RegisterViewModel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_register, container, false)



        binding.viewModel = viewmodel

        binding.setVariable(BR.registerListenner, this)

        binding.lifecycleOwner = viewLifecycleOwner
        // Inflate the layout for this fragment

        return binding.root
    }

    override fun btnRegister(view: View) {
//        Toast.makeText(context, "adsc" , Toast.LENGTH_LONG).show()
//        var email =   binding.editEmail.text.toString()
//        var name  =   binding.editUserName.text.toString()
//        var phone =   binding.editPhoneNumber.text.toString()
//        var password =     binding.editPassword.text.toString()
//        var confirmpassword =  binding.editConfirm.text.toString()
//
//        var check =checkValidate(
//            email, name, phone, password, confirmpassword
//        )
//
//        if(check){
//            /*
//                save model
//                register
//                push up user
//             */
//
//            viewmodel.user = User("",name,email,phone,password)
//            register(email, password)
            writeNewUser(viewmodel.user)
//        }

    }

    private fun writeNewUser(user: User) {
        val user2 = User("123","afdsfa","Afdfa","afdf","afdsfa")
        //database.child("users").setValue("hi")
//        FirebaseDatabase.getInstance().reference.child("users").setValue("5")
        Firebase.database.reference.child("users").setValue("5")
        Toast.makeText(context,"abc",Toast.LENGTH_LONG).show()
    }

    private fun register(email: String, password: String) : Boolean{
        var check =false

        auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
            viewmodel.user.uuid =it.user?.uid
            Log.d("Register", "Register success ${it.user?.uid}")
            check=true
        }
            .addOnFailureListener{
                Log.d("Register","Register fail  ${it.toString()}")
                check=false
            }

        return  check
    }

    private fun checkValidate(email: String, name: String, phone: String, password: String, confirmpassword: String) : Boolean {
        var check = true
        if(!email.isEmailValid()){
            check =false
            binding.loEmail.error= resources.getString(R.string.err_email)
        }
        else   binding.loEmail.error=null

        if(name.isEmpty()){
            check=false
            binding.loName.error = resources.getString(R.string.err_null)
        }
        else binding.loName.error=null

        if(phone.length<9||phone.length>13){
            check=false
            binding.loPhoneNumber.error = resources.getString(R.string.err_not_phone)
        }
        else binding.loName.error=null

        if(!isPasswordValid(password)){
            check=false
            binding.loPassword.error = resources.getString(R.string.err_not_password)
        }
        else binding.loName.error=null

        if(password != confirmpassword){
            Log.d("Register", "password  $password=$confirmpassword=")
            check=false
            binding.loConfirmPassword.error = resources.getString(R.string.err_confirmpass)
        }
        else binding.loConfirmPassword.error=null

        Log.d("Register", "check  $check")
        return  check
    }

}
