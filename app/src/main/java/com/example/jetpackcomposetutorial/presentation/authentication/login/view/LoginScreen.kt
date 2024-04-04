package com.example.jetpackcomposetutorial.presentation.authentication.login.view

import GradientButton
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.ui.composables.BaseScreen
import com.example.jetpackcomposetutorial.ui.composables.CommonTextField

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
) {
    val emailText = remember { mutableStateOf(TextFieldValue()) }
    val passwordText = remember { mutableStateOf(TextFieldValue()) }

    BaseScreen(
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 40.dp),
                    text = "Sign In",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = Modifier.height(120.dp))
                CommonTextField(
                    textFieldValue = emailText,
                    onValueChange = { newText -> emailText.value = newText },
                    hintText = "Email",
                    imeAction = ImeAction.Next,
                    leadingIcon = Icons.Rounded.MailOutline
                )
                Spacer(modifier = Modifier.height(40.dp))

                CommonTextField(
                    textFieldValue = passwordText,
                    onValueChange = { newText -> passwordText.value = newText },
                    hintText = "Password",
                    imeAction = ImeAction.Done,
                    leadingIcon = Icons.Outlined.Lock
                )
                Spacer(modifier = Modifier.height(60.dp))
                Box(
                    modifier = Modifier.padding(20.dp),
                ) {
                    GradientButton(text = "Continue")
                }
                Text(
                    text = "Don't have an account? Sign Up",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

            }
        },
    )

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}