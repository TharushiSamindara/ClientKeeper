package com.example.clientkeeper

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class EditCustomerActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_customer)

        //set username field in Dashboard
        val i = intent
        val usernameFromLogin : String? = i.getStringExtra("usernamePara")

        val usernameInsert = findViewById<TextView>(R.id.txtUsername)
        usernameInsert.text = usernameFromLogin

        //button edit detail
        val btnEdit = findViewById<Button>(R.id.btnEdit)

        btnEdit.setOnClickListener{
            //get edited customer index
            val editedCustomerIndex = findViewById<EditText>(R.id.editTextEditedIndex)
            val customerIndex = editedCustomerIndex.text.toString()

            //get column name using radio button group
            val editColumn = findViewById<RadioGroup>(R.id.radioGroup)
            val editDetailColumn = editColumn.checkedRadioButtonId
            val editColumnName: String

            if (editDetailColumn != -1) {
                // Find the RadioButton by ID
                val selectedRadioButton: RadioButton = findViewById(editDetailColumn)

                when (selectedRadioButton.text) {
                    "radioIndexNo" -> {
                        editColumnName = "index_no"
                    }
                    "radioName" -> {
                        editColumnName = "name"
                    }
                    "radioNIC" -> {
                        editColumnName = "nic"
                    }
                    "radioBirthdate" -> {
                        editColumnName = "birthdate"
                    }
                    "radioGender" -> {
                        editColumnName = "gender"
                    }
                    "radioPnNo" -> {
                        editColumnName = "pn"
                    }
                    else -> {
                        editColumnName = "address"
                    }
                }

            } else {
                // No RadioButton is selected
                Toast.makeText(this, "No option selected", Toast.LENGTH_SHORT).show()
            }

            //get new input
            val newInput = findViewById<EditText>(R.id.editTextNewDetail)
            val newDetail = newInput.text.toString()
        }


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