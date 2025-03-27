package com.example.patitasapp.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.patitasapp.authentication.presentation.login.LoginScreen
import com.example.patitasapp.authentication.presentation.signup.SignUpScreen
import com.example.patitasapp.onboarding.presentation.OnboardingScreen

@Composable
fun NavigationHost(
    navHostController: NavHostController,
    startDestination: NavigationRoute
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination.route
    ) {
        composable(NavigationRoute.Onboarding.route) {
            OnboardingScreen(onFinish = {
                navHostController.popBackStack()
                navHostController.navigate(NavigationRoute.Login.route)
            }
            )
        }
        composable(NavigationRoute.Login.route) {
            LoginScreen(
                onLogin = {
                    navHostController.popBackStack()
                    navHostController.navigate(NavigationRoute.Home.route)
                },
                onSignUp = {
                    navHostController.navigate(NavigationRoute.Signup.route)
                }
            )
        }

        composable(NavigationRoute.Signup.route) {
            SignUpScreen(
                onSignIn = {
                    navHostController.navigate(NavigationRoute.Home.route) {
                        popUpTo(navHostController.graph.id) {
                            inclusive = true
                        }
                    }
                },
                onLogin = {
                    navHostController.popBackStack()
                }
            )
        }

        composable(NavigationRoute.Home.route) {
            Text("Estamos en Home Screen")
        }
    }
}