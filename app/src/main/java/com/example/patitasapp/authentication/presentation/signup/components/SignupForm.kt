package com.example.patitasapp.authentication.presentation.signup.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.patitasapp.authentication.presentation.signup.SignUpState
import com.example.patitasapp.authentication.presentation.signup.SignupEvent
import com.example.patitasapp.core.presentation.PatitasTextField
import com.example.patitasapp.core.presentation.PatitasTitle

@Composable
fun SignupForm(state : SignUpState, onEvent: (SignupEvent) -> Unit, modifier: Modifier) {
    val focusManager = LocalFocusManager.current

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        PatitasTitle("Create your account")

        Spacer(modifier = Modifier.height(32.dp))

        PatitasTextField(
            value = state.email,
            onValueChange = { onEvent(SignupEvent.EmailChange(state.email)) },
            placeholder = "Email",
            contentDescription = "Enter email",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp)
                .padding(horizontal = 20.dp),
            errorMessage = state.emailError,
            isEnabled = !state.isLoading,
            keyboardActions = KeyboardActions(onAny = {
                focusManager.moveFocus(FocusDirection.Next)
            }),
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
    }
}