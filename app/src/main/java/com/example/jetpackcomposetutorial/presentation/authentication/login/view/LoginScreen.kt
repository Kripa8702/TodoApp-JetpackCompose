package com.example.jetpackcomposetutorial.presentation.authentication.login.view

import GradientButton
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.ui.composables.BaseScreen

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
) {
    val emailText = rememberSaveable { mutableStateOf("") }
    val passwordText = rememberSaveable { mutableStateOf("") }

    BaseScreen (
        content = {
            Text(
                modifier = modifier
                    .padding(horizontal = 28.dp),
                text = "Welcome Back!",
                style = MaterialTheme.typography.headlineLarge
            )
           TextField(
               modifier = Modifier
                   .fillMaxWidth(),
               value = emailText.value,
               onValueChange = { newText -> emailText.value = newText},
               shape = RoundedCornerShape(50.dp),
               colors = TextFieldDefaults.colors(
                   focusedIndicatorColor = Color.Transparent,
                   unfocusedIndicatorColor = Color.Transparent,
                   focusedTextColor = MaterialTheme.colorScheme.onSurface,
                   cursorColor = MaterialTheme.colorScheme.onSurface,
               ),
               )
        },
        bottomContent = {
            Box(
                modifier = Modifier
                    .padding(30.dp)
            ) {
                GradientButton(text = "Continue")
            }
        }
    )

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}