package com.example.patitasapp.authentication.domain.matcher

interface EmailMatcher {
    fun isValid(email: String): Boolean
}