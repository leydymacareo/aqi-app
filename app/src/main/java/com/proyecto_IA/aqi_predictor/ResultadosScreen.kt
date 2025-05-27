package com.proyecto_IA.aqi_predictor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultadosScreen(prediccion: String) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.logo_unab),
                        contentDescription = "Logo UNAB",
                        modifier = Modifier.height(50.dp)
                    )
                },colors = TopAppBarDefaults.topAppBarColors(
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(12.dp))
            Text("Resultado de la calidad del aire", fontSize = 22.sp, fontWeight = FontWeight.Bold)

            Box(
                modifier = Modifier
                    .background(Color(0xFFB9DDB2))
                    .border(1.dp, Color.Black)
                    .padding(12.dp)
            ){
                Text(
                    text = "Calidad del Aire: $prediccion"
                )
            }
        }
    }
}

@Composable
@Preview
fun ResultadosPreview(){
    ResultadosScreen(prediccion = String())
}