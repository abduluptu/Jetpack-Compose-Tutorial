package com.soha.infotech.jetpackcomposetutorial.examples.effect_handlers

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

/**
 * https://proandroiddev.com/mastering-side-effects-in-jetpack-compose-b7ee46162c01
 *
 * https://www.youtube.com/watch?v=VtMoZE_-HR0&list=PLRKyZvuMYSIO9sadcCwR0DR8UPi9bQlev&index=16&t=2s
 */


// Example 1
@Preview(showSystemUi = true)
@Composable
fun RememberUpdatedStateExample() {
    val count = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = Unit) {
        delay(2000) // 2 seconds
        count.value = 10
    }
    // Counter() already called before update the value of count as 10
    Counter(count.value)

}

@Composable
fun Counter(value: Int) {
    // This is used for remember updated state
    val state = rememberUpdatedState(newValue = value)

    LaunchedEffect(key1 = Unit) {
        // Execute Long running task
        delay(5000) // 5 seconds
        // Use counter value here
        //Log.d("SOHA", value.toString())
        Log.d("SOHA", state.value.toString())

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value.toString(),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

// Example 2
fun a() {
    Log.d("ABDUL", "I am A from App")
}

fun b() {
    Log.d("ABDUL", "I am B from App")
}

@Preview(showSystemUi = true)
@Composable
fun AppRememberUpdateState() {
    val state = remember { mutableStateOf(::a) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        Button(onClick = { state.value = ::b }) {
            Text(text = "Click to change state")
        }
    }

    LandingScreen(state.value)
}

//Splash Screen
@Composable
fun LandingScreen(onTimeout: () -> Unit) {
    val currentOnTimeout by rememberUpdatedState(onTimeout)

    LaunchedEffect(key1 = true) {
        delay(5000)
        currentOnTimeout()
    }
}


// Example 3
@Composable
fun RememberUpdatedStateDemo(title: String) {
    var data by remember { mutableStateOf("") }

    val updatedData by rememberUpdatedState(newValue = title)

    LaunchedEffect(key1 = Unit) {
        delay(5000)
        data = updatedData
    }

    Text(text = data)
}

// Example 4
@Composable
fun ToggleButton() {
    var isChecked by remember { mutableStateOf(false) }
    val updatedIsChecked by rememberUpdatedState(isChecked)

    Button(
        onClick = { isChecked = !isChecked }
    ) {
        Text(if (updatedIsChecked) "ON" else "OFF")
    }
}