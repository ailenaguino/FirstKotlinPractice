package com.ailenaguino.practica1.toDoApp

data class Task (val name: String, val category: TaskCategory, var isSelected: Boolean = false)