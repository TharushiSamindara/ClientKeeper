package com.example.clientkeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SearchCustomerActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_customer2)

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
            val gotoNextScreen = Intent(applicationContext,SearchCustomerActivity::class.java)
            gotoNextScreen.putExtras(bundle)
            startActivity(gotoNextScreen)
        }

        val txtIndexNo = findViewById<TextView>(R.id.txtIndexNo)
        val txtName = findViewById<TextView>(R.id.txtName)
        val txtNIC = findViewById<TextView>(R.id.txtNIC)
        val txtBirthdate = findViewById<TextView>(R.id.txtBirthdate)
        val txtGender = findViewById<TextView>(R.id.txtGender)
        val txtPn = findViewById<TextView>(R.id.txtPnNo)
        val txtAddress = findViewById<TextView>(R.id.txtAddress)

        // Retrieve the intent extras
        val indexNo = intent.getStringExtra("indexNo")
        val name = intent.getStringExtra("name")
        val nic = intent.getStringExtra("nic")
        val birthdate = intent.getStringExtra("birthdate")
        val gender = intent.getStringExtra("gender")
        val pn = intent.getStringExtra("pn")
        val address = intent.getStringExtra("address")

        // Assign the retrieved data to the TextViews
        txtIndexNo.text = indexNo
        txtName.text = name
        txtNIC.text = nic
        txtBirthdate.text = birthdate
        txtGender.text = gender
        txtPn.text = pn
        txtAddress.text = address
    }
}