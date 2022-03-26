package com.hilton.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startMain()
        }, 3000.toLong())
    }
    private fun startMain(){
        val registerIntent = Intent(this, LoginActivity::class.java)
        startActivity(registerIntent)
    }
}