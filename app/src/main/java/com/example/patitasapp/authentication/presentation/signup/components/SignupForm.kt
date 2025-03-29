package com.example.patitasapp.authentication.presentation.signup.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.patitasapp.authentication.presentation.signup.SignUpState
import com.example.patitasapp.authentication.presentation.signup.SignupEvent
import com.example.patitasapp.core.presentation.PatitasButton
import com.example.patitasapp.core.presentation.PatitasPasswordTextField
import com.example.patitasapp.core.presentation.PatitasTextField
import com.example.patitasapp.core.presentation.PatitasTitle

@Composable
fun SignupForm(state: SignUpState, onEvent: (SignupEvent) -> Unit, modifier: Modifier = Modifier) {
    val focusManager = LocalFocusManager.current
    Box(modifier = modifier.background(Color(0xFFFFF3E9)), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.background(Color.Transparent, shape = RoundedCornerShape(20.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PatitasTitle("Create your account")

            Spacer(modifier = Modifier.height(32.dp))

            PatitasTextField(
                value = state.email,
                onValueChange = { onEvent(SignupEvent.EmailChange(it)) },
                placeholder = "Email",
                contentDescription = "Enter email",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
                    .padding(horizontal = 20.dp),
                errorMessage = state.emailError,
                leadingIcon = Icons.Outlined.Email,
                isEnabled = !state.isLoading,
                keyboardActions = KeyboardActions(onAny = {
                    focusManager.moveFocus(FocusDirection.Next)
                }),
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                backgroundColor = Color.White
            )

            PatitasPasswordTextField(
                value = state.password,
                onValueChange = { onEvent(SignupEvent.PasswordChange(it)) },
                contentDescription = "Enter password",
                placeholder = "Password",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
                    .padding(horizontal = 20.dp),
                errorMessage = state.passwordError,
                isEnabled = !state.isLoading,
                keyboardActions = KeyboardActions(onAny = {
                    focusManager.clearFocus()
                    onEvent(SignupEvent.SignUp)
                }),
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                backgroundColor = Color.White
            )

            Spacer(modifier = Modifier.height(12.dp))

            PatitasButton(
                text = "Create account",
                isEnabled = !state.isLoading,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
            ) {
                onEvent(SignupEvent.SignUp)
            }


            Spacer(modifier = Modifier.height(12.dp))


            TextButton(onClick = { onEvent(SignupEvent.LogIn) }) {
                Text(
                    text = buildAnnotatedString {
                        append("Already have an account? ")
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Sign in")
                        }
                    },
                    color = MaterialTheme.colorScheme.tertiary,
                )
            }


        }
    }

}