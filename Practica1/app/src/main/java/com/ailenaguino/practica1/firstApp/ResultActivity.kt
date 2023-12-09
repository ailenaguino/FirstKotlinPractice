package com.ailenaguino.practica1.firstApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.TextViewCompat
import com.ailenaguino.practica1.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<AppCompatTextView>(R.id.tvResultMessage)
        val message: String = intent.extras?.getString("EXTRA_NAME").orEmpty()

        tvResult.text = message
    }
}