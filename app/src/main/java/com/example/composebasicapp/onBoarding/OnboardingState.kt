package com.example.composebasicapp.onBoarding

import com.example.composebasicapp.R
import com.example.composebasicapp.models.OnboardingModel

data class OnboardingState(
    val items: ArrayList<OnboardingModel> = defaultItems(),
    val selectedItem: Int = 0,
) {
    fun getSelectedItem() = items[selectedItem]
}

private fun defaultItems(): ArrayList<OnboardingModel> {
    return arrayListOf(
        OnboardingModel(
            imageId = R.drawable.img_onboarding_1,
            title = "Explore Upcoming and Nearby Events",
            description = "In publishing and graphic design, Lorem is a placeholder text commonly"
        ),
        OnboardingModel(
            imageId = R.drawable.img_onboarding_2,
            title = "Web Have Modern Events Calendar Feature",
            description = "In publishing and graphic design, Lorem is a placeholder text commonly"
        ),
        OnboardingModel(
            imageId = R.drawable.img_onboarding_3,
            title = "To Loop Up More Events or Activities Nearby By Map",
            description = "In publishing and graphic design, Lorem is a placeholder text commonly"
        ),

    )
}