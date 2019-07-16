package com.example.notes.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.notes.models.Todo
import kotlinx.android.synthetic.main.view_todo.view.*

class TodoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {



    fun initView(todo: Todo) {


        todoDescriptionView.text = todo.description
        completeCheckBox.isChecked = todo.isComplete
        if (todo.isComplete) {
            createStrikeThrough()
        }

        setUpCheckStateListener()
    }

    private fun setUpCheckStateListener() {
        completeCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                createStrikeThrough()
            } else {
                removeStrikeThrugh()
            }
        }
    }

    private fun createStrikeThrough() {
        todoDescriptionView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThrugh() {
        todoDescriptionView.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}
