package com.example.patitasapp.authentication.domain.usecase

import com.example.patitasapp.authentication.domain.repository.AuthenticationRepository

class GetUserIdUseCase(val repository: AuthenticationRepository) {
    operator fun invoke(): String? {
        return repository.getUserId()
    }
}