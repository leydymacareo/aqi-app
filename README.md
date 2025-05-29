# AQI Predictor - App de Predicción de Calidad del Aire

Aplicación desarrollada con Jetpack Compose y Kotlin que predice la calidad del aire (Air Quality Index) según parámetros ambientales y demográficos ingresados por el usuario. Utiliza una API para procesar los datos y mostrar una predicción en tiempo real.

---

## Capturas de pantalla

### Pantalla principal
![Captura de pantalla 28 05 2025 a 22 07 24 p m](https://github.com/user-attachments/assets/e9f0ff8b-e23a-4498-a513-24f49633e592)


### Resultado de predicción 
![Captura de pantalla 28 05 2025 a 22 07 38 p m](https://github.com/user-attachments/assets/ce7585c9-a333-4ef7-9221-125c8fdb89f9)


---

## Características

- Interfaz moderna con Jetpack Compose
- Sliders interactivos para ingresar datos ambientales y demográficos
- Conexión a una API externa para obtener predicciones
- Resultado visual codificado por color (verde, amarillo, naranja, rojo)
- Mensaje explicativo para cada nivel de calidad del aire
- Navegación entre pantallas usando Navigation Compose

---

## 📊 Parámetros utilizados

A continuación se explican los valores que el usuario debe ingresar:

| Parámetro                        | Descripción |
|----------------------------------|-------------|
| Temperatura (°C)                 | Temperatura ambiente en grados Celsius |
| Humedad (%)                      | Porcentaje de humedad relativa del aire |
| PM total (µg/m³)                 | Concentración total de partículas en suspensión (materia particulada) |
| NO₂ (ppb)                        | Concentración de dióxido de nitrógeno en partes por billón |
| SO₂ (ppb)                        | Concentración de dióxido de azufre en partes por billón |
| CO (ppm)                         | Concentración de monóxido de carbono en partes por millón |
| Proximidad a zonas industriales (km) | Distancia aproximada a zonas industriales (en kilómetros) |
| Densidad poblacional (personas/km²) | Cantidad estimada de personas por kilómetro cuadrado en la zona |

---

## Predicciones posibles

El modelo devuelve una de las siguientes predicciones:

| Resultado   | Color      | Significado |
|-------------|------------|-------------|
| Good        | 🟢 Verde   | La calidad del aire es buena. Es segura para toda la población. |
| Moderate    | 🟡 Amarillo| La calidad del aire es aceptable. Puede causar molestias a personas muy sensibles. |
| Poor        | 🟠 Naranja | La calidad del aire es dañina para grupos sensibles como niños, adultos mayores o personas con enfermedades respiratorias. |
| Hazardous   | 🔴 Rojo    | La calidad del aire es peligrosa. Todos deben evitar actividades al aire libre. |

---

## Tecnologías utilizadas

- Kotlin
- Jetpack Compose
- Navigation Compose
- Retrofit 2 (para llamadas HTTP)
- FastAPI / Flask (como backend para el modelo)
- Android Studio Electric Eel / Hedgehog

---
## Repositorio del Backend

Este proyecto utiliza un servidor backend (API REST) para procesar las predicciones. Puedes encontrar el código del backend aquí:

➡️ [Ver repositorio del Backend](https://github.com/leydymacareo/aqi-backend.git)  

---
## Instalación y ejecución

1. Clona este repositorio:
```bash
git clone https://github.com/tu-usuario/aqi-predictor.git
---



