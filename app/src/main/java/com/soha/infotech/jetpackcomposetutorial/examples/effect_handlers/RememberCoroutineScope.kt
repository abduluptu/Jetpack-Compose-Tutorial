package com.soha.infotech.jetpackcomposetutorial.examples.effect_handlers

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * https://proandroiddev.com/mastering-side-effects-in-jetpack-compose-b7ee46162c01
 *
 * https://www.youtube.com/watch?v=tBLwqpqYQlU&list=PLRKyZvuMYSIO9sadcCwR0DR8UPi9bQlev&index=15&t=2s
 */

// Example 1
@Preview(showSystemUi = true)
@Composable
fun LaunchEffectComposableDemo() {
    /* val counter = remember { mutableStateOf(0) }

     LaunchedEffect(key1 = Unit) {
         Log.d("LaunchEffectComposable", "Started...")

         try {
             for (i in 1..10) {
                 counter.value++
                 delay(1000) // 1 second
             }
         } catch (e: Exception) {
             Log.d("LaunchEffectComposable", "Exception:  ${e.message.toString()}")
         }
     }

     var text = "Counter is running: ${counter.value}"
     if (counter.value == 10) {
         text = "Counter stopped"
     }
     Column(
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally,
         modifier = Modifier.fillMaxSize(1f)
     ) {
         Text(
             text = text,
             fontWeight = FontWeight.Bold,
             fontSize = 24.sp
         )
     }*/

    val counter = remember { mutableStateOf(0) }
    // create a remember Coroutine Scope
    val scope = rememberCoroutineScope()

    var text = "Counter is running: ${counter.value}"
    if (counter.value == 10) {
        text = "Counter stopped"
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text)
        Spacer(modifier = Modifier.height(10.dp))
        Button(modifier = Modifier.fillMaxWidth(0.5f),
            onClick = {
                // Launch coroutines scope on button click (on an event)
                scope.launch {

                    Log.d("LaunchEffectComposable", "Started...")
                    try {
                        for (i in 1..10) {
                            counter.value++
                            delay(1000) //1 second
                        }

                    } catch (e: Exception) {
                        Log.d("LaunchEffectComposable", "Exception:  ${e.message.toString()}")
                    }
                }
            }) {
            Text(text = "Start")
        }
    }
}

@Composable
fun RememberCoroutineScopeDemo() {
    val coroutineScope = rememberCoroutineScope()
    // val data by remember { mutableStateOf("") }
    val data = remember { mutableStateOf("") }

    Button(onClick = {
        coroutineScope.launch {
            // Simulate network call
            delay(2000)
            data.value = "Data Loaded"
        }
    }) {
        Text(text = "Load Data")
    }

    Text(text = data.value)
}
