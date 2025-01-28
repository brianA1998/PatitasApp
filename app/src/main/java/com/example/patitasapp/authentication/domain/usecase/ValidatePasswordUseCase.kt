package com.example.patitasapp.authentication.domain.usecase

class ValidatePasswordUseCase {

    operator fun invoke(password: String): PasswordResult {
       return when {
           password.isEmpty() -> PasswordResult.INVALID_LENGTH
            password.length < 8 -> PasswordResult.INVALID_LENGTH
            !password.any { it.isLowerCase() } -> PasswordResult.INVALID_LOWERCASE
            !password.any { it.isUpperCase() } -> PasswordResult.INVALID_UPPERCASE
            !password.any { it.isDigit() } -> PasswordResult.INVALID_DIGITS
            else -> PasswordResult.VALID
        }
    }
}