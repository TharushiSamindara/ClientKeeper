package com.example.clientkeeper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.Date

class DBHelper(context: Context):
SQLiteOpenHelper(context, "Client", null, 1){

    companion object{
        const val TABLE_NAME = "ClientDetails"
        private const val SQL_CREATE_ENTRIES = "CREATE TABLE" + TABLE_NAME + "(index_no TEXT," + "name TEXT , nic TEXT , birthdate TEXT, gender TEXT, pn TEXT, address TEXT)"
        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME
    }
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion:
    Int){
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun insertData(indexNo:String?,name:String, nic:String?, birthdate:String ,gender:String ,pn:String, address:String){
        val values = ContentValues()
        values.put("index_no", indexNo)
        values.put("name", name)
        values.put("nic", nic)
        values.put("birthdate",birthdate)
        values.put("gender", gender)
        values.put("pn", pn)
        values.put("address",address)

        val db = this.writableDatabase
        db.insert(TABLE_NAME,null,values)

    }

}