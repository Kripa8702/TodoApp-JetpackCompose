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
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposetutorial.navigation.AppNavigation
import com.example.jetpackcomposetutorial.presentation.authentication.viewmodel.AuthenticationViewModel
import com.example.jetpackcomposetutorial.ui.composables.BaseScreen
import com.example.jetpackcomposetutorial.ui.composables.CommonTextField

@Composable
fun LoginScreen(
    viewModel: AuthenticationViewModel = hiltViewModel(),
    navController: NavController
) {
    val emailText = remember { mutableStateOf(TextFieldValue()) }
    val passwordText = remember { mutableStateOf(TextFieldValue()) }


    BaseScreen(
        navController = navController,
        content = {
            Column(
            ) {
                Box(
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(start = 10.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = "Welcome Back",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                Column(
                    modifier = Modifier.weight(0.7f)
                ) {
                    CommonTextField(
                        textFieldValue = emailText,
                        onValueChange = { newText -> emailText.value = newText },
                        hintText = "Email",
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next, keyboardType = KeyboardType.Email
                        ),
                        leadingIcon = Icons.Rounded.MailOutline
                    )
                    Spacer(modifier = Modifier.height(40.dp))

                    CommonTextField(
                        isPassword = true,
                        textFieldValue = passwordText,
                        onValueChange = { newText -> passwordText.value = newText },
                        hintText = "Password",
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done, keyboardType = KeyboardType.Password
                        ),
                        leadingIcon = Icons.Outlined.Lock
                    )
                }

            }
        },

        bottomContent = {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                GradientButton(text = "Login", onClick = {
                    viewModel.signIn(emailText.value.text, passwordText.value.text)

                    if(viewModel.authenticated.value == true){
                        navController.navigate(AppNavigation.TodoListScreen.route) {
                            popUpTo("authentication") { inclusive = true }
                        }
                    }
                })
                Row(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 50.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Don't have an account? ",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        modifier = Modifier
                            .clickable {
                                navController.navigate(AppNavigation.RegisterScreen.route)
                            },
                        text = "Sign Up",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        })

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        navController = rememberNavController()
    )
}