import com.proyecto_IA.aqi_predictor.model.AQIInput
import retrofit2.http.Body
import retrofit2.http.POST

data class PredictionResponse(val prediccion: String)

interface ApiService {
    @POST("/predict")
    suspend fun predict(@Body input: AQIInput): PredictionResponse
}
