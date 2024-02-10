package com.ailenaguino.practica1.superheroApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ailenaguino.practica1.R

class SuperheroAdapter(var superheros: List<SuperheroItemResponse> = emptyList()) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        return SuperheroViewHolder(view)
    }

    override fun getItemCount() = superheros.size

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.render(superheros[position])
    }
}