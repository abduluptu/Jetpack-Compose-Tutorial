package com.soha.infotech.jetpackcomposetutorial.examples.tutorialkart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 *This layout composable is used to display other composables in a row, horizontally.
 */

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RowDemo(modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Text(text = "AB CDE", fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))
        Text(text = "+91- 9719600615", modifier = Modifier.padding(10.dp))
        Text(text = "XYZ City", color = Color.Gray, modifier = Modifier.padding(10.dp))
    }
}