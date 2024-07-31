package com.example.clientkeeper

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class SearchCustomerActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_customer)

        //set username field in Dashboard
        val i = intent
        val usernameFromLogin : String? = i.getStringExtra("usernamePara")

        val usernameInsert = findViewById<TextView>(R.id.txtUsername)
        usernameInsert.text = usernameFromLogin

        //radio button
        val editColumn = findViewById<RadioGroup>(R.id.radioGroupFind)
        val editDetailColumn = editColumn.checkedRadioButtonId

        //back button
        val btnBack = findViewById<Button>(R.id.btnBack)
        val bundle = Bundle()
        bundle.putString("usernamePara", usernameFromLogin)
        btnBack.setOnClickListener{
            val gotoNextScreen = Intent(applicationContext,DashboardActivity::class.java)
            gotoNextScreen.putExtras(bundle)
            startActivity(gotoNextScreen)
        }

        //Search button
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        btnSearch.setOnClickListener{
            val cusDetailEditText = findViewById<EditText>(R.id.editTextSearchingDetail)
            val customerDetail = cusDetailEditText.text.toString()

            if (customerDetail.isEmpty()) {
                Toast.makeText(this, "Enter Customer Detail", Toast.LENGTH_SHORT).show()
            } else {
                ///////////////////////////////////
                if (editDetailColumn != -1) {
                    // Find the RadioButton by ID
                    val selectedRadioButton: RadioButton = findViewById(editDetailColumn)


                    //When all the date are entered
                    var helper = DBHelper(applicationContext)

                    var result: Customer? = null

                    when (selectedRadioButton.text) {
                        "radioIndexNo" -> {
                            result = helper.searchCustomerFromIndex(customerDetail)!!
                        }
                        "radioNIC" -> {
                            result = helper.searchCustomerFromNic(customerDetail)!!
                        }
                        else -> {
                            Toast.makeText(
                                baseContext,
                                "Not Updated",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    when(result){
                        null -> {
                            Toast.makeText(
                                baseContext,
                                "Can't find customer from your given details",
                                Toast.LENGTH_SHORT
                            ).show()

                        }else -> {
                            // Handle the case where a customer was found
                            val intent = Intent(this, SearchCustomerActivity2::class.java).apply {
                                putExtra("indexNo", result.indexNo)
                                putExtra("name", result.name)
                                putExtra("nic", result.nic)
                                putExtra("birthdate", result.birthdate)
                                putExtra("gender", result.gender)
                                putExtra("pn", result.pn)
                                putExtra("address", result.address)
                            }
                            startActivity(intent)
                        }
                    }


                } else {
                    // No RadioButton is selected
                    Toast.makeText(this, "No option selected", Toast.LENGTH_SHORT).show()
                }
                /////////////////////////////////
            }
        }
    }
}