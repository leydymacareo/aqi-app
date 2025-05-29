package com.proyecto_IA.aqi_predictor.model

data class AQIInput(
    val temperatura: Float,
    val humedad: Float,
    val pmTotal: Float,
    val no2: Float,
    val so2: Float,
    val co: Float,
    val proximidad: Float,
    val densidadPoblacional: Float
)

data class AQIResponse(
    val prediccion: String
)
