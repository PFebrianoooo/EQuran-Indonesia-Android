package com.putrapebrianonurba.equran.features.onboarding.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.putrapebrianonurba.equran.features.onboarding.presentation.OnboardingViewModel
import com.putrapebrianonurba.equran.features.onboarding.ui.OnboardingWelcome
import com.putrapebrianonurba.equran.features.root.navigation.RootRoute

fun NavGraphBuilder.onBoardingGraph(navHostController: NavHostController) {
    navigation(
        route = RootRoute.Onboarding.route,
        startDestination = OnBoardingRoute.WELCOME.route
    ) {
        composable(
            route = OnBoardingRoute.WELCOME.route,
            exitTransition = {
                fadeOut(animationSpec = tween(400))
            }
        ) {
            val viewModel: OnboardingViewModel = hiltViewModel()
            OnboardingWelcome(
                viewModel = viewModel,
                onFinish = {
                    navHostController.navigate(RootRoute.Main.route) {
                        popUpTo(RootRoute.Onboarding.route) { inclusive = true }
                    }
                }
            )
        }
    }
}