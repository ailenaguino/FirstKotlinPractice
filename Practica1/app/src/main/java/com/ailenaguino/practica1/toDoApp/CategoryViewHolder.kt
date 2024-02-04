package com.ailenaguino.practica1.toDoApp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ailenaguino.practica1.R

class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val vDivider: View = view.findViewById(R.id.vDivider)


    fun render(taskCategory: TaskCategory) {
        tvCategoryName.text = "EJEMPLO"
    }
}