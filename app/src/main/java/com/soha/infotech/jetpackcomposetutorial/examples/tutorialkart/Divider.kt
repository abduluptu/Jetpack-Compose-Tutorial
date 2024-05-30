package com.soha.infotech.jetpackcomposetutorial.examples.tutorialkart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Android Jetpack Divider composable is used
 * to display a thin line between items in lists and layouts.
 */

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DividerDemo(modifier: Modifier = Modifier) {
    Column {
        Text(text = "Item 1", fontSize = 16.sp, modifier = Modifier.padding(20.dp))
        Divider(
            color = Color.Red,
            thickness = 1.dp,
        )
        Text(text = "Item 2", fontSize = 16.sp, modifier = Modifier.padding(20.dp))
    }
}