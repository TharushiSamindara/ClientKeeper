package com.example.clientkeeper

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    @SuppressLint("Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var helper = DBHelper(applicationContext)

        var username= findViewById<EditText>(R.id.editTextUsername)
        var password= findViewById<EditText>(R.id.editTextPassword)
        var btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener{
            val db = helper.readableDatabase

            val passwordFromUsername = db.rawQuery("SELECT password FROM UsersDetails WHERE username ='$username'",null)

            if(password == passwordFromUsername){
                val gotoNextScreen = Intent(applicationContext,DashboardActivity::class.java)
                startActivity(gotoNextScreen)
            }
            else{
                Toast.makeText(
                    baseContext,
                    "Incorrect username or password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }





        //go to register (for new user)
        var btnSignIn = findViewById<Button>(R.id.btnSignIn)

        btnSignIn.setOnClickListener{
            val gotoNextScreen = Intent(applicationContext,SignInActivity::class.java)
            startActivity(gotoNextScreen)
        }
    }
}