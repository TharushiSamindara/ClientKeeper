package com.example.clientkeeper

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {
    @SuppressLint("Recycle", "WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Set username field in Dashboard
        val i = intent
        val usernameFromLogin: String? = i.getStringExtra("usernamePara")
        val usernameInsert = findViewById<TextView>(R.id.txtDashboardUsername)
        usernameInsert.text = usernameFromLogin

        // Fetch and display customer details
        val customerDetailsContainer = findViewById<LinearLayout>(R.id.customerDetailsContainer)
        val dbHelper = DBHelper(applicationContext)

        // Retrieve all customers from the database
        val customers = dbHelper.getAllCustomers()

        // Add each customer detail to the ScrollView
        customers.forEach { customer ->
            addCustomerDetails(customerDetailsContainer, customer)
        }

        // Set up button listeners (search, add, remove, edit)
        val bundle = Bundle().apply {
            putString("usernamePara", usernameFromLogin)
        }

        findViewById<Button>(R.id.btnSearch).setOnClickListener {
            val gotoNextScreen = Intent(applicationContext, SearchCustomerActivity::class.java)
            gotoNextScreen.putExtras(bundle)
            startActivity(gotoNextScreen)
        }

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            val gotoNextScreen = Intent(applicationContext, NewCustomerActivity::class.java)
            gotoNextScreen.putExtras(bundle)
            startActivity(gotoNextScreen)
        }

        findViewById<Button>(R.id.btnRemove).setOnClickListener {
            val gotoNextScreen = Intent(applicationContext, RemoveCustomerActivity::class.java)
            gotoNextScreen.putExtras(bundle)
            startActivity(gotoNextScreen)
        }

        findViewById<Button>(R.id.btnEdit).setOnClickListener {
            val gotoNextScreen = Intent(applicationContext, EditCustomerActivity::class.java)
            gotoNextScreen.putExtras(bundle)
            startActivity(gotoNextScreen)
        }
    }

    private fun addCustomerDetails(container: LinearLayout, customer: Customer) {
        container.addView(createTextView("Index No: ${customer.indexNo}"))
        container.addView(createTextView("Name: ${customer.name}"))
        container.addView(createTextView("NIC: ${customer.nic}"))
        container.addView(createTextView("Birthdate: ${customer.birthdate}"))
        container.addView(createTextView("Gender: ${customer.gender}"))
        container.addView(createTextView("Phone Number: ${customer.pn}"))
        container.addView(createTextView("Address: ${customer.address}"))
        container.addView(createTextView("--------------------------"))
    }

    private fun createTextView(text: String): TextView {
        val textView = TextView(this)
        textView.apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            this.text = text
            textSize = 16f
            setPadding(8, 8, 8, 8)
        }
        return textView
    }
}
