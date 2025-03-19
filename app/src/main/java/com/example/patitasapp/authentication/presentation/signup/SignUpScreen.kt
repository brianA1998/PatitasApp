package com.example.patitasapp.authentication.presentation.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.patitasapp.R
import com.example.patitasapp.authentication.presentation.signup.components.SignupForm

@Composable
fun SignUpScreen(
    onSignUp: () -> Unit,
    onLogin: () -> Unit,
    viewmodel: SignUpViewModel = hiltViewModel()
) {
    val state = viewmodel.state

    LaunchedEffect(state.isSignedIn) {
        if (state.isSignedIn) {
            onSignUp()
        }
    }

    LaunchedEffect(state.logIn) {
        if (state.logIn) {
            onLogin()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Image(painter = painterResource(id = R.drawable.signup), contentDescription = null)
        SignupForm(state = state, onEvent = viewmodel::onEvent, modifier = Modifier.fillMaxWidth())
    }

    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}