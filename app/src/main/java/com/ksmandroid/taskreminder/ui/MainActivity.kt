package com.ksmandroid.taskreminder.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ksmandroid.taskreminder.R
import com.ksmandroid.taskreminder.fragment.AddTaskFragment
import com.ksmandroid.taskreminder.fragment.HomeFragment
import com.ksmandroid.taskreminder.fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initiateUi()
    }

    private fun initiateUi() {
        loadFragment(HomeFragment())
        bnv_main.setOnNavigationItemSelectedListener(this)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fl_fragment_main, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> loadFragment(
                HomeFragment()
            )
            R.id.profile -> loadFragment(
                ProfileFragment()
            )
            R.id.add_task -> loadFragment(
                AddTaskFragment()
            )
        }
        return true
    }
}