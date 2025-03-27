package com.example.patitasapp.navigation

sealed class NavigationRoute(val route: String){
    object Onboarding : NavigationRoute("onboarding")
    object Home : NavigationRoute("home")
    object Login : NavigationRoute("login")
    object Signup : NavigationRoute("signup")
}