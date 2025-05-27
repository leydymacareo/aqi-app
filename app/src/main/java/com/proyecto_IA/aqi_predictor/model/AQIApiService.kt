package com.proyecto_IA.aqi_predictor.model

import com.proyecto_IA.aqi_predictor.model.AQIInput
import com.proyecto_IA.aqi_predictor.model.AQIResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AQIApiService{
    @POST("/predict")
    suspend fun getPrediction(@Body input: AQIInput): Response<AQIResponse>
}