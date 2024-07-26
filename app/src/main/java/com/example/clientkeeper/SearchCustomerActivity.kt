package com.example.clientkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SearchCustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_customer)

        //set username field in Dashboard
        val i = intent
        val usernameFromLogin : String? = i.getStringExtra("usernamePara")

        val usernameInsert = findViewById<TextView>(R.id.txtUsername)
        usernameInsert.text = usernameFromLogin
    }
}