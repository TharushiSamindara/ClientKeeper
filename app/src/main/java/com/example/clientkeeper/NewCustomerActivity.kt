package com.example.clientkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class NewCustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_customer)

        var helper = DBHelper(applicationContext)

        var indexNo = findViewById<EditText>(R.id.editTextIndexNo)
        var name = findViewById<EditText>(R.id.editTextName)
        var nic = findViewById<EditText>(R.id.editTextNIC)
        var birthdate = findViewById<EditText>(R.id.editTextBirthdate)
        var gender = findViewById<EditText>(R.id.editTextGender)
        var pnNo = findViewById<EditText>(R.id.editTextPn)
        var address = findViewById<EditText>(R.id.editTextAddress)

        var btnSubmit = findViewById<Button>(R.id.btnSubmitCustomer)

        var indexqlobal = 0

        btnSubmit.setOnClickListener {
            var index = ++indexqlobal

            helper.insertData(
                indexNo.toString(),
                name.text?.toString()!!,
                nic.text?.toString()!!,
                birthdate.text?.toString()!!,
                gender.text?.toString()!!,
                pnNo.text?.toString()!!,
                address.text?.toString()!!,
            )

            Toast.makeText(
                baseContext,
                "Successfully Entered your new customer details",
                Toast.LENGTH_SHORT
            ).show()

        }
    }
}