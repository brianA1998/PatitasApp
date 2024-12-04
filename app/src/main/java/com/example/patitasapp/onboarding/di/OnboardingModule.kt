package com.example.patitasapp.onboarding.di

import android.content.Context
import android.content.SharedPreferences
import com.example.patitasapp.onboarding.data.OnboardingRepositoryImpl
import com.example.patitasapp.onboarding.domain.repository.OnboardingRepository
import com.example.patitasapp.onboarding.domain.usecase.CompleteOnboardingUseCase
import com.example.patitasapp.onboarding.domain.usecase.HasSeenOnboardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object OnboardingModule {

    private const val PREFERENCES_NAME = "patitas_preferences"

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideOnboardingRepository(sharedPreferences: SharedPreferences): OnboardingRepository {
        return OnboardingRepositoryImpl(sharedPreferences)
    }

    @Singleton
    @Provides
    fun provideHasSeenOnboardingUseCase(repository: OnboardingRepository): HasSeenOnboardingUseCase {
        return HasSeenOnboardingUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideCompleteOnboardingUseCase(repository: OnboardingRepository): CompleteOnboardingUseCase {
        return CompleteOnboardingUseCase(repository)
    }
}