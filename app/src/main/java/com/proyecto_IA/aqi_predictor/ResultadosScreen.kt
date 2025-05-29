package com.proyecto_IA.aqi_predictor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultadosScreen(prediccion: String, navController: NavController) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.logo_unab),
                        contentDescription = "Logo UNAB",
                        modifier = Modifier.height(50.dp)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF668138)
                )
            )

        }
    ){innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Resultado de la calidad del aire", fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(30.dp))

            val color = when (prediccion.lowercase()) {
                "good" -> Color(0xFFB9DDB2)
                "moderate" -> Color(0xFFFFE082)
                "poor" -> Color(0xFFFFAB91)
                "hazardous" -> Color(0xFFD32F2F)
                else -> Color.LightGray
            }
            val descripcion = when (prediccion.lowercase()) {
                "good" -> "La calidad del aire es buena. Es segura para toda la población."
                "moderate" -> "La calidad del aire es aceptable. Puede causar molestias a personas muy sensibles."
                "poor" -> "La calidad del aire es dañina para grupos sensibles como niños, adultos mayores o personas con enfermedades respiratorias."
                "hazardous" -> "La calidad del aire es peligrosa. Todos deben evitar actividades al aire libre."
                else -> "No se pudo determinar el nivel de calidad del aire."
            }


            Box(
                modifier = Modifier
                    .background(color)
                    .border(1.dp, Color.Black)
                    .padding(12.dp),
            ){
                Text(
                    text = prediccion,
                    fontSize = 24.sp
                )

            }
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = descripcion,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}

