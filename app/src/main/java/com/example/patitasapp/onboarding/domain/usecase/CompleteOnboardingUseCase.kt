package com.example.patitasapp.onboarding.domain.usecase

import com.example.patitasapp.onboarding.domain.repository.OnboardingRepository

class CompleteOnboardingUseCase(private val repository: OnboardingRepository) {
        operator fun invoke(){
            return repository.completeOnboarding()
        }

}