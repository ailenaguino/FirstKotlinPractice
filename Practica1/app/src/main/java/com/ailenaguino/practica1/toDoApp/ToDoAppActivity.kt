package com.ailenaguino.practica1.toDoApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ailenaguino.practica1.R
import com.ailenaguino.practica1.toDoApp.TaskCategory.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ToDoAppActivity : AppCompatActivity() {

    private val categories = listOf(
        Business,
        Personal,
        Other
    )

    private val tasks = mutableListOf(
        Task("Prueba business", Business),
        Task("Prueba personal", Personal),
        Task("Prueba other", Other)
    )

    private lateinit var rvCategory: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter

    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_app)
        initComponents()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        dialog.show()
    }

    private fun initUI() {
        categoryAdapter = CategoryAdapter(categories)
        rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategory.adapter = categoryAdapter

        tasksAdapter = TasksAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this) //no se pone lo demas porque es vertical
        rvTasks.adapter = tasksAdapter
    }

    private fun initComponents() {
        rvCategory = findViewById(R.id.rvCategory)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }
}