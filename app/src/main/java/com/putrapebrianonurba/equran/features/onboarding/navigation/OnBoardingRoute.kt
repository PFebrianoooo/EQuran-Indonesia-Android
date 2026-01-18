package com.putrapebrianonurba.equran.features.onboarding.navigation

sealed class OnBoardingRoute(val route: String) {
    object WELCOME: OnBoardingRoute("onboarding_welcome")
}