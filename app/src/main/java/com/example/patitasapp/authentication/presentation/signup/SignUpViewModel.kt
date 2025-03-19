package com.example.patitasapp.authentication.presentation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.patitasapp.authentication.domain.usecase.PasswordResult
import com.example.patitasapp.authentication.domain.usecase.SignUpUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
        state = state.copy(
            emailError = null,
            passwordError = null,
        )

        if (!signUpUseCases.validateEmailUseCase(state.email)) {
            state = state.copy(
                emailError = "El email no es valido"
            )
        }

        val passwordResult = signUpUseCases.validatePasswordUseCase(state.password)
        if (passwordResult != PasswordResult.VALID) {
            state = state.copy(
                passwordError = passwordResult.errorMessage
            )
        }

        if (state.emailError == null && state.passwordError == null) {
            state = state.copy(
                isLoading = true
            )
            viewModelScope.launch {
                signUpUseCases.signUpWithEmailUseCase(state.email, state.password).onSuccess {
                    state = state.copy(
                        isSignedIn = true,
                        isLoading = false
                    )
                }.onFailure {
                    state = state.copy(
                        emailError = it.message
                    )
                }
            }

            state = state.copy(
                isLoading = false
            )
        }
    }

}