package com.ailenaguino.practica1.imcCalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.ailenaguino.practica1.R

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected = true
    private var isFemaleSelected = false

    private lateinit var cvMale: CardView
    private lateinit var cvFemale: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setGenderColors()
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
    }

    private fun initComponents() {
        cvMale = findViewById<CardView>(R.id.cvMale)
        cvFemale = findViewById<CardView>(R.id.cvFemale)
    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
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
}