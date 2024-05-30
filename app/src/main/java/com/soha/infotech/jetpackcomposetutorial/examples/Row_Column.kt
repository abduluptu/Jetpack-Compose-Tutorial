package com.soha.infotech.jetpackcomposetutorial.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**
 * https://www.jetpackcompose.net/compose-layout-row-and-column
 */

@Preview(showSystemUi = true)
@Composable
fun SimpleRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Row Text 1", modifier = Modifier.background(Color.Red))
        Text(text = "Row Text 2", modifier = Modifier.background(Color.Green))
        Text(text = "Row Text 3", modifier = Modifier.background(Color.Blue))
    }
}

/**
 * Column - It arranges the views vertically.
 */

@Preview(showSystemUi = true)
@Composable
fun SimpleColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        Text(text = "Column Text 1", modifier = Modifier.background(Color.Red))
        Text(text = "Column Text 2", modifier = Modifier.background(Color.Green))
        Text(text = "Column Text 3", modifier = Modifier.background(Color.Blue))
    }
}