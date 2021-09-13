package eu.tutorial.ccufoodmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import eu.tutorial.ccufoodmap.fragments.HomeFragment
import eu.tutorial.ccufoodmap.fragments.ListFragment
import eu.tutorial.ccufoodmap.fragments.SettingFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_bar_controller()


    }

    private fun nav_bar_controller()
    {
        val homeFragment :Fragment= HomeFragment()
        val listFragment :Fragment= ListFragment()
        val settingFragment :Fragment= SettingFragment()

        makeCurrentFragment(homeFragment)

        val bottom_nav: BottomNavigationView = findViewById(R.id.bottom_navigation)

        bottom_nav.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_food -> makeCurrentFragment(listFragment)
                R.id.ic_setting -> makeCurrentFragment(settingFragment)
            }
            true
        }
    }
    private fun makeCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }
    // LaLa's code
    /*private var items : ArrayList<String> = ArrayList()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        title = "店家資訊"
        adapter = ArrayAdapter(this,android.R.layout.Store_information, items)
        ListView.adapter = adapter
    }*/
}