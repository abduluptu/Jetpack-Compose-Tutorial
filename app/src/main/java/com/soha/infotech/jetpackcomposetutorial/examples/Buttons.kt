package com.soha.infotech.jetpackcomposetutorial.examples

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * https://www.jetpackcompose.net/buttons-in-jetpack-compose
 *
 * https://medium.com/smartherd/jetpack-compose-button-outlined-button-and-text-button-4f8e1e41bcf
 */

// Simple Button
@Composable
fun SimpleButton() {
    Button(onClick = {
        // your onclick code

    }) {
        Text(text = "Simple Button")
    }
}

//var buttonColour = mutableStateOf(Color.Red)

// Button with custom color
@Composable
fun ButtonWithColor() {
    Button(
        onClick = {
            // your onclick code

        }, colors = ButtonDefaults.buttonColors(
            // Text Color
            contentColor = Color.White,
            // Background Color
            containerColor = Color.Gray

        )
    ) {
        Text(text = "Button with Gray background")
    }
}

// Button with multiple text
@Composable
fun ButtonWithTwoTextView() {
    Button(onClick = {
        // your onclick code

    }) {
        Text(text = "Click", color = Color.Magenta)
        Text(text = "Here", color = Color.Green)
    }
}

// Button with Icon
@Composable
fun ButtonWithIcon() {
    Button(onClick = {
        // your onclick code

    }) {
        /* Image(
             painter = painterResource(id = R.drawable.shopping_cart),
             contentDescription = "Cart button icon",
             modifier = Modifier.size(20.dp)
         )*/

        // Text(text = "Add to cart", modifier = Modifier.padding(start = 10.dp))

        // Icon and Spacer composable added

        Icon(
            imageVector = Icons.Filled.ShoppingCart, contentDescription = "Cart button icon",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Like")


    }
}

/**
 * Button with shapes
 */

// Rectangle Shape
@Composable
fun ButtonWithRectangleShape() {
    Button(onClick = { /*TODO*/ }, shape = RectangleShape) {
        Text(text = "Rectangle shape")
    }
}

// Round Corner Shape:
@Composable
fun ButtonWithRoundCornerShape() {
    Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(20.dp)) {
        Text(text = "Round corner shape")
    }
}

// Cut Corner Shape
@Composable
fun ButtonWithCutCornerShape() {
    Button(onClick = { /*TODO*/ }, shape = CutCornerShape(10)) {
        Text(text = "Cut corner shape")
    }
}

// Button with Border
@Composable
fun ButtonWithBorder() {
    Button(
        onClick = { /*TODO*/ },
        border = BorderStroke(1.dp, Color.Red),

        ) {
        Text(text = "Button with border", color = Color.White)
    }
}

// Button elevation
@Composable
fun ButtonWithElevation() {
    Button(
        onClick = { /*TODO*/ },
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text = "Button with elevation")
    }
}

// OutlinedButton
@Composable
fun OutlinedButton() {
    androidx.compose.material3.OutlinedButton(
        onClick = { /*TODO*/ },
        border = BorderStroke(1.dp, Color.Green)
    ) {
        Text(text = "Outlined button")
    }
}

// TextButton
@Composable
fun TextButton() {
    androidx.compose.material3.TextButton(onClick = { /*TODO*/ }) {
        Text(text = "Text button")
    }
}

@Preview(showSystemUi = true)
@Composable
fun ButtonContainer() {
    Column {
        SimpleButton()
        ButtonWithColor()
        ButtonWithTwoTextView()
        ButtonWithIcon()
        ButtonWithRectangleShape()
        ButtonWithRoundCornerShape()
        ButtonWithCutCornerShape()
        ButtonWithBorder()
        ButtonWithElevation()
        OutlinedButton()
        TextButton()
    }
}