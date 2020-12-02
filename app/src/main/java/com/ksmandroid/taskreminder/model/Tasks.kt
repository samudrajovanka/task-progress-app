package com.ksmandroid.taskreminder.model

class Tasks {
    companion object {
        private val list = ArrayList<TaskModel>()

        fun addTask(task: TaskModel) {
            list.add(task)
        }

        fun getTasks(): ArrayList<TaskModel> {
            return list
        }

        fun removeTask(index: Int) {
            list.removeAt(index)
        }
    }
}

