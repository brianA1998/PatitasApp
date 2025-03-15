package com.example.patitasapp.authentication.di

import com.example.patitasapp.authentication.data.matcher.EmailMatcherImpl
import com.example.patitasapp.authentication.data.repository.AuthenticationRepositoryImpl
import com.example.patitasapp.authentication.domain.matcher.EmailMatcher
import com.example.patitasapp.authentication.domain.repository.AuthenticationRepository
import com.example.patitasapp.authentication.domain.usecase.GetUserIdUseCase
import com.example.patitasapp.authentication.domain.usecase.LoginUseCases
import com.example.patitasapp.authentication.domain.usecase.LoginWithEmailUseCase
import com.example.patitasapp.authentication.domain.usecase.SignUpUseCases
import com.example.patitasapp.authentication.domain.usecase.SignUpWithEmailUseCase
import com.example.patitasapp.authentication.domain.usecase.ValidateEmailUseCase
import com.example.patitasapp.authentication.domain.usecase.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthenticationModule {

    @Provides
    @Singleton
    fun provideEmailMatcher(): EmailMatcher {
        return EmailMatcherImpl()
    }

    @Provides
    @Singleton
    fun provideAuthenticationRepository(): AuthenticationRepository {
        return AuthenticationRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideLoginUseCases(
        emailMatcher: EmailMatcher,
        authenticationRepository: AuthenticationRepository
    ): LoginUseCases {
        return LoginUseCases(
            validateEmailUseCase = ValidateEmailUseCase(emailMatcher),
            validatePasswordUseCase = ValidatePasswordUseCase(),
            loginWithEmailUseCase = LoginWithEmailUseCase(authenticationRepository)
        )
    }

    @Provides
    @Singleton
    fun provideSignupUseCases(
        emailMatcher: EmailMatcher,
        authenticationRepository: AuthenticationRepository
    ): SignUpUseCases {
        return SignUpUseCases(
            validateEmailUseCase = ValidateEmailUseCase(emailMatcher),
            validatePasswordUseCase = ValidatePasswordUseCase(),
            signUpWithEmailUseCase = SignUpWithEmailUseCase(authenticationRepository)
        )
    }

    @Provides
    @Singleton
    fun provideGetUserIdUseCase(repository: AuthenticationRepository): GetUserIdUseCase {
        return GetUserIdUseCase(repository)
    }


}