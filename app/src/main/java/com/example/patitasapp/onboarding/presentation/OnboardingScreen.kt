package com.example.patitasapp.onboarding.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.patitasapp.R
import com.example.patitasapp.onboarding.presentation.components.OnboardingPager

@Composable
fun OnboardingScreen(
    onFinish: () -> Unit,
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = viewModel.hasSeenOnboarding) {
        if (viewModel.hasSeenOnboarding) {
            onFinish()
        }
    }
    val pages = listOf(
        OnboardingPagerInformation(
            stringResource(id = R.string.onboarding_title_1),
            stringResource(id = R.string.onboarding_subtitle_1),
            R.drawable.onboarding1
        ),
        OnboardingPagerInformation(
            stringResource(id = R.string.onboarding_title_2),
            stringResource(id = R.string.onboarding_subtitle_2),
            R.drawable.onboarding2
        ),
        OnboardingPagerInformation(
            stringResource(id = R.string.onboarding_title_3),
            stringResource(id = R.string.onboarding_subtitle_3),
            R.drawable.onboarding3
        ),
    )

    OnboardingPager(pages = pages, onFinish = {
        viewModel.completeOnboarding()
    })

}