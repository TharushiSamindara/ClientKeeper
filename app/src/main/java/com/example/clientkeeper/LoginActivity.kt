package com.example.clientkeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var helper = DBHelper(applicationContext)

        var username= findViewById<EditText>(R.id.editTextUsername)
        var password= findViewById<EditText>(R.id.editTextPassword)
        var btnLogin = findViewById<Button>(R.id.btnLogin)
        var btnSignIn = findViewById<Button>(R.id.btnSignIn)

        //go to register (for new user)
        btnSignIn.setOnClickListener{
            val gotoNextScreen = Intent(applicationContext,SignInActivity::class.java)
            startActivity(gotoNextScreen)
        }
    }
}