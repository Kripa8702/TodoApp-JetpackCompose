package com.example.jetpackcomposetutorial.presentation.authentication.login.view

import GradientButton
import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.ui.composables.BaseScreen
import com.example.jetpackcomposetutorial.ui.composables.CommonTextField

@Composable
fun RegisterScreen() {
    val fullNameText = remember { mutableStateOf(TextFieldValue()) }
    val emailText = remember { mutableStateOf(TextFieldValue()) }
    val passwordText = remember { mutableStateOf(TextFieldValue()) }
    val confirmPasswordText = remember { mutableStateOf(TextFieldValue()) }

    BaseScreen(
        content = {
            Column {
                Box(
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(start = 10.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = "Get Started",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .verticalScroll( // Add vertical scroll
                            enabled = true,
                            state = rememberScrollState()
                        )
                ) {
                    CommonTextField(
                        textFieldValue = fullNameText,
                        onValueChange = { newText -> fullNameText.value = newText },
                        hintText = "Full Name",
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            capitalization = KeyboardCapitalization.Words
                        ),
                        leadingIcon = Icons.Rounded.Person
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    CommonTextField(
                        textFieldValue = emailText,
                        onValueChange = { newText -> emailText.value = newText },
                        hintText = "Email",
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Email
                        ),
                        leadingIcon = Icons.Rounded.MailOutline
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    CommonTextField(
                        isPassword = true,
                        textFieldValue = passwordText,
                        onValueChange = { newText -> passwordText.value = newText },
                        hintText = "Password",
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Password
                        ),
                        leadingIcon = Icons.Outlined.Lock
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    CommonTextField(
                        isPassword = true,
                        textFieldValue = confirmPasswordText,
                        onValueChange = { newText -> confirmPasswordText.value = newText },
                        hintText = "Confirm Password",
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Password
                        ),
                        leadingIcon = Icons.Outlined.Lock
                    )
                }


            }
        },
        bottomContent = {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {
                GradientButton(
                    text = "Continue",
                )
                Row(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 50.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Already have an account? ",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        modifier = Modifier
                            .clickable {

                            },
                        text = "Sign In",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        }
    )

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}