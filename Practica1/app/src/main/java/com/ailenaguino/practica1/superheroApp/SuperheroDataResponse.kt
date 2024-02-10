package com.ailenaguino.practica1.superheroApp

import com.google.gson.annotations.SerializedName

data class SuperheroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheros: List<SuperheroItemResponse>
)

data class SuperheroItemResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)