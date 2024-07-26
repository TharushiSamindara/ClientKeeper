package com.example.clientkeeper

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class NewCustomerActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_customer)

        //set username field in Dashboard
        val i = intent
        val usernameFromLogin : String? = i.getStringExtra("usernamePara")

        val usernameInsert = findViewById<TextView>(R.id.txtUsername)
        usernameInsert.text = usernameFromLogin

        val helper = DBHelper(applicationContext)

        val indexNo = findViewById<EditText>(R.id.editTextIndexNo)
        val name = findViewById<EditText>(R.id.editTextName)
        val nic = findViewById<EditText>(R.id.editTextNIC)
        val birthdate = findViewById<EditText>(R.id.editTextBirthdate)
        val gender = findViewById<EditText>(R.id.editTextGender)
        val pnNo = findViewById<EditText>(R.id.editTextPn)
        val address = findViewById<EditText>(R.id.editTextAddress)

        val btnSubmit = findViewById<Button>(R.id.btnSubmitCustomer)

        btnSubmit.setOnClickListener {
            helper.insertData(
                indexNo.toString(),
                name.text?.toString()!!,
                nic.text?.toString()!!,
                birthdate.text?.toString()!!,
                gender.text?.toString()!!,
                pnNo.text?.toString()!!,
                address.text?.toString()!!,
                usernameFromLogin!!
            )

            Toast.makeText(
                baseContext,
                "Successfully Entered your new customer details",
                Toast.LENGTH_SHORT
            ).show()

        }

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