package com.example.patitasapp.authentication.presentation.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.patitasapp.authentication.presentation.login.LoginEvent
import com.example.patitasapp.authentication.presentation.login.LoginState
import com.example.patitasapp.core.presentation.PatitasTextField

@Composable
fun LoginForm(state: LoginState, loginEvent: (LoginEvent) -> Unit) {

    Box(modifier = Modifier, contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.background(Color.White, shape = RoundedCornerShape(20.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Login in with email", modifier = Modifier.padding(16.dp),
                color = Color.Black
            )
            Divider(Modifier.padding(16.dp))

            PatitasTextField(
                value = state.email,
                onValueChange = { loginEvent(LoginEvent.EmailChanged(it)) },
                contentDescription = "Email",
                placeholder = "Email",
                errorMessage = state.emailError,
                leadingIcon = null,
                isEnabled = state.isLoading.not()
            )

        }
    }
}