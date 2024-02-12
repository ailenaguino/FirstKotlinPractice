package com.ailenaguino.practica1.superheroApp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ailenaguino.practica1.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun render(superheroItemResponse: SuperheroItemResponse, onItemSelected: (String) -> Unit) {
        binding.tvSuperheroName.text = superheroItemResponse.name
        Picasso.get().load(superheroItemResponse.image.url).into(binding.ivSuperheroList)
        binding.root.setOnClickListener { onItemSelected(superheroItemResponse.id) }
    }
}