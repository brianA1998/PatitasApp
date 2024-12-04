package com.example.patitasapp.onboarding.data

import android.content.SharedPreferences
import com.example.patitasapp.onboarding.domain.repository.OnboardingRepository

class OnboardingRepositoryImpl(
    private val sharedPreferences: SharedPreferences
) : OnboardingRepository {

    companion object {
        private const val HAS_SEEN_ONBOARDING = "has_seen_onboarding"
    }

    override fun hasSeenOnboarding(): Boolean {
        return sharedPreferences.getBoolean(HAS_SEEN_ONBOARDING, false)
    }

    override fun completeOnboarding() {
        return sharedPreferences.edit().putBoolean(HAS_SEEN_ONBOARDING, true).apply()
    }
}