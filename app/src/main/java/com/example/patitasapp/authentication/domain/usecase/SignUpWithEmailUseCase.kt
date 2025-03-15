package com.example.patitasapp.authentication.domain.usecase

import com.example.patitasapp.authentication.domain.repository.AuthenticationRepository

class SignUpWithEmailUseCase(private val repository: AuthenticationRepository) {
    suspend operator fun invoke(email: String, password: String): Result<Unit> {
        return repository.signup(email, password)
    }
}