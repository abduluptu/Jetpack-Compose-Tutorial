package com.soha.infotech.jetpackcomposetutorial.examples.tutorialkart

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * This composable is used to display buttons, and perform an action when user clicks them.
 */

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonDemo(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp)
    ) {
        Button(onClick = {
            Toast.makeText(
                context,
                "You clicked the Button.",
                Toast.LENGTH_LONG
            ).show()
        }) {
            Text(text = "Submit Request")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { }, modifier = Modifier.height(60.dp)) {
            Text("Submit Request")
        }

    }
}