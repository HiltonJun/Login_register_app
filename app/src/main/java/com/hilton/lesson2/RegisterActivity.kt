package com.hilton.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.hilton.lesson2.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startBinding()
        btClick()
    }

    private fun startBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        binding.root
    }

    private fun checkRegister() {
        val name = binding.etNameRegister.validate()
        val email = binding.etEmailRegister.validate()
        val password = binding.etPasswordRegister.validate()
        val confirmation = binding.etPasswordConfirmation.validate()
        val validEmail = validateEmail(binding.etEmailRegister.get())
        val passwordLength = binding.etPasswordRegister.length() < 8
        val passwordConfirm =
            binding.etPasswordConfirmation.get() != binding.etPasswordRegister.get()
        when {
            name -> binding.etNameRegister.error = getString(R.string.generic_error)
            email -> binding.etEmailRegister.error = getString(R.string.generic_error)
            validEmail -> binding.etEmailRegister.error = getString(R.string.invalid_email)
            password -> binding.etPasswordRegister.error = getString(R.string.generic_error)
            passwordLength -> binding.etPasswordRegister.error =
                getString(R.string.invalid_password)
            confirmation -> binding.etPasswordConfirmation.error = getString(R.string.generic_error)
            passwordConfirm -> binding.etPasswordConfirmation.error =
                getString(R.string.invalid_confirmation)
            else -> registerToFireBase(
                binding.etEmailRegister.get(),
                binding.etPasswordConfirmation.get()
            )
        }

    }

    private fun btClick() {
        binding.btRegisterEnd.setOnClickListener {
            checkRegister()
        }
    }

    private fun registerToFireBase(email: String, password: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { finish() }
            .addOnFailureListener { errorCase ->
                errorCase.message?.let { message -> toast(message) }
            }
    }

}