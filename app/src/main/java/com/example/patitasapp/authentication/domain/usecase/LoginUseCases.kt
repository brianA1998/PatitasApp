package com.example.patitasapp.authentication.domain.usecase

data class LoginUseCases(
    val loginWithEmailUseCase: LoginWithEmailUseCase,
    val validatePasswordUseCase: ValidatePasswordUseCase,
    val validateEmailUseCase: ValidateEmailUseCase
)

