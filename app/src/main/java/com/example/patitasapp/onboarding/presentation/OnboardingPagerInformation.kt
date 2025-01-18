package com.example.patitasapp.onboarding.presentation

import androidx.annotation.DrawableRes

/**
 * Data class that contains the information for the onboarding pager.
 */
data class OnboardingPagerInformation(
    val title: String,
    val subtitle: String,
    @DrawableRes val image: Int
)
