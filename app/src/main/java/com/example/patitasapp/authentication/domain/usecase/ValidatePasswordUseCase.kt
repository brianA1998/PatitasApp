package com.example.patitasapp.authentication.domain.usecase

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.patitasapp.R
import com.example.patitasapp.authentication.domain.matcher.NotificationMatcher

class ValidatePasswordUseCase(private val notificationMatcher: NotificationMatcher) {
    @Composable
    operator fun invoke(password: String): NotificationMatcher {
        when {
            password.isEmpty() -> notificationMatcher.registerError(stringResource(R.string.password_empty))
            password.length < 8 -> notificationMatcher.registerError(stringResource(R.string.password_min_length))
            !password.any { it.isLowerCase() } -> notificationMatcher.registerError(stringResource(R.string.password_lowercase))
            !password.any { it.isUpperCase() } -> notificationMatcher.registerError(stringResource(R.string.password_uppercase))
            !password.any { it.isDigit() } -> notificationMatcher.registerError(stringResource(R.string.password_digit))
        }
        return notificationMatcher
    }
}