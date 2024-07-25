package com.example.clientkeeper

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SignInActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        var helper = DBHelper(applicationContext)

        var username= findViewById<EditText>(R.id.editTextUsername)
        var password= findViewById<EditText>(R.id.editTextPassword)
        var btnRegisterLogin = findViewById<Button>(R.id.btnRegisterLogin)

        var indexqlobal = 0

        btnRegisterLogin.setOnClickListener{
            var index = ++indexqlobal

            helper.insertData1(
                index.toString(),
                username.text?.toString()!!,
                password.text?.toString()!!
            )

            val usernameVal = index.toString()
            val bundle = Bundle()
            bundle.putString("usernamePara", usernameVal)

            val gotoNextScreen = Intent(applicationContext,DashboardActivity::class.java)
            gotoNextScreen.putExtras(bundle)
            startActivity(gotoNextScreen)
        }
    }
}