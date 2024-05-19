package com.example.jetpackcomposetutorial.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut

sealed class AppNavigation (val route : String) {
    object SplashScreen : AppNavigation("splash")

    // Authentication
    object LoginScreen : AppNavigation("login")
    object RegisterScreen : AppNavigation("register")

    //To do List
    object TodoListScreen : AppNavigation("todo_list")
    object Unknown : AppNavigation("unknown")
}

fun enterTransition(): EnterTransition {
    return fadeIn(animationSpec = tween(500))
}

fun exitTransition(): ExitTransition {
    return fadeOut(animationSpec = tween(500))
}