package com.example.notes.note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.foundations.BaseRecycleAdapter
import com.example.notes.models.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter(
    noteList: MutableList<Note> = mutableListOf()
): BaseRecycleAdapter<Note>(noteList) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))


    class ViewHolder(view: View): BaseViewHolder<Note>(view) {
        override fun onBind(data: Note) {
            view.descriptionView.text = data.description
        }
    }
}