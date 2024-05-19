package com.example.jetpackcomposetutorial.presentation.splash.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel(){

   private val _isLoading = MutableStateFlow<Boolean>(true)
    val isLoading = _isLoading.asStateFlow()

    private val _isAuthenticated = MutableStateFlow<Boolean>(false)
    val isAuthenticated = _isAuthenticated.asStateFlow()

    init {
       checkAuthentication()
    }

    private fun checkAuthentication(){
        _isLoading.value = true

        viewModelScope.launch {
            _isAuthenticated.value = isAuthenticatedUser()
            delay(2000)
            _isLoading.value = false
        }
    }

    private  fun isAuthenticatedUser() : Boolean{

        val firebaseAuth = FirebaseAuth.getInstance()

        return firebaseAuth.currentUser != null

    }
}