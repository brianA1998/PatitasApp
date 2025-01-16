package com.example.patitasapp.onboarding.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.patitasapp.R
import com.example.patitasapp.onboarding.presentation.components.OnboardingPager

@Composable
fun OnboardingScreen(
    onFinish: () -> Unit,
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = viewModel.hasSeenOnboarding){
        if(viewModel.hasSeenOnboarding){
            onFinish()
        }
    }
    val pages = listOf(
        OnboardingPagerInformation("Bienvenido a patitas App",
            "¡Un hogar para cada mascota, empieza acá!",
            R.drawable.onboarding1),
        OnboardingPagerInformation("Tu compañero te espera",
            "Descubre mascotas que esperan por un hogar lleno de amor",
            R.drawable.onboarding2),
        OnboardingPagerInformation("¡Todo listo para empezar!",
            "Tu próximo compañero está a un clic de distancia. ¡Vamos!",
            R.drawable.onboarding3),
    )

    OnboardingPager(pages = pages, onFinish = {
        viewModel.completeOnboarding()
    })

}