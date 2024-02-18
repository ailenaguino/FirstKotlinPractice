package com.ailenaguino.practica1.superheroApp

import com.google.gson.annotations.SerializedName

data class SuperheroDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: SuperheroPowerstatsResponse,
    @SerializedName("image") val image: SuperheroImageResponse,
    @SerializedName("biography") val biography: BiographyResponse
)

data class SuperheroPowerstatsResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class BiographyResponse(
    @SerializedName("full-name") val fullname: String,
    @SerializedName("publisher") val publisher: String
)