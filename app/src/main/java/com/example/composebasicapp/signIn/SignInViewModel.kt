package com.example.composebasicapp.signIn

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel: ViewModel() {

    private val TAG = "SignInViewModel"
    private val _uiState: MutableStateFlow<SignInState> = MutableStateFlow(SignInState())
    val uiState = _uiState.asStateFlow()

    fun updateEmail(value: String) {
        _uiState.update {
            it.copy(
                email = value
            )
        }
    }

    fun updatePassword(value: String) {
        _uiState.update {
            it.copy(
                password = value
            )
        }
    }

    fun updatePasswordVisibility(value: Boolean) {
        _uiState.update {
            it.copy(
                passwordVisibility = value
            )
        }
    }

    fun updateRememberMeCheck(value: Boolean) {
        _uiState.update {
            it.copy(
                rememberMeCheck = value
            )
        }
    }

    fun signInOnClick() {
        Log.d(TAG, "signInOnClick: ")
    }

    fun loginWithGoogleOnClick() {
        Log.d(TAG, "loginWithGoogleOnClick: ")
    }

    fun loginWithFacebookOnClick() {
        Log.d(TAG, "loginWithFacebookOnClick: ")
    }

    fun signUpOnClick() {
        Log.d(TAG, "signUpOnClick: ")
    }











}