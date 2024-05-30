package com.soha.infotech.jetpackcomposetutorial.examples.tutorialkart

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Android Jetpack Column composable is used to place items vertically on the screen.
 */

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ColumnDemo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .border(1.dp, Color.Red, RectangleShape)
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Column {
            Text("AB CDE", fontSize = 25.sp)
            Text("+91- 9719600165")
            Text("Lives in XYZ city.", color = Color.Gray)
        }
    }
}

// Enable Vertical Scroll for Column
@Composable
fun ItemList(count: Int) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxWidth()) {
        repeat(count){
            Text(text = "Item $it", modifier = Modifier.padding(10.dp))
        }
    }
}