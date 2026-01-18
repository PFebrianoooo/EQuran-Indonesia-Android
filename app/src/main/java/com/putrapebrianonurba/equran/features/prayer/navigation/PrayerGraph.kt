package com.putrapebrianonurba.equran.features.prayer.navigation

import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.putrapebrianonurba.equran.features.prayer.presentation.PrayerCitiesViewModel
import com.putrapebrianonurba.equran.features.prayer.presentation.PrayerFeedViewModel
import com.putrapebrianonurba.equran.features.prayer.ui.PrayerCitiesScreen
import com.putrapebrianonurba.equran.features.prayer.ui.PrayerFeedScreen

fun NavGraphBuilder.prayerGraph(navHostController: NavHostController) {
    val ANIMATION_DURATION = 400

    navigation(
        startDestination = PrayerRoute.FEED.route,
        route = PrayerRoute.ROOT.route
    ) {
        composable(
            route = PrayerRoute.FEED.route,
            enterTransition = {
                fadeIn(animationSpec = tween(ANIMATION_DURATION))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(ANIMATION_DURATION))
            }
        ) {
            val viewModel: PrayerFeedViewModel = hiltViewModel()

            PrayerFeedScreen(
                viewModel = viewModel,
                onNavigateCities = { navHostController.navigate(PrayerRoute.CITIES.route) }
            )
        }

       composable(
           route = PrayerRoute.CITIES.route,
           enterTransition = {
               slideIntoContainer(
                   towards = SlideDirection.Left,
                   animationSpec = tween(ANIMATION_DURATION)
               )
           },
           exitTransition = {
               slideOutOfContainer(
                   towards = SlideDirection.Left,
                   animationSpec = tween(ANIMATION_DURATION)
               )
           },
           popEnterTransition = {
               slideIntoContainer(
                   towards = SlideDirection.Right,
                   animationSpec = tween(ANIMATION_DURATION)
               )
           },
           popExitTransition = {
               slideOutOfContainer(
                   towards = SlideDirection.Right,
                   animationSpec = tween(ANIMATION_DURATION)
               )
           }
       ) {
           val viewModel: PrayerCitiesViewModel = hiltViewModel()

           PrayerCitiesScreen(
               viewModel = viewModel,
               onNavigateBack = { navHostController.popBackStack() }
           )
       }
    }
}