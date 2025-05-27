package com.proyecto_IA.aqi_predictor.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance{
    val api: AQIApiService by lazy {
        Retrofit.Builder()
            .baseUrl("http://127.0.2.2:8000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AQIApiService::class.java)
    }
}