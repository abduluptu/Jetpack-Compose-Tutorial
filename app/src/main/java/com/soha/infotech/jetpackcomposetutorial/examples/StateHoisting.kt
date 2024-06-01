package com.soha.infotech.jetpackcomposetutorial.examples

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

/**
 * State Hoisting Example
 */

/**
 * Example 1: Parent Composable function
 * (It will share state to child functions)
 */

// (Stateful Composable)
@Preview(showSystemUi = true)
@Composable
fun NotificationScreen() {
    val count = rememberSaveable { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        NotificationCounter(count.value) { count.value }
        MessageBar(count.value)
    }
}

// Child function 1 (Stateless Composable)
@Composable
fun NotificationCounter(count: Int, increment: () -> Unit) {
    // val count = rememberSaveable { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "You have sent ${count} notifications")
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            increment()
        }) {
            Text(text = "Send Notification")
        }
    }
}

// Child function 2 (Stateless Composable)
@Composable
fun MessageBar(count: Int) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "",
                modifier = Modifier.padding(8.dp)
            )
            Text(text = "Messages sent so far - $count")
        }
    }
}

/**
 * Example 2: Parent Composable function
 * (It will share state to child functions)
 */
/*@Composable
fun CounterApp() {
    var count by remember { mutableStateOf(0) }

    Column {
        // Child function 1
        Counter(count)

        // Child function 2
        IncrementButton(onClick = { count++ })
    }
}*/

// Using ViewModel
@Composable
fun CounterApp(viewModel: CounterViewModel) {
    Column {
        // Child function 1
        Counter(viewModel.count.value)
        
        // Child function 2
        IncrementButton(onClick = { viewModel::incrementCount })
    }

}

// Child function 1
@Composable
fun Counter(count: Int) {
    Text(text = "Count: $count")
}

// Child function 2
@Composable
fun IncrementButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Increment")
    }
}

// Example 3
/**
 * Using data class & ViewModel
 */

// Create a data class
data class CounterState(val count: Int)

// Create a ViewModel
class CounterViewModel : ViewModel() {
    private val _count = mutableStateOf(0)

    val count: State<Int>
        get() = _count

    fun incrementCount() {
        _count.value++
    }
}

