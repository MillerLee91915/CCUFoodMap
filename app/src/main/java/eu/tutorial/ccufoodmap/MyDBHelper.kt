package eu.tutorial.ccufoodmap

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MyDBHelper (context: Context) :
        SQLiteOpenHelper(context, name, null, version) {


            override fun onCreate(db: SQLiteDatabase?) {
                val sql = "CREATE TABLE if not exists myTABLE(Store_name text NOT NULL, Store_address text NOT NULL, Store_phone text NOT NULL, Store_tag text NOT NULL)"
                db?.execSQL(sql)
            }

            override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
                db?.execSQL("DROP TABLE IF EXISTS myTABLE")
                onCreate(db)
            }
            companion object{
                val name = "mdatabase.db"
                val version = 1
            }

        }