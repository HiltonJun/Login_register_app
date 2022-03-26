package com.hilton.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.hilton.lesson2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startBinding()
        click()
        tvClick()
    }

    private fun startBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.root
    }

    private fun checkLogin() {
        val email = binding.etEmailLogin.validate()
        val password = binding.etPasswordLogin.validate()
        when {
            email -> binding.etEmailLogin.error = getString(R.string.generic_error)
            password -> binding.etPasswordLogin.error = getString(R.string.generic_error)
            else -> loginFirebase(binding.etEmailLogin.get(), binding.etPasswordLogin.get())
        }
    }

    private fun click() {
        binding.btLogin.setOnClickListener {
            checkLogin()
        }
    }

    private fun startRegistration() {
        val registerIntent = Intent(this, RegisterActivity::class.java)
        startActivity(registerIntent)
    }

    private fun tvClick() {
        binding.tvRegister.setOnClickListener {
            startRegistration()
        }
    }

    private fun loginFirebase(email: String,password: String){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
            .addOnSuccessListener { toast("Login successful") }
            .addOnFailureListener { errorCase->
                errorCase.message?.let{message -> toast(message)}
            }
    }
}