package com.ksmandroid.taskreminder.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.ksmandroid.taskreminder.R
import com.ksmandroid.taskreminder.model.TaskModel
import com.ksmandroid.taskreminder.ui.DetailTaskActivity
import kotlinx.android.synthetic.main.item_cardview_task.view.*

class TaskAdapter(
    private val activty: FragmentActivity?,
    private val listTask: ArrayList<TaskModel>
) : RecyclerView.Adapter<TaskAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_task, parent, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int = listTask.size

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listTask[position], position)
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(task: TaskModel, position: Int) {
            with(itemView) {
                val randomNumber: Float = task?.percentTask!!.toFloat()
                val textNumber = (randomNumber * 100).toInt()

                tv_name_task.text = task.nameTask
                tv_desc_task.text = task.descTask
                tv_percent_task.text = "$textNumber%"

                itemView.setOnClickListener {

                    val intent = Intent(activty, DetailTaskActivity::class.java)

                    intent.putExtra("NAME_TASK", task.nameTask)
                    intent.putExtra("DESC_TASK", task.descTask)
                    intent.putExtra("PERCENT_TASK", "$textNumber%")
                    intent.putExtra("POSITION", position)

                    activty?.startActivity(intent)
                }
            }
        }
    }
}