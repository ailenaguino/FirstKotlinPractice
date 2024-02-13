package com.ailenaguino.practica1.superheroApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import com.ailenaguino.practica1.R
import com.ailenaguino.practica1.databinding.ActivityDetailSuperheroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperheroActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding: ActivityDetailSuperheroBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getStringExtra(EXTRA_ID).orEmpty()
        retrofit = getRetrofit()
        getSuperheroDetail(id)
    }

    private fun getSuperheroDetail(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val shDetailResponse = retrofit.create(ApiService::class.java).getSuperhero(id)
            if (shDetailResponse.isSuccessful) {
                if (shDetailResponse.body() != null) {
                    runOnUiThread {
                        createUI(shDetailResponse.body()!!)
                    }
                }
            }
        }
    }

    private fun createUI(body: SuperheroDetailResponse) {
        Picasso.get().load(body.image.url).into(binding.ivSuperheroDetail)
        binding.tvSuperheroNameDetail.text = body.name
        prepareStats(body.powerstats)
    }

    private fun prepareStats(powerstats: SuperheroPowerstatsResponse) {
        updateHeight(binding.vCombat, powerstats.combat)
        updateHeight(binding.vDurability, powerstats.durability)
        updateHeight(binding.vIntelligence, powerstats.intelligence)
        updateHeight(binding.vPower, powerstats.power)
        updateHeight(binding.vSpeed, powerstats.speed)
        updateHeight(binding.vStrength, powerstats.strength)

    }

    private fun updateHeight(view: View, stat: String) {
        val params = view.layoutParams //obtengo los parametros de la view
        params.height = pxToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pxToDp(px: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics)
            .roundToInt()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}