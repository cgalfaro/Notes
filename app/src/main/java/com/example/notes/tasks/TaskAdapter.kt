package com.example.notes.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.foundations.BaseRecycleAdapter
import com.example.notes.models.Task
import com.example.notes.views.TaskView
import kotlinx.android.synthetic.main.view_add_button.view.*

class TaskAdapter(
    taskList: MutableList<Task> = mutableListOf()
): BaseRecycleAdapter<Task>(taskList) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = if (viewType == TYPE_INFO) {
        TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
    } else {
        AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
    }

    class TaskViewHolder(view: View): BaseViewHolder<Task>(view) {
        override fun onBind(data: Task) {
            (view as TaskView).initView(data)
        }
    }

    class AddButtonViewHolder(view: View) : BaseRecycleAdapter.AddButtonViewHolder(view) {
        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getText(R.string.add_button_task)
        }
    }
}