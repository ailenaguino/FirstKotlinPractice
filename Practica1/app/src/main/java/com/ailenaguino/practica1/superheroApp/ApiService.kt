package com.ailenaguino.practica1.superheroApp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/7430509820304003/search/{name}")
    suspend fun getSuperheros(@Path("name") superheroName: String): Response<SuperheroDataResponse>

    @GET("/api/7430509820304003/{id}")
    suspend fun getSuperhero(@Path("id") superheroId: String): Response<SuperheroDetailResponse>
}