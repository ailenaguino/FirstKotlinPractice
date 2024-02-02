package com.ailenaguino.practica1.imcCalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.ailenaguino.practica1.R
import com.ailenaguino.practica1.imcCalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvBMI: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnReCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvBMI.text = result.toString()
        tvDescription.text = getString(R.string.description)

        when(result) {
            in 0.00..18.50 -> {
                tvResult.text = getString(R.string.title_underweight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.underweight))
            }
            in 18.51..24.99 -> {
                tvResult.text = getString(R.string.title_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
            }
            in 25.00..29.99 -> {
                tvResult.text = getString(R.string.title_overweight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.overweight))
            }
            in 30.00..99.00 -> {
                tvResult.text = getString(R.string.title_obesity)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesity))
            }
            else -> {
                tvResult.text = getString(R.string.error)
                tvBMI.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesity))
            }
        }
    }


    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvBMI = findViewById(R.id.tvBMI)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }
}