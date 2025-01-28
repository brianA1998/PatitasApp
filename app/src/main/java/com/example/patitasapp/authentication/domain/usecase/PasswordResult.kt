package com.example.patitasapp.authentication.domain.usecase

enum class PasswordResult(val errorMessage: String?) {
    VALID(null),
    INVALID_LOWERCASE("La contraseña tiene que tener al menos 1 caracter en minuscula"),
    INVALID_UPPERCASE("La contraseña tiene que tener al menos 1 caracter en mayuscula"),
    INVALID_DIGITS("La contraseña tiene que tener al menos 1 numero"),
    INVALID_LENGTH("La contraseña tiene que tener al menos 8 caracteres")
}