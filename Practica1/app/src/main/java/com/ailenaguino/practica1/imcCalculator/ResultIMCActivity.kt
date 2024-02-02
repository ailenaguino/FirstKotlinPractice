package com.ailenaguino.practica1.imcCalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ailenaguino.practica1.R
import com.ailenaguino.practica1.imcCalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
    }
}