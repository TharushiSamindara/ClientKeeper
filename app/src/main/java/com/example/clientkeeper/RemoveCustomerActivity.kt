package com.example.clientkeeper

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RemoveCustomerActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remove_customer)

        var helper = DBHelper(applicationContext)

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

        //Remove button
        val btnRemove = findViewById<Button>(R.id.btnRemove)
        btnRemove.setOnClickListener{
            val indexInput = findViewById<EditText>(R.id.editTextEditedIndex)
            val inputIndexValue = indexInput.text.toString()

            val result= helper.removeCustomer(inputIndexValue)

            when(result){
                1->{
                    Toast.makeText(
                        baseContext,
                        "Customer remove successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else->{
                    Toast.makeText(
                        baseContext,
                        "Please check customer index number",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }
}