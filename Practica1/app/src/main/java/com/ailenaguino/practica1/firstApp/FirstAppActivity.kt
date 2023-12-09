package com.ailenaguino.practica1.firstApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.ailenaguino.practica1.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnPressMe = findViewById<AppCompatButton>(R.id.btnPressMe)
        val etName = findViewById<AppCompatEditText>(R.id.etName)

        btnPressMe.setOnClickListener {

            val name = etName.text.toString()

            if (name.isNotEmpty()){
                Log.i("Practice", "Button pressed, the text reads $name")
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }
        }
    }
}