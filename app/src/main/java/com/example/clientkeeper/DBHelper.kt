package com.example.clientkeeper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "Client", null, 1) {

    companion object {
        // Table for saving username and password
        const val TABLE_NAME1 = "UsersDetails"
        private const val SQL_CREATE_ENTRIES1 = "CREATE TABLE " + TABLE_NAME1 + " (index_no TEXT, username TEXT, password TEXT)"
        private const val SQL_DELETE_ENTRIES1 = "DROP TABLE IF EXISTS " + TABLE_NAME1

        // Table for saving clients details
        const val TABLE_NAME = "ClientDetails"
        private const val SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " (index_no TEXT, name TEXT, nic TEXT, birthdate TEXT, gender TEXT, pn TEXT, address TEXT, username TEXT)"
        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME
    }

    // onCreate function for both tables
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES1)
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    // onUpgrade for both tables
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES1)
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    // insertData for users details
    fun insertData1(indexNo: String?, username: String, password: String): Long {
        val values = ContentValues().apply {
            put("index_no", indexNo)
            put("username", username)
            put("password", password)
        }

        val db = this.writableDatabase
        val result = db.insert(TABLE_NAME1, null, values)
        db.close()
        return result
    }

    // insertData for clients details
    fun insertData(indexNo: String?, name: String, nic: String?, birthdate: String, gender: String, pn: String, address: String, username: String): Long {
        val values = ContentValues().apply {
            put("index_no", indexNo)
            put("name", name)
            put("nic", nic)
            put("birthdate", birthdate)
            put("gender", gender)
            put("pn", pn)
            put("address", address)
            put("username",username)
        }

        val db = this.writableDatabase
        val result = db.insert(TABLE_NAME, null, values)
        db.close()
        return result
    }

    //edit index no
    fun editIndexNo(indexNo: String?,indexNoNew: String?): Int {
        val values = ContentValues().apply {
            put("indexNo", indexNoNew)
        }

        val db = this.writableDatabase
        val result = db.update(TABLE_NAME, values, "index_no = ?", arrayOf(indexNo))
        db.close()
        return result
    }

    //edit name
    fun editName(indexNo: String?, name: String): Int {
        val values = ContentValues().apply {
            put("name", name)
        }

        val db = this.writableDatabase
        val result = db.update(TABLE_NAME, values, "index_no = ?", arrayOf(indexNo))
        db.close()
        return result
    }

    //edit nic
    fun editNic(indexNo: String?, nic: String): Int {
        val values = ContentValues().apply {
            put("nic", nic)
        }

        val db = this.writableDatabase
        val result = db.update(TABLE_NAME, values, "index_no = ?", arrayOf(indexNo))
        db.close()
        return result
    }

    //edit birthdate
    fun editBirthdate(indexNo: String?, birthdate: String): Int {
        val values = ContentValues().apply {
            put("birthdate", birthdate)
        }

        val db = this.writableDatabase
        val result = db.update(TABLE_NAME, values, "index_no = ?", arrayOf(indexNo))
        db.close()
        return result
    }

    //edit gender
    fun editGender(indexNo: String?, gender: String): Int {
        val values = ContentValues().apply {
            put("gender", gender)
        }

        val db = this.writableDatabase
        val result = db.update(TABLE_NAME, values, "index_no = ?", arrayOf(indexNo))
        db.close()
        return result
    }

    //edit pn no
    fun editPnNo(indexNo: String?, pn: String): Int {
        val values = ContentValues().apply {
            put("pn", pn)
        }

        val db = this.writableDatabase
        val result = db.update(TABLE_NAME, values, "index_no = ?", arrayOf(indexNo))
        db.close()
        return result
    }

    //edit address
    fun editAddress(indexNo: String?, address: String): Int {
        val values = ContentValues().apply {
            put("address", address)
        }

        val db = this.writableDatabase
        val result = db.update(TABLE_NAME, values, "index_no = ?", arrayOf(indexNo))
        db.close()
        return result
    }

    //remove customer
    fun removeCustomer(indexNo: String?): Int {
        val db = this.writableDatabase
        val result = db.delete(TABLE_NAME, "index_no = ?", arrayOf(indexNo))
        db.close()
        return result
    }

    //search customer from Index no
    fun searchCustomerFromIndex(indexNo: String?): Customer? {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            null,
            "index_no = ?",
            arrayOf(indexNo),
            null,
            null,
            null
        )

        var customer: Customer? = null
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                val indexNo = cursor.getString(cursor.getColumnIndexOrThrow("index_no"))
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                val nic = cursor.getString(cursor.getColumnIndexOrThrow("nic"))
                val birthdate = cursor.getString(cursor.getColumnIndexOrThrow("birthdate"))
                val gender = cursor.getString(cursor.getColumnIndexOrThrow("gender"))
                val pn = cursor.getString(cursor.getColumnIndexOrThrow("pn"))
                val address = cursor.getString(cursor.getColumnIndexOrThrow("address"))

                customer = Customer(indexNo, name, nic, birthdate, gender, pn, address)

            }
            cursor.close()
        }
        db.close()
        return customer
    }


    //search customer from NIC
    fun searchCustomerFromNic(NIC: String?): Customer? {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            null,
            "nic = ?",
            arrayOf(NIC),
            null,
            null,
            null
        )

        var customer: Customer? = null
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                val indexNo = cursor.getString(cursor.getColumnIndexOrThrow("index_no"))
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                val nic = cursor.getString(cursor.getColumnIndexOrThrow("nic"))
                val birthdate = cursor.getString(cursor.getColumnIndexOrThrow("birthdate"))
                val gender = cursor.getString(cursor.getColumnIndexOrThrow("gender"))
                val pn = cursor.getString(cursor.getColumnIndexOrThrow("pn"))
                val address = cursor.getString(cursor.getColumnIndexOrThrow("address"))

                customer = Customer(indexNo, name, nic, birthdate, gender, pn, address)
            }
            cursor.close()
        }
        db.close()
        return customer
    }

}
