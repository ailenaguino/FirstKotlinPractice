package com.ailenaguino.practica1.superheroApp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ailenaguino.practica1.databinding.ItemSuperheroBinding

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun render(superheroItemResponse: SuperheroItemResponse) {
        binding.tvSuperheroName.text = superheroItemResponse.name
    }
}