package com.example.patitasapp.authentication.presentation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.patitasapp.authentication.domain.usecase.SignUpUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCases: SignUpUseCases
) : ViewModel(){

    var state by mutableStateOf(SignUpState())
        private set


    fun onEvent(event: SignupEvent) {
        when (event) {
            is SignupEvent.EmailChange -> {
                state = state.copy(
                    email = event.email
                )
            }

            is SignupEvent.PasswordChange -> {
                state = state.copy(
                    password = event.password
                )
            }

            SignupEvent.LogIn -> {
                state = state.copy(
                    logIn = true
                )
            }

            SignupEvent.SignUp -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        TODO("Not yet implemented")
    }

}