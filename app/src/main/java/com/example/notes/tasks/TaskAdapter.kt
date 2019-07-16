package com.example.notes.tasks

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.foundations.BaseRecycleAdapter
import com.example.notes.models.Task
import kotlinx.android.synthetic.main.item_note.view.*
import kotlinx.android.synthetic.main.item_task.view.*
import kotlinx.android.synthetic.main.view_todo.view.*

class TaskAdapter(
    taskList: MutableList<Task> = mutableListOf()
): BaseRecycleAdapter<Task>(taskList) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))


    class ViewHolder(view: View): BaseViewHolder<Task>(view) {
        override fun onBind(data: Task) {
            view.titleView.text = data.title

            data.todos.forEach {todo ->
                val todoView = LayoutInflater.from(view.context).inflate(R.layout.view_todo, view.todoContainer, false).apply {
                    todoDescriptionView.text = todo.description
                    completeCheckBox.isChecked = todo.isComplete
                    if (todo.isComplete) {
                        todoDescriptionView.paintFlags = todoDescriptionView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    }
                    completeCheckBox.setOnCheckedChangeListener { button, isChecked ->
                        if (isChecked) {
                            todoDescriptionView.paintFlags = todoDescriptionView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                        } else {
                            todoDescriptionView.paintFlags = todoDescriptionView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                        }
                    }
                }
                view.todoContainer.addView(todoView)
            }

        }
    }
}