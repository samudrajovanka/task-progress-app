package com.ksmandroid.taskreminder.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ksmandroid.taskreminder.R
import com.ksmandroid.taskreminder.adapter.TaskAdapter
import com.ksmandroid.taskreminder.fragment.AddTaskFragment
import com.ksmandroid.taskreminder.fragment.HomeFragment
import com.ksmandroid.taskreminder.fragment.ProfileFragment
import com.ksmandroid.taskreminder.model.TaskModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

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
        when(item.itemId) {
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