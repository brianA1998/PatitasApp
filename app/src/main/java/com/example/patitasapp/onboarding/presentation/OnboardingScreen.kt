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
        OnboardingPagerInformation("Welcome to Monumental Habits",
            "We can help you to be a better version of yourself",
            R.drawable.ic_launcher_foreground),
        OnboardingPagerInformation("Create new habits easily",
            "We can help you to be a better version of yourself",
            R.drawable.ic_launcher_foreground),
        OnboardingPagerInformation("Keep track of your progress",
            "We can help you to be a better version of yourself",
            R.drawable.ic_launcher_foreground),
        OnboardingPagerInformation("Join a supportive community",
            "We can help you to be a better version of yourself",
            R.drawable.ic_launcher_foreground)
    )

    OnboardingPager(pages = pages, onFinish = {
        viewModel.completeOnboarding()
    })

}