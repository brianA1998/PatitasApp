package com.example.patitasapp.authentication.domain.usecase

data class SignUpUseCases(
    val signUpWithEmailUseCase: SignUpWithEmailUseCase,
    val validatePasswordUseCase: ValidatePasswordUseCase,
    val validateEmailUseCase: ValidateEmailUseCase
)
