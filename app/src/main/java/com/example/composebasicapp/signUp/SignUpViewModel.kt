package com.example.composebasicapp.signUp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel: ViewModel() {

    private val _uiState: MutableStateFlow<SignUpState> = MutableStateFlow(SignUpState());
    val uiState: StateFlow<SignUpState> = _uiState.asStateFlow()



    private fun updateFullName(value: String) {
        _uiState.update {
            it.copy(
                fullName = value
            )
        }
    }

    private fun updateEmail(value: String) {
        _uiState.update {
            it.copy(
                email = value
            )
        }
    }

    private fun updatePassword(value: String) {
        _uiState.update {
            it.copy(
                password = value
            )
        }
    }

    private fun updateConfirmPassword(value: String) {
        _uiState.update {
            it.copy(
                confirmPassword = value
            )
        }
    }

    private fun updatePasswordVisibility(value: Boolean) {
        _uiState.update {
            it.copy(
                passwordVisibility = value
            )
        }
    }

    fun onEvent(event: SignUpEvent) {
        when(event) {
            is SignUpEvent.UpdateFullName -> updateFullName(event.value)
            is SignUpEvent.UpdateEmail -> updateEmail(event.value)
            is SignUpEvent.UpdatePassword -> updatePassword(event.value)
            is SignUpEvent.UpdateConfirmPassword -> updateConfirmPassword(event.value)
            is SignUpEvent.UpdatePasswordVisibility -> updatePasswordVisibility(event.value)
        }
    }







}