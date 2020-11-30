package com.ksmandroid.taskreminder

import android.R
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.ksmandroid.taskreminder.R.layout.activity_main)

        loadFragment(HomeFragment())
        bnv_main.setOnNavigationItemSelectedListener(this)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(com.ksmandroid.taskreminder.R.id.fl_fragment_main, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            com.ksmandroid.taskreminder.R.id.home -> loadFragment(HomeFragment())
            com.ksmandroid.taskreminder.R.id.profile -> loadFragment(ProfileFragment())
            com.ksmandroid.taskreminder.R.id.add_task -> loadFragment(AddTaskFragment())
        }
        return true
    }
}