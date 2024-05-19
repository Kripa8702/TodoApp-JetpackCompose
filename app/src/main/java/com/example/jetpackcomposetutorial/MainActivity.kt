package com.example.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposetutorial.navigation.AppNavHost
import com.example.jetpackcomposetutorial.navigation.AppNavigation
import com.example.jetpackcomposetutorial.presentation.splash.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val splashViewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()


        setContent {
            val isLoading by splashViewModel.isLoading.collectAsState(initial = true)
            val isAuthenticated by splashViewModel.isAuthenticated.collectAsState(initial = false)
            installSplashScreen().setKeepOnScreenCondition { isLoading }

            Log.d("AUTH", "onCreate: isAuthenticated: $isAuthenticated")

            AppNavHost(
                modifier = Modifier,
                navController = rememberNavController(),
                startDestination = if (isAuthenticated)
                    AppNavigation.TodoListScreen.route else "authentication"
            )
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
}