package com.example.patitasapp.navigation

sealed class NavigationRoute(val route: String){
    object Onboarding : NavigationRoute("onboarding")

    object Login : NavigationRoute("login")
}