package com.example.patitasapp.authentication.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.patitasapp.authentication.domain.usecase.PasswordResult
import com.example.patitasapp.authentication.domain.usecase.LoginUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCases: LoginUseCases
) : ViewModel() {

     var state by mutableStateOf(LoginState())
        private set

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }

            is LoginEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }

            is LoginEvent.Login -> {
                println("Entre al login")
                login()
            }
        }
    }


    private fun login() {
        state = state.copy(
            emailError = null,
            passwordError = null,
        )

        if (!loginUseCases.validateEmailUseCase(state.email)) {
            state = state.copy(emailError = "El mail no es valido")
            return
        }

        val passwordResult = loginUseCases.validatePasswordUseCase(state.password)
        if (passwordResult != PasswordResult.VALID) {
            state = state.copy(passwordError = passwordResult.errorMessage)
            return
        }

        if (state.emailError == null && state.passwordError == null) {
            state = state.copy(isLoading = true)
            viewModelScope.launch {
                loginUseCases.loginWithEmailUseCase(state.email, state.password).onSuccess {
                    state = state.copy(isLoggedIn = true, isLoading = false)
                }.onFailure {
                    state = state.copy(emailError = it.message)
                }
            }
        }

        state = state.copy(isLoading = false)
    }

}