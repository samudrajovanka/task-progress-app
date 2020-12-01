package com.ksmandroid.taskreminder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ksmandroid.taskreminder.R
import com.ksmandroid.taskreminder.model.TaskModel
import kotlinx.android.synthetic.main.item_cardview_task.view.*

class TaskAdapter(private val listTask: ArrayList<TaskModel>) : RecyclerView.Adapter<TaskAdapter.CardViewViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_task, parent, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int = listTask.size

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listTask[position])
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(task: TaskModel) {
            with(itemView) {
                tv_name_task.text = task.nameTask
                tv_desc_task.text = task.descTask
                tv_percent_task.text = task.percentTask
            }
        }
    }
}