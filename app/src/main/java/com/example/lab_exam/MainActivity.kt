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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab_exam.ui.theme.LABEXAMTheme
import kotlinx.coroutines.time.delay
import java.sql.Date
import javax.security.auth.Subject

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
        composable("citySelection") { QuestionSelectionScreen(navController) }
        composable("question1"){ Question(navController)}
        composable("question2"){ Question01(navController)}
        composable("question3"){ Question02(navController)}
        composable("question4"){ Question03(navController)}
        composable("quizDetails/{points}") { backStackEntry ->
            QuizDetailsScreen(points = backStackEntry.arguments?.getString("cityName") ?: "Unknown" , navController)
        }
        // You will add the Weather Details Screen later
    }

}

data class QuizData(val Subject: String, val Incorrect: String, val earned: String , val total :String)

// A function to mock weather data retrieval
fun getMockQuizData(points: String): QuizData {
    // Replace this logic with actual weather data retrieval logic
    return QuizData(Subject = "Geography", Incorrect = "2",  earned =  "11", total = "227")
}

@Composable
fun QuizDetailsScreen(points: String , navController: NavController) {
    val QuizData = getMockQuizData(points)
    val date = java.util.Date()


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 40.dp, start = 2.dp)) {
        Text(text = "Final Result")
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Subject: ${QuizData.Subject}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Correct: $points")
        Text(text = "Incorrect: ${QuizData.Incorrect}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Earned: ${QuizData.earned}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "OverAll Points: ${QuizData.total}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Date: $date")


        Spacer(modifier = Modifier.padding(top = 100.dp))
        Button(onClick = { navController.navigate("quizDetails/$points")  }) {
            Text(text = "Start Again")

        }
    }
}





@Preview(showBackground = true , showSystemUi = true)
@Composable
fun GreetingPreview() {
    LABEXAMTheme {
        Greeting("Android")
    }
}