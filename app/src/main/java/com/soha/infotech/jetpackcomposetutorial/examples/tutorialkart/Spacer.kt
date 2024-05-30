package com.soha.infotech.jetpackcomposetutorial.examples.tutorialkart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Spacer component is used to display an empty space.
 * Width and (or) height can be set for Spacer using Modifier object.
 */

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SpacerDemo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(5.dp)
    ) {
        Row(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .background(Color.Gray)
        ) {

        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .background(Color.Gray)
        ) {

        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .background(Color.Gray)
        ) {

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SpacerBoxDemo(modifier: Modifier = Modifier) {
    Row(Modifier.padding(10.dp)) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(Color.Gray)
        ) {}

        Spacer(modifier = Modifier.width(20.dp))

        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(Color.DarkGray)
        ) {}
    }
}