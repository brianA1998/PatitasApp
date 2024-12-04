package com.example.patitasapp.onboarding.domain.repository

interface OnboardingRepository {

    fun hasSeenOnboarding(): Boolean

    fun completeOnboarding()
}