package com.ksmandroid.taskreminder.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ksmandroid.taskreminder.R
import com.ksmandroid.taskreminder.model.Tasks
import kotlinx.android.synthetic.main.activity_detail_task.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailTaskActivity : AppCompatActivity(), View.OnClickListener {
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_task)

        intiateUi()
    }

    private fun intiateUi() {
        val intent = intent
        tv_title_task_detail.text = intent.getStringExtra("NAME_TASK")
        tv_desc_task_detail.text = intent.getStringExtra("DESC_TASK")
        tv_percent_task_detail.text = intent.getStringExtra("PERCENT_TASK")
        index = intent.getIntExtra("POSITION", 0)

        btn_back_toolbar.setOnClickListener(this)
        btn_toolbar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_back_toolbar -> {
                onBackPressed()
            }
            R.id.btn_toolbar -> {
                Tasks.removeTask(index)
                Toast.makeText(this, R.string.alert_success_delete, Toast.LENGTH_LONG).show()
                onBackPressed()
            }
        }
    }
}