package com.soha.infotech.jetpackcomposetutorial.examples.effect_handlers

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 *https://proandroiddev.com/mastering-side-effects-in-jetpack-compose-b7ee46162c01
 */


// Side Effects
class Ref(var value: Int)

// First Example
@Composable
fun SideEffectDemo() {
    val ref = remember { Ref(0) }

    androidx.compose.runtime.SideEffect {
        ref.value++
    }

    Text(text = "Compositions: ${ref.value}")
}

// Second Example
@Preview(showSystemUi = true)
@Composable
fun ListComposable() {
    // Remembering the state
    val categoryState = remember { mutableStateOf(emptyList<String>()) }
    /**
     * set categories in the state
     * Note: SideEffect: Not applicable because every times network call
     * when recomposition performed, May be time consuming
     */
    //  categoryState.value = fetchCategories()


    /**
     * Remove Side Effects
     * Code will be execute on the basis of key1
     * Code will be execute 1 time only
     * LaunchedEffect: Side Effects Handler (It launches CoroutineScope)
     */
    LaunchedEffect(key1 = Unit) {
        categoryState.value = fetchCategories()
    }

    LazyColumn {
        items(categoryState.value) { item ->
            Text(text = item)
        }
    }

}

// Side Effects
fun fetchCategories(): List<String> {
    // Assuming network call
    return listOf("One", "Two", "Three")
}

// Third Example
@Preview(showSystemUi = true)
@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }
    // Log.d("Counter", "Current count: ${count.value}")

    val key = count.value % 3 == 0
    LaunchedEffect(key1 = key) {
        Log.d("Counter", "Current count: ${count.value}")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { count.value++ }) {
            Text(text = "Increment count")
        }
    }

}