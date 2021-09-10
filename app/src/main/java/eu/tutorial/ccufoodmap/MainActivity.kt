package eu.tutorial.ccufoodmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import eu.tutorial.ccufoodmap.fragments.HomeFragment
import eu.tutorial.ccufoodmap.fragments.ListFragment
import eu.tutorial.ccufoodmap.fragments.SettingFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //var for buttom nav bar
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
}