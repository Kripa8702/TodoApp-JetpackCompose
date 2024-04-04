@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposetutorial.presentation.authentication.login.view.LoginScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           LoginScreen()
        }
    }
}

@Composable
fun Greeting() {
    Text(text = "Hello", color = MaterialTheme.colorScheme.onBackground)
}


@Preview(showBackground = true, name = "Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    MainActivity()
}