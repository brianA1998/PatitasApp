package com.example.patitasapp.authentication.presentation.login

import com.example.patitasapp.authentication.domain.usecase.LoginUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCases: LoginUseCases
){

}