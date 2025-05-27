package com.proyecto_IA.aqi_predictor

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation() {

    val myNavController = rememberNavController()
    var myStartDestination: String = "sliders"

    NavHost(
        navController = myNavController,
        startDestination = myStartDestination
    ){
        composable("sliders") {
            AQISliderScreen(onClickResult = { pred ->
                myNavController.navigate("resultado/$pred")
            })
        }
        composable("resultado/{prediccion}") { backStackEntry ->
            val prediccion = backStackEntry.arguments?.getString("prediccion") ?: "Desconocido"
            ResultadosScreen(prediccion = prediccion )
            }
        }
    }