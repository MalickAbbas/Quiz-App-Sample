package com.example.lab_exam

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab_exam.ui.theme.LABEXAMTheme
import kotlinx.coroutines.time.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LABEXAMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("citySelection") { CitySelectionScreen(navController) }
        composable("weatherDetails/{cityName}") { backStackEntry ->
            WeatherDetailsScreen(cityName = backStackEntry.arguments?.getString("cityName") ?: "Unknown")
        }
        // You will add the Weather Details Screen later
    }

}

data class WeatherData(val temperature: String, val humidity: String, val condition: String)

// A function to mock weather data retrieval
fun getMockWeatherData(cityName: String): WeatherData {
    // Replace this logic with actual weather data retrieval logic
    return WeatherData(temperature = "25°C", humidity = "60%", condition = "Sunny")
}

@Composable
fun WeatherDetailsScreen(cityName: String) {
    val weatherData = getMockWeatherData(cityName)

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "Weather Details")
        Spacer(modifier = Modifier.height(32.dp))
        Row {
            Text(text = "City Name: $cityName")
           // Image(painter = painterResource(id = androidx.core.R.drawable.), contentDescription = "")
        }
        Text(text = "City Name: $cityName")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Temperature: ${weatherData.temperature}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Humidity: ${weatherData.humidity}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Condition: ${weatherData.condition}")
    }
}


@Preview(showBackground = true , showSystemUi = true)
@Composable
fun GreetingPreview() {
    LABEXAMTheme {
        Greeting("Android")
    }
}