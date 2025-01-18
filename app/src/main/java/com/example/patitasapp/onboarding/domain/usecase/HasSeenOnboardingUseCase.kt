package com.example.patitasapp.onboarding.domain.usecase

import com.example.patitasapp.onboarding.domain.repository.OnboardingRepository

class HasSeenOnboardingUseCase(private val repository: OnboardingRepository) {
    operator fun invoke(): Boolean {
        return repository.hasSeenOnboarding()
    }
}