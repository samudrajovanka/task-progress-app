package com.ksmandroid.taskreminder.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ksmandroid.taskreminder.R
import com.ksmandroid.taskreminder.model.TaskModel
import com.ksmandroid.taskreminder.model.Tasks
import kotlinx.android.synthetic.main.fragment_add_task.*

class AddTaskFragment : Fragment(), View.OnClickListener {
    private var textNameTask = ""
    private var textDescTask = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        initiateUi()
    }

    private val inputData: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            textNameTask = et_name_task.text.toString().trim()
            textDescTask = et_desc_task.text.toString().trim()
            enableBtnAdd()
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

    private fun initiateUi() {
        btn_add.setOnClickListener(this)

        et_name_task.addTextChangedListener(inputData)
        et_desc_task.addTextChangedListener(inputData)

        enableBtnAdd()
    }

    private fun enableBtnAdd() {
        btn_add.isEnabled = textNameTask.isNotEmpty() && textDescTask.isNotEmpty()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_add -> {
                val randomNumber: Float = (0..100).random().toFloat() / 100
                Tasks.addTask(TaskModel(textNameTask, textDescTask, randomNumber))
                et_name_task.text?.clear()
                et_desc_task.text?.clear()
                hideKeyboard()
                Toast.makeText(activity, R.string.alert_success_add, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}