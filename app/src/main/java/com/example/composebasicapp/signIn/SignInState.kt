package com.example.composebasicapp.signIn

data class SignInState(
    val email: String = "",
    val password: String = "",
    val passwordVisibility: Boolean = false,
    val rememberMeCheck: Boolean = true,
)
