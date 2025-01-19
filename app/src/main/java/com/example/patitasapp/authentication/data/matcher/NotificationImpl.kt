package com.example.patitasapp.authentication.data.matcher

import com.example.patitasapp.authentication.domain.matcher.NotificationMatcher

class NotificationImpl : NotificationMatcher {
    private val errors = mutableListOf<String>()

    override fun registerError(error: String) {
        errors.add(error)
    }

    override fun containsErrors(): Boolean {
        return errors.isNotEmpty()
    }

    override fun getErrors(): List<String> {
        return errors
    }
}