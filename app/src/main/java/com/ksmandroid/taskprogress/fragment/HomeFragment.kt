package com.ksmandroid.taskprogress.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ksmandroid.taskprogress.R
import com.ksmandroid.taskprogress.adapter.TaskAdapter
import com.ksmandroid.taskprogress.model.Tasks
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        initiateUi()
    }

    override fun onResume() {
        super.onResume()
        showRecyclerCardView()
        showTask()
    }

    private fun initiateUi() {
        showRecyclerCardView()
        showTask()
    }

    private fun showRecyclerCardView() {
        rv_task.setHasFixedSize(true)
        rv_task.layoutManager = LinearLayoutManager(activity)
        val cardViewTaskAdapter = TaskAdapter(activity, Tasks.getTasks())
        rv_task.adapter = cardViewTaskAdapter
    }

    private fun showTask() {
        if (Tasks.getTasks().size == 0) {
            container_no_task.visibility = View.VISIBLE
            rv_task.visibility = View.GONE
        } else {
            container_no_task.visibility = View.GONE
            rv_task.visibility = View.VISIBLE
        }
    }
}