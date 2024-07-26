package com.example.clientkeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RemoveCustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remove_customer)

        //set username field in Dashboard
        val i = intent
        val usernameFromLogin : String? = i.getStringExtra("usernamePara")

        val usernameInsert = findViewById<TextView>(R.id.txtUsername)
        usernameInsert.text = usernameFromLogin

        //back button
        val btnBack = findViewById<Button>(R.id.btnBack)
        val bundle = Bundle()
        bundle.putString("usernamePara", usernameFromLogin)
        btnBack.setOnClickListener{
            val gotoNextScreen = Intent(applicationContext,DashboardActivity::class.java)
            gotoNextScreen.putExtras(bundle)
            startActivity(gotoNextScreen)
        }
    }
}