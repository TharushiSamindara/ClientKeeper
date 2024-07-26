package com.example.clientkeeper

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {
    @SuppressLint("Recycle", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        //set username field in Dashboard
        val i = intent
        val usernameFromLogin : String? = i.getStringExtra("usernamePara")

        val usernameInsert = findViewById<TextView>(R.id.txtDashboardUsername)
        usernameInsert.text = usernameFromLogin

        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnRemove = findViewById<Button>(R.id.btnRemove)
        val btnEdit = findViewById<Button>(R.id.btnEdit)

        //bundle
        val bundle = Bundle()
        bundle.putString("usernamePara", usernameFromLogin)

        //go to search a customer page
        btnSearch.setOnClickListener{
            val gotoNextScreen = Intent(applicationContext,SearchCustomerActivity::class.java)
            gotoNextScreen.putExtras(bundle)
            startActivity(gotoNextScreen)
        }

        //go to add a customer page
        btnAdd.setOnClickListener{
            val gotoNextScreen = Intent(applicationContext,NewCustomerActivity::class.java)
            gotoNextScreen.putExtras(bundle)
            startActivity(gotoNextScreen)
        }

        //go to remove a customer page
        btnRemove.setOnClickListener{
            val gotoNextScreen = Intent(applicationContext,RemoveCustomerActivity::class.java)
            gotoNextScreen.putExtras(bundle)
            startActivity(gotoNextScreen)
        }

        //go to edit a piece of customer information page
        btnEdit.setOnClickListener{
            val gotoNextScreen = Intent(applicationContext,EditCustomerActivity::class.java)
            gotoNextScreen.putExtras(bundle)
            startActivity(gotoNextScreen)
        }
    }
}