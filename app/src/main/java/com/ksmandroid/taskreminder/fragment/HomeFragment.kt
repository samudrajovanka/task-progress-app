package com.ksmandroid.taskreminder.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ksmandroid.taskreminder.R
import com.ksmandroid.taskreminder.adapter.TaskAdapter
import com.ksmandroid.taskreminder.model.TaskModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private val list = ArrayList<TaskModel>()

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

    private fun initiateUi() {
        rv_task.setHasFixedSize(true)
        list.addAll(getListTasks())
        showRecyclerCardView()
    }

    fun getListTasks(): ArrayList<TaskModel> {
        val dataName = resources.getStringArray(R.array.task_names)
        val dataDescription = resources.getStringArray(R.array.task_descriptions)
        val dataPercent = resources.getStringArray(R.array.task_percents)

        val listTask = ArrayList<TaskModel>()
        for (position in dataName.indices) {
            val task = TaskModel(
                dataName[position],
                dataDescription[position],
                dataPercent[position] + "%"
            )
            listTask.add(task)
        }
        return listTask
    }

    private fun showRecyclerCardView() {
        rv_task.layoutManager = LinearLayoutManager(activity)
        val cardViewTaskAdapter = TaskAdapter(list)
        rv_task.adapter = cardViewTaskAdapter
    }

}