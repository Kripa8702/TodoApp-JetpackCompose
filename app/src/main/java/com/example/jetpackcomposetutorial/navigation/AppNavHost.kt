package com.example.jetpackcomposetutorial.navigation

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.jetpackcomposetutorial.presentation.authentication.login.view.LoginScreen
import com.example.jetpackcomposetutorial.presentation.authentication.login.view.RegisterScreen
import com.example.jetpackcomposetutorial.presentation.authentication.viewmodel.AuthenticationViewModel
import com.example.jetpackcomposetutorial.presentation.todo.view.TodoListScreen
import com.example.jetpackcomposetutorial.presentation.todo.viewmodel.TodoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        Log.d("AUTH", "AppNavHost: startDestination: $startDestination")
        // Authentication
        navigation(
            route = "authentication",
            startDestination = AppNavigation.LoginScreen.route
        ) {
            composable(
                AppNavigation.LoginScreen.route,
                enterTransition = { enterTransition() },
                exitTransition = { exitTransition() }
                ) {

                val viewModel =
                    it.sharedViewModel<AuthenticationViewModel>(navController = navController)
                LoginScreen(
                    viewModel = viewModel,
                    navController = navController
                )
            }
            composable(
                AppNavigation.RegisterScreen.route,
                enterTransition = { enterTransition() },
                exitTransition = { exitTransition() }
            ) {
                val viewModel =
                    it.sharedViewModel<AuthenticationViewModel>(navController = navController)
                RegisterScreen(
                    viewModel = viewModel,
                    navController = navController
                )
            }
        }

        composable(AppNavigation.TodoListScreen.route) {
            val viewModel = it.sharedViewModel<TodoViewModel>(navController = navController)
            TodoListScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
    }

}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel(parentEntry)
}