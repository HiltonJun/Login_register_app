package com.hilton.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btLogin: Button
    private lateinit var tvRegister: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        findViewById()
        click()
        tvClick()
    }

    private fun findViewById() {
        etEmail = findViewById(R.id.et_email_login)
        etPassword = findViewById(R.id.et_password_login)
        btLogin = findViewById(R.id.bt_login)
        tvRegister = findViewById(R.id.tv_register)
    }

    private fun checkLogin() {
        val email = etEmail.validate()
        val password = etPassword.validate()
        when {
            email -> etEmail.error = getString(R.string.generic_error)
            password -> etPassword.error = getString(R.string.generic_error)
            else -> toast(getString(R.string.login_success))
        }
    }

    private fun click() {
        btLogin.setOnClickListener {
            checkLogin()
        }
    }

    private fun startRegistration() {
        val registerIntent = Intent(this, RegisterActivity::class.java)
        startActivity(registerIntent)
    }

    private fun tvClick() {
        tvRegister.setOnClickListener {
            startRegistration()
        }
    }
}