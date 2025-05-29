package com.proyecto_IA.aqi_predictor

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.proyecto_IA.aqi_predictor.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.builtins.ShortArraySerializer
import java.io.DataInput

suspend fun enviarDatosAQI(input: AQIInput): String {
    return try {
        val response = RetrofitClient.api.predict(input)

        response.prediccion // si es PredictionResponse

    } catch (e: Exception) {
        "Error: ${e.localizedMessage}"
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AQISliderScreen(onClickResult :(String) -> Unit = {}){

    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.logo_unab),
                        contentDescription = "Logo unab",
                        modifier = Modifier
                            .height(50.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF668138)
                )
            )
        }
    ){ innerPadding ->
        val temperature = remember { mutableFloatStateOf(25f) }
        val humidity = remember { mutableFloatStateOf(60f) }
        val pmTotal = remember { mutableFloatStateOf(20f) }
        val no2 = remember { mutableFloatStateOf(25f) }
        val so2 = remember { mutableFloatStateOf(10f) }
        val co = remember { mutableFloatStateOf(1f) }
        val proximity = remember { mutableFloatStateOf(1f) }
        val populationDensity = remember { mutableFloatStateOf(500f) }


        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("AQI Predictor",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Box (
                modifier = Modifier
                    .border(2.dp, Color.Black),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.verde),
                    contentDescription = "Verde",
                    modifier = Modifier
                        .padding(12.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                "Ingrese los valores ambientales y demográficos:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            AQISlider("Temperature (°C)", 13f, 50f, temperature)
            AQISlider("Humidity (%)", 30f, 100f, humidity)
            AQISlider("PM total (µg/m³)", 0f, 70f, pmTotal)
            AQISlider("NO2 (ppb)", 5f, 50f, no2)
            AQISlider("SO2 (ppb)", 0f, 25f, so2)
            AQISlider("CO (ppm)", 0f, 25f, co)
            AQISlider("Proximidad a zonas industriales (km)", 0f, 3f, proximity)
            AQISlider("Densidad poblacional (personas/km²)", 188f, 1000f, populationDensity)

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    scope.launch {
                        val input = AQIInput(
                            temperatura = temperature.value,
                            humedad = humidity.value,
                            pmTotal = pmTotal.value,
                            no2 = no2.value,
                            so2 = so2.value,
                            co = co.value,
                            proximidad = proximity.value,
                            densidadPoblacional = populationDensity.value
                        )

                        val prediccion = enviarDatosAQI(input)
                        Log.d("", prediccion);
                        onClickResult(prediccion) // ← ya navega desde Navigation()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(48.dp)
            ) {
                Text("Predecir calidad del aire", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text("\"Realizado por: Leydy Macareo Fuentes y Miguel Ángel Vargas \nn© Unab2025\",\n",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 20.dp)
            )
        }
    }
}

@Composable
fun AQISlider(label: String, min: Float, max: Float, state: MutableState<Float>) {
    Column ( modifier = Modifier
        .fillMaxWidth(0.95f)
        .padding(vertical = 4.dp)
    ) {
        Text("$label: ${"%.2f".format(state.value)}", fontWeight = FontWeight.SemiBold)
        Slider(
            value = state.value,
            onValueChange = { state.value= it },
            valueRange = min..max,
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Red
            )
        )
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun AQISliderScreenPreview(){
    AQISliderScreen()
}

