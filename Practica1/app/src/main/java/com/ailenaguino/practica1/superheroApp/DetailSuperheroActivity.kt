package com.ailenaguino.practica1.superheroApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.isVisible
import com.ailenaguino.practica1.R
import com.ailenaguino.practica1.databinding.ActivityDetailSuperheroBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailSuperheroActivity : AppCompatActivity() {

    companion object{
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
            if(shDetailResponse.isSuccessful){
                if(shDetailResponse.body() != null){
                    runOnUiThread {
                        createUI(shDetailResponse.body()!!)
                    }
                }
            }
        }
    }

    private fun createUI(body: SuperheroDetailResponse) {

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}