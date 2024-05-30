package com.soha.infotech.jetpackcomposetutorial.examples.effect_handlers

import android.media.MediaPlayer
import android.util.Log
import android.view.ViewTreeObserver
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.soha.infotech.jetpackcomposetutorial.R

/**
 * https://proandroiddev.com/mastering-side-effects-in-jetpack-compose-b7ee46162c01
 *
 * https://www.youtube.com/watch?v=H8e9p3ilqEo&list=PLRKyZvuMYSIO9sadcCwR0DR8UPi9bQlev&index=17&t=2s
 */

// Example 1
//1 Example
@Preview(showSystemUi = true)
@Composable
fun DisposableEffect() {

    val state = remember { mutableStateOf(false) }

    DisposableEffect(key1 = state.value) {
        Log.d("ABDUL", "Disposable Effect Started")
        onDispose {
            // write cleanup  code
            Log.d("ABDUL", "Cleaning up side effects")
        }
    }

    Button(onClick = { state.value = !state.value }) {
        Text(text = "Change State")
    }
}

//2 Example
@Composable
fun MediaDisComposable() {
    val context = LocalContext.current

    DisposableEffect(Unit) {
        val mediaPlayer = MediaPlayer.create(context, R.raw.ishk_jaisa)
        mediaPlayer.start()

        onDispose {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }
}

//3 Example
@Composable
fun KeyboardComposable() {
    val view = LocalView.current
    // To check Keyboard is visible or not
    DisposableEffect(key1 = Unit) {
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            //get rectangle inside the view
            val insets = ViewCompat.getRootWindowInsets(view)
            val isKeyboardVisible = insets?.isVisible(WindowInsetsCompat.Type.ime())
            Log.d("ABDUL", isKeyboardVisible.toString())
        }
        view.viewTreeObserver.addOnGlobalLayoutListener(listener)

        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }
    }
}

// Example 4
@Composable
fun DisposableEffectDemo() {
    var isAnimating by remember { mutableStateOf(true) }

    DisposableEffect(key1 = Unit) {
        // Code to execute during setup
        val animation = if (isAnimating) {
            // Start animation
            // startAnimation()
        } else {
            null
        }

        onDispose {
            // Code to execute during cleanup
            // animation?.cancel() // Stop animation on cleanup

        }
    }
}