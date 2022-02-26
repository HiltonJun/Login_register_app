package com.hilton.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPasssword: EditText
    private lateinit var etPasswordConf: EditText
    private lateinit var btRegister: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        findViewById()
        btClick()
    }

    private fun findViewById() {
        etName = findViewById(R.id.et_name_register)
        etEmail = findViewById(R.id.et_email_register)
        etPasssword = findViewById(R.id.et_password_register)
        etPasswordConf = findViewById(R.id.et_password_confirmation)
        btRegister = findViewById(R.id.bt_register_end)
    }

    private fun checkRegister() {
        val name = etName.validate()
        val email = etEmail.validate()
        val password = etPasssword.validate()
        val confirmation = etPasswordConf.validate()
        val validEmail = validateEmail(etEmail.get())
        val passwordLength = etPasssword.length() < 8
        val passwordConfirm = etPasswordConf.get() != etPasssword.get()
        when {
            name -> etName.error = getString(R.string.generic_error)
            email -> etEmail.error = getString(R.string.generic_error)
            validEmail -> etEmail.error = getString(R.string.invalid_email)
            password -> etPasssword.error = getString(R.string.generic_error)
            passwordLength -> etPasssword.error = getString(R.string.invalid_password)
            confirmation -> etPasswordConf.error = getString(R.string.generic_error)
            passwordConfirm -> etPasswordConf.error = getString(R.string.invalid_confirmation)
            else -> toast(getString(R.string.registration_success))
        }

    }

    private fun btClick() {
        btRegister.setOnClickListener {
            checkRegister()
        }
    }


}