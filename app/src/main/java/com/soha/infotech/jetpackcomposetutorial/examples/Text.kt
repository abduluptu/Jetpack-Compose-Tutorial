package com.soha.infotech.jetpackcomposetutorial.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * https://www.jetpackcompose.net/text-in-compose
 *
 * https://medium.com/@expertappdevs/text-in-jetpack-compose-android-311cd429bd1e
 */

@Composable
fun TextWithSize(label: String, size: TextUnit) {
    Text(text = label, fontSize = size)
    Spacer(modifier = Modifier.height(10.dp))
}


@Composable
fun ColorText() {
    Text(text = "Color Tex", color = Color.Blue)
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun BoldText() {
    Text(text = "Bold Text", fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun ItalicText() {
    Text(text = "Italic Text", fontStyle = FontStyle.Italic)
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun MaxLines() {
    Text(text = "Hello".repeat(50), maxLines = 2)
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun OverflowedText() {
    Text(text = "Hello Compose".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun SelectableText() {
    SelectionContainer {
        Text(text = "This text is selectable")
    }
}

@Preview(showSystemUi = true)
@Composable
fun TextContainer() {
    Column {
        TextWithSize("Big Text", 40.sp)
        ColorText()
        BoldText()
        ItalicText()
        MaxLines()
        OverflowedText()
        SelectableText()
    }
}