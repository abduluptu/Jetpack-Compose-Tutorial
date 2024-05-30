package com.soha.infotech.jetpackcomposetutorial.examples.tutorialkart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * This composable is used to take text input from user.
 */

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextFieldDemo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        /*var text by remember { mutableStateOf("") }
        TextField(value = text, onValueChange = {
            text = it
        }, label = { Text(text = "Label") })*/

        /* var text by remember { mutableStateOf("Hello") }
         OutlinedTextField(value = text, onValueChange = {
             text = it
         }, label = { Text(text = "Label") })*/

        // Set Label for TextField
        /*var userName by remember { mutableStateOf("") }
        TextField(value = userName, onValueChange = {
            userName = it
        }, label = { Text(text = "Enter text") })*/

        // Read Value from TextField
        var userName by remember { mutableStateOf("") }
        TextField(value = userName, onValueChange = {
            userName = it
        }, label = { Text(text = "Label") })
        Text(text = userName)
    }
}