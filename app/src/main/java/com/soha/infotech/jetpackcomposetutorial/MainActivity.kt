package com.soha.infotech.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.soha.infotech.jetpackcomposetutorial.examples.NotificationScreen
import com.soha.infotech.jetpackcomposetutorial.examples.effect_handlers.Counter
import com.soha.infotech.jetpackcomposetutorial.examples.effect_handlers.LaunchEffectComposableDemo
import com.soha.infotech.jetpackcomposetutorial.examples.effect_handlers.MediaDisComposable
import com.soha.infotech.jetpackcomposetutorial.examples.effect_handlers.RememberUpdatedStateDemo
import com.soha.infotech.jetpackcomposetutorial.examples.effect_handlers.RememberUpdatedStateExample
import com.soha.infotech.jetpackcomposetutorial.examples.effect_handlers.SideEffect
import com.soha.infotech.jetpackcomposetutorial.examples.tutorialkart.ItemList
import com.soha.infotech.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // SideEffect()

                    /*var dynamicData by remember { mutableStateOf("") }
                    LaunchedEffect(Unit) {
                        delay(3000L)
                        dynamicData = "New Text"
                    }
                    RememberUpdatedStateDemo(title = dynamicData)*/

                    // ItemList(100)

                    //Counter()

                    // LaunchEffectComposableDemo()

                    // RememberUpdatedStateExample()

                    // MediaDisComposable()

                    NotificationScreen()
                }
            }
        }
    }
}


