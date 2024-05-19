package com.example.jetpackcomposetutorial.presentation.authentication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor() : ViewModel() {
    private val firebaseAuth = FirebaseAuth.getInstance()

    private val _authenticated = MutableStateFlow<Boolean?>(false)
    val authenticated : StateFlow<Boolean?>
        get() = _authenticated

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage : StateFlow<String?>
        get() = _errorMessage

//    init {
//        firebaseAuth.addAuthStateListener {
//            _authenticated.value = firebaseAuth.currentUser != null
//        }
//
//        Log.d("AUTH", "Authentication Done ${firebaseAuth.currentUser}")
//    }

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            try {
                firebaseAuth.signInWithEmailAndPassword(email, password)
                _authenticated.value = true

            } catch (e : Exception) {
                _authenticated.value = false
                _errorMessage.value = e.message
            }
        }
    }

    fun signOut() {
        firebaseAuth.signOut()
    }
}