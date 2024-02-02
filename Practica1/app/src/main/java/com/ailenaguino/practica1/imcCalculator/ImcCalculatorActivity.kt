package com.ailenaguino.practica1.imcCalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.ailenaguino.practica1.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected = true
    private var isFemaleSelected = false
    private var currentAge = 23
    private var currentWeight = 57
    private var currentHeight = 120

    private lateinit var cvMale: CardView
    private lateinit var cvFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnAddAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnAddWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnCalculate: Button

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setGenderColors()
        setAge()
        setWeight()
    }

    private fun initListeners() {
        cvMale.setOnClickListener {
            isMaleSelected = true
            isFemaleSelected = false
            setGenderColors()
        }
        cvFemale.setOnClickListener {
            isMaleSelected = false
            isFemaleSelected = true
            setGenderColors()
        }
        
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }

        btnAddAge.setOnClickListener{
            currentAge += 1
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }

        btnAddWeight.setOnClickListener{
            currentWeight += 1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }

        btnCalculate.setOnClickListener {
            navigateToResult(calculateIMC())
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun initComponents() {
        cvMale = findViewById<CardView>(R.id.cvMale)
        cvFemale = findViewById<CardView>(R.id.cvFemale)
        tvHeight = findViewById<TextView>(R.id.tvHeight)
        rsHeight = findViewById<RangeSlider>(R.id.rsHeight)
        btnAddAge = findViewById<FloatingActionButton>(R.id.btnAddAge)
        btnSubtractAge = findViewById<FloatingActionButton>(R.id.btnSubtractAge)
        tvAge = findViewById<TextView>(R.id.tvAge)
        btnAddWeight = findViewById<FloatingActionButton>(R.id.btnAddWeight)
        btnSubtractWeight = findViewById<FloatingActionButton>(R.id.btnSubtractWeight)
        tvWeight = findViewById<TextView>(R.id.tvWeight)
        btnCalculate = findViewById<Button>(R.id.btnCalculate)
    }

    private fun setGenderColors() {
        cvMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        cvFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(componentIsSelected: Boolean): Int {
        val colorReference = if (componentIsSelected)
            R.color.background_component_selected
        else
            R.color.background_component

        return ContextCompat.getColor(this, colorReference)
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight/(currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        Log.i("IMC", "$imc")
        return df.format(imc).toDouble()
    }

}