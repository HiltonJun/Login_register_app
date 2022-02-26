package com.hilton.lesson2

import android.app.Activity
import android.widget.EditText
import android.util.Patterns
import android.widget.Toast
import java.util.regex.Pattern

fun EditText.get() = text.toString().trim()
fun EditText.validate() = text.toString().trim().isEmpty()
fun validateEmail(email: String): Boolean {
    val pattern: Pattern = Patterns.EMAIL_ADDRESS
    return pattern.matcher(email).matches().not()
}

fun Activity.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG)
    .show()