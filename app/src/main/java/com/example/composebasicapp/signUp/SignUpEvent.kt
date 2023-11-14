package com.example.composebasicapp.signUp

sealed class SignUpEvent {

    data class UpdateFullName(val value: String): SignUpEvent()
    data class UpdateEmail(val value: String): SignUpEvent()
    data class UpdatePassword(val value: String): SignUpEvent()
    data class UpdateConfirmPassword(val value: String): SignUpEvent()
    data class UpdatePasswordVisibility(val value: Boolean): SignUpEvent()

}
