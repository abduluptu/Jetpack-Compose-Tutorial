package com.soha.infotech.jetpackcomposetutorial.examples.effect_handlers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

//Exp:1 - produceState
@Composable
fun Counters() {
    // Define a state object
    /*val state = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = Unit) {
        for (i in 1..10) {
            delay(1000)
            // update state object (Asynchronously)
            state.value++
        }
    }*/

    // Combine LaunchedEffect & state (Create state & update state)
    val state = produceState(initialValue = 0) {
        for (i in 1..10) {
            delay(1000)
            value += 1
        }
    }

    Text(
        text = state.value.toString(),
        style = MaterialTheme.typography.bodyLarge
    )
}

//Exp:2 - produceState
@Preview(showSystemUi = true)
@Composable
fun Loader() {
    // State (produceState-> create state & update state)
    val degree = produceState(initialValue = 0) {
        while (true) { // Loop will be run infinite times
            delay(100)
            value = (value + 10) % 360 // when value-> 360, It will be 0 and starts again.
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f),
        content = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Image(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "",
                    modifier = Modifier
                        .size(60.dp)
                        .rotate(degree.value.toFloat()) //rotate image on the basis of state
                )
                Text(text = "Loading...")
            }
        }
    )
}

// Derived State Example
@Preview(showSystemUi = true)
@Composable
fun Derived() {
    // state1
    val tableOf = remember { mutableStateOf(5) }
    // state2
    // val index = remember { mutableStateOf(1) }
    val index = produceState(initialValue = 1) {
        repeat(9) {
            delay(1000)
            value += 1
        }
    }

    // state3
    // Get new state from other states (Combine all states together)
    val message = remember {
        derivedStateOf {
            "${tableOf.value} * ${index.value} = ${tableOf.value * index.value}"
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f),

        ) {
        Text(
            text = message.value,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
