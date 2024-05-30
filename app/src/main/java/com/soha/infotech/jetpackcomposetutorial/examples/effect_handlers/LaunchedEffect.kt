package com.soha.infotech.jetpackcomposetutorial.examples.effect_handlers

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

/**
 * https://proandroiddev.com/mastering-side-effects-in-jetpack-compose-b7ee46162c01
 */

// Launched Effect
private var counter = 0

@Composable
fun SideEffect() {
    var text by remember { mutableStateOf("") }

    LaunchedEffect(key1 = text) {//A compose state key
        counter++
        Log.d("ABDUL", "SideEffect: $counter")
    }

    Column {
        Button(onClick = { text += "@" }) {
            Text(text = text) //Everytime text changes
        }
    }
}


@Composable
fun LaunchEffectComposable() {
    val counter by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = Unit) {
        Log.d("LaunchEffectComposable", "Started... ")


    }
}