package com.example.composebasicapp.models

import androidx.annotation.DrawableRes

data class OnboardingModel(
    @DrawableRes val imageId: Int,
    val title: String,
    val description: String,
)
