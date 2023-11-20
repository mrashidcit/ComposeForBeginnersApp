package com.example.composebasicapp.onBoarding

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OnboardingViewModel: ViewModel() {

    private val _uiState : MutableStateFlow<OnboardingState> = MutableStateFlow(OnboardingState())
    val uiState = _uiState.asStateFlow()

    /**
     *
     * @return Boolean - true means should navigate to next screen
     */
    fun moveNext(): Boolean {
        val currentIndex = uiState.value.selectedIndex
        if (currentIndex >= uiState.value.items.lastIndex) {
            return true
        }

        _uiState.update {
            it.copy(
                selectedIndex = currentIndex + 1
            )
        }
        return false
    }

}