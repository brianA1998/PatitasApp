package com.example.patitasapp.authentication.domain.matcher

interface NotificationMatcher {
    fun registerError(error : String)
    fun containsErrors() : Boolean
    fun getErrors() : List<String>
}