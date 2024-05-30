package com.soha.infotech.jetpackcomposetutorial.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

/**
 * https://www.jetpackcompose.net/textstyle-in-jetpack-compose
 */

// Study
// https://blog.kotlin-academy.com/jetpack-compose-android-beginners-series-4cebb66a69eb

@Composable
fun TextWithTextStyle() {
    Text(
        text = "Hello",

       /* style = TextStyle(
            color = Color.Blue,
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            letterSpacing = 0.5.em,
            background = Color.Yellow,
            textDecoration = TextDecoration.LineThrough,
            // Shadow
            shadow = Shadow(
                color = Color.Black,
                offset = Offset(5f, 5f),
                blurRadius = 5f
            )
        )*/
        style = MaterialTheme.typography.displayLarge

    )
}


@Preview(showSystemUi = true)
@Composable
fun TextStyleContainer() {
    Column {
        TextWithTextStyle()
    }
}