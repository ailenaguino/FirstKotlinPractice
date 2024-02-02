package com.ailenaguino.practica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ailenaguino.practica1.firstApp.FirstAppActivity
import com.ailenaguino.practica1.imcCalculator.ImcCalculatorActivity
import com.ailenaguino.practica1.toDoApp.ToDoAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnMsgApp = findViewById<Button>(R.id.btnMsgApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnToDoApp = findViewById<Button>(R.id.btnToDoApp)
        btnMsgApp.setOnClickListener { navigateToMsgApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnToDoApp.setOnClickListener { navigateToToDoApp() }
    }

    private fun navigateToToDoApp() {
        val intent = Intent(this, ToDoAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToMsgApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}