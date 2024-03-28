package com.example.lab_exam

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lab_exam.ui.theme.LABEXAMTheme

class CitySelectionScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LABEXAMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // Greeting2("Android")
                }
            }
        }
    }
}


@Composable
fun QuestionSelectionScreen(navController: NavController) {
    var marks by remember {
        mutableStateOf(0)
    }
    var points by remember { mutableStateOf("3") }
    var question by remember {
        mutableStateOf(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "What is the Capital Of France",
            modifier = Modifier.align(Alignment.Start)
        )



        val radioOptions4 = listOf("Paris", "London", "Berlin", "Madrid")
        val (selectedOption4, onOptionSelected4) = remember { mutableStateOf(radioOptions4[2]) }



        // we are displaying all our
        // radio buttons in column.
        Column {
            // below line is use to set data to
            // each radio button in columns.
            radioOptions4.forEach { text ->
                Row(
                    Modifier
                        // using modifier to add max
                        // width to our radio button.
                        .fillMaxWidth()
                        // below method is use to add
                        // selectable to our radio button.
                        .selectable(
                            // this method is called when
                            // radio button is selected.
                            selected = (text == selectedOption4),
                            // below method is called on
                            // clicking of radio button.
                            onClick = { onOptionSelected4(text) }
                        )
                        // below line is use to add
                        // padding to radio button.
                        .padding(horizontal = 16.dp)
                ) {
                    // below line is use to get context.
                    //  val context = ContextAmbient.current

                    // below line is use to
                    // generate radio button
                    RadioButton(
                        // inside this method we are
                        // adding selected with a option.
                        selected = (text == selectedOption4), modifier = Modifier.padding(),
                        onClick = {
                            // inside on click method we are setting a
                            // selected option of our radio buttons.
                            onOptionSelected4(text)

                            // after clicking a radio button
                            // we are displaying a toast message.
                            // Toast.makeText(context, text, Toast.LENGTH_LONG).show()
                        }
                    )
                    // below line is use to add
                    // text to our radio buttons.
                    Text(
                        text = text,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }




        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                    if(question == 5)
                    navController.navigate("quizDetails/$points")
                else {
                    question = question + 1
                        navController.navigate("question1")
                }

            },
            //enabled = points.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            if (question == 5)
            Text("Finish")
            else Text(text = "Next")

        }
    }
}


@Composable
fun Question(navController: NavController){
    var marks by remember {
        mutableStateOf(0)
    }
    var points by remember { mutableStateOf("3") }
    var question by remember {
        mutableStateOf(2)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(
            text = "Who wrote the hamlet",
            modifier = Modifier.align(Alignment.Start)
        )



        // RadioButton(selected = , onClick = { /*TODO*/ })



        val radioOptions3 = listOf("William Shakespera", "Charles Dicken", "Leo Tolstoy", "Mark Twain")
        val (selectedOption3, onOptionSelected3) = remember { mutableStateOf(radioOptions3[2]) }



        // we are displaying all our
        // radio buttons in column.
        Column {
            // below line is use to set data to
            // each radio button in columns.
            radioOptions3.forEach { text ->
                Row(
                    Modifier
                        // using modifier to add max
                        // width to our radio button.
                        .fillMaxWidth()
                        // below method is use to add
                        // selectable to our radio button.
                        .selectable(
                            // this method is called when
                            // radio button is selected.
                            selected = (text == selectedOption3),
                            // below method is called on
                            // clicking of radio button.
                            onClick = { onOptionSelected3(text) }
                        )
                        // below line is use to add
                        // padding to radio button.
                        .padding(horizontal = 16.dp)
                ) {
                    // below line is use to get context.
                    //  val context = ContextAmbient.current

                    // below line is use to
                    // generate radio button
                    RadioButton(
                        // inside this method we are
                        // adding selected with a option.
                        selected = (text == selectedOption3), modifier = Modifier.padding(),
                        onClick = {
                            // inside on click method we are setting a
                            // selected option of our radio buttons.
                            onOptionSelected3(text)

                            // after clicking a radio button
                            // we are displaying a toast message.
                            // Toast.makeText(context, text, Toast.LENGTH_LONG).show()
                        }
                    )
                    // below line is use to add
                    // text to our radio buttons.
                    Text(
                        text = text,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }



        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if(question == 5)
                    navController.navigate("quizDetails/$points")
                else {

                    navController.navigate("question2")
                }

            },
            //enabled = points.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            if (question == 5)
                Text("Finish")
            else Text(text = "Next")

        }
    }
}

@Composable
fun Question01(navController: NavController){
    var marks by remember {
        mutableStateOf(0)
    }
    var points by remember { mutableStateOf("3") }
    var question by remember {
        mutableStateOf(3)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(
            text = "What is the smallest planet in our solar system?",
            modifier = Modifier.align(Alignment.Start)
        )



        // RadioButton(selected = , onClick = { /*TODO*/ })



        val radioOptions2 = listOf("Mercury", "Venus", "Earth", "Mars")
        val (selectedOption2, onOptionSelected2) = remember { mutableStateOf(radioOptions2[2]) }



        // we are displaying all our
        // radio buttons in column.
        Column {
            // below line is use to set data to
            // each radio button in columns.
            radioOptions2.forEach { text ->
                Row(
                    Modifier
                        // using modifier to add max
                        // width to our radio button.
                        .fillMaxWidth()
                        // below method is use to add
                        // selectable to our radio button.
                        .selectable(
                            // this method is called when
                            // radio button is selected.
                            selected = (text == selectedOption2),
                            // below method is called on
                            // clicking of radio button.
                            onClick = { onOptionSelected2(text) }
                        )
                        // below line is use to add
                        // padding to radio button.
                        .padding(horizontal = 16.dp)
                ) {
                    // below line is use to get context.
                    //  val context = ContextAmbient.current

                    // below line is use to
                    // generate radio button
                    RadioButton(
                        // inside this method we are
                        // adding selected with a option.
                        selected = (text == selectedOption2), modifier = Modifier.padding(),
                        onClick = {
                            // inside on click method we are setting a
                            // selected option of our radio buttons.
                            onOptionSelected2(text)

                            // after clicking a radio button
                            // we are displaying a toast message.
                            // Toast.makeText(context, text, Toast.LENGTH_LONG).show()
                        }
                    )
                    // below line is use to add
                    // text to our radio buttons.
                    Text(
                        text = text,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }



        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if(question == 5)
                    navController.navigate("quizDetails/$points")
                else {

                    navController.navigate("question3")
                }

            },
            //enabled = points.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            if (question == 5)
                Text("Finish")
            else Text(text = "Next")

        }
    }

}

@Composable
fun Question02(navController: NavController){
    var marks by remember {
        mutableStateOf(0)
    }
    var points by remember { mutableStateOf("3") }
    var question by remember {
        mutableStateOf(4)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(
            text = "Which element has the chemical symbol 'O'?",
            modifier = Modifier.align(Alignment.Start)
        )



        // RadioButton(selected = , onClick = { /*TODO*/ })



        val radioOptions1 = listOf("India", "Brazil", "Australia", "Egypt")
        val (selectedOption1, onOptionSelected1) = remember { mutableStateOf(radioOptions1[2]) }



        // we are displaying all our
        // radio buttons in column.
        Column {
            // below line is use to set data to
            // each radio button in columns.
            radioOptions1.forEach { text ->
                Row(
                    Modifier
                        // using modifier to add max
                        // width to our radio button.
                        .fillMaxWidth()
                        // below method is use to add
                        // selectable to our radio button.
                        .selectable(
                            // this method is called when
                            // radio button is selected.
                            selected = (text == selectedOption1),
                            // below method is called on
                            // clicking of radio button.
                            onClick = { onOptionSelected1(text) }
                        )
                        // below line is use to add
                        // padding to radio button.
                        .padding(horizontal = 16.dp)
                ) {
                    // below line is use to get context.
                    //  val context = ContextAmbient.current

                    // below line is use to
                    // generate radio button
                    RadioButton(
                        // inside this method we are
                        // adding selected with a option.
                        selected = (text == selectedOption1), modifier = Modifier.padding(),
                        onClick = {
                            // inside on click method we are setting a
                            // selected option of our radio buttons.
                            onOptionSelected1(text)

                            // after clicking a radio button
                            // we are displaying a toast message.
                            // Toast.makeText(context, text, Toast.LENGTH_LONG).show()
                        }
                    )
                    // below line is use to add
                    // text to our radio buttons.
                    Text(
                        text = text,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }



        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if(question == 5)
                    navController.navigate("quizDetails/$points")
                else {

                    navController.navigate("question4")
                }

            },
            //enabled = points.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            if (question == 5)
                Text("Finish")
            else Text(text = "Next")

        }
    }

}

@Composable
fun Question03(navController: NavController){
    var marks by remember {
        mutableStateOf(0)
    }
    var points by remember { mutableStateOf("3") }
    var question by remember {
        mutableStateOf(5)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(
            text = "In which country is the Great Barrier Reef located?",
            modifier = Modifier.align(Alignment.Start)
        )
        val radioOptions = listOf("India", "Brazil", "Australia", "Egypt")
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }



            // we are displaying all our
            // radio buttons in column.
            Column {
                // below line is use to set data to
                // each radio button in columns.
                radioOptions.forEach { text ->
                    Row(
                        Modifier
                            // using modifier to add max
                            // width to our radio button.
                            .fillMaxWidth()
                            // below method is use to add
                            // selectable to our radio button.
                            .selectable(
                                // this method is called when
                                // radio button is selected.
                                selected = (text == selectedOption),
                                // below method is called on
                                // clicking of radio button.
                                onClick = { onOptionSelected(text) }
                            )
                            // below line is use to add
                            // padding to radio button.
                            .padding(horizontal = 16.dp)
                    ) {
                        // below line is use to get context.
                        //  val context = ContextAmbient.current

                        // below line is use to
                        // generate radio button
                        RadioButton(
                            // inside this method we are
                            // adding selected with a option.
                            selected = (text == selectedOption), modifier = Modifier.padding(),
                            onClick = {
                                // inside on click method we are setting a
                                // selected option of our radio buttons.
                                onOptionSelected(text)

                                // after clicking a radio button
                                // we are displaying a toast message.
                                // Toast.makeText(context, text, Toast.LENGTH_LONG).show()
                            }
                        )
                        // below line is use to add
                        // text to our radio buttons.
                        Text(
                            text = text,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }


        Text(text = "Correct Question : $points")

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if(question == 5)
                    navController.navigate("quizDetails/$points")
                else {

                    navController.navigate("question4")
                }

            },
            //enabled = points.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            if (question == 5)
                Text("Finish")
            else Text(text = "Next")

        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    LABEXAMTheme {
       // Greeting2("Android")
    }
}