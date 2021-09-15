package eu.tutorial.ccufoodmap

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MYDBControler : AppCompatActivity(){
    private var items : ArrayList<String> = ArrayList()
    private  lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.fragment_list)

        title = "店家資訊"
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        //ListView.adapter = adapter
    }
    private var db : SQLiteDatabase = MyDBHelper(this).writableDatabase

}