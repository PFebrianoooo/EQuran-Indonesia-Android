package com.putrapebrianonurba.equran.features.quran.navigation

import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.putrapebrianonurba.equran.features.quran.presentation.QuranBookmarkViewModel
import com.putrapebrianonurba.equran.features.quran.presentation.QuranDetailViewModel
import com.putrapebrianonurba.equran.features.quran.presentation.QuranFeedViewModel
import com.putrapebrianonurba.equran.features.quran.presentation.QuranSearchViewModel
import com.putrapebrianonurba.equran.features.quran.presentation.SettingsViewModel
import com.putrapebrianonurba.equran.features.quran.ui.QuranBookmarkScreen
import com.putrapebrianonurba.equran.features.quran.ui.QuranDetailScreen
import com.putrapebrianonurba.equran.features.quran.ui.QuranFeedScreen
import com.putrapebrianonurba.equran.features.quran.ui.QuranSearchScreen
import com.putrapebrianonurba.equran.features.quran.ui.QuranSearchedScreen
import com.putrapebrianonurba.equran.features.quran.ui.SettingsScreen

fun NavGraphBuilder.quranGraph(navHostController: NavHostController) {
    val ANIMATION_DURATION = 400

    navigation(
        startDestination = QuranRoute.Feed.route,
        route = QuranRoute.ROOT.route
    ) {
        // COMPOSABLE
        composable(
            route = QuranRoute.Feed.route,
            enterTransition = {
                fadeIn(animationSpec = tween(ANIMATION_DURATION))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(ANIMATION_DURATION))
            }
        ) {
            val viewModel: QuranFeedViewModel = hiltViewModel()

            QuranFeedScreen(
                viewModel = viewModel,
                onSearchClick = { navHostController.navigate(QuranRoute.SurahSearch.route) },
                onNavigateBookmark = { navHostController.navigate(QuranRoute.SurahBookmarked.route) },
                onNavigateSettings ={ navHostController.navigate(QuranRoute.Settings.route) },
                onNavigateDetail = { id ->
                    navHostController.navigate(QuranRoute.SurahDetail.createRoute(id))
                },
            )
        }

        composable(
            route = QuranRoute.SurahSearch.route,
            ) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navHostController.getBackStackEntry(QuranRoute.ROOT.route)
            }

            val viewModel: QuranSearchViewModel = hiltViewModel(parentEntry)

            QuranSearchScreen(
                viewModel = viewModel,
                onNavigateSearched = { query ->
                    navHostController.navigate(QuranRoute.SurahSearched.createRoute(query)) {
                        popUpTo(QuranRoute.SurahSearch.route) { inclusive = true }
                    }
                },
                onNavigateBack = { navHostController.popBackStack() }
            )
        }

        composable(
            route = QuranRoute.SurahSearched.route,
            popExitTransition = {
                slideOutOfContainer(
                    towards = SlideDirection.Right,
                    animationSpec = tween(ANIMATION_DURATION)
                )
            }
        ) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navHostController.getBackStackEntry(QuranRoute.ROOT.route)
            }

            val viewModel: QuranSearchViewModel = hiltViewModel(parentEntry)

            QuranSearchedScreen(
                viewModel = viewModel,
                onNavigateDetail = { id ->
                    navHostController.navigate(QuranRoute.SurahDetail.createRoute(id))
                },
                onNavigateBack = { navHostController.popBackStack() },
                onSearchClick = {
                    navHostController.navigate(QuranRoute.SurahSearch.route) {
                        popUpTo(QuranRoute.SurahSearched.route) { inclusive = true }
                    }
                }
            )
        }

        composable(
            route = QuranRoute.SurahBookmarked.route,
            enterTransition = {
                slideIntoContainer(
                    towards = SlideDirection.Left,
                    animationSpec = tween(ANIMATION_DURATION)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = SlideDirection.Right,
                    animationSpec = tween(ANIMATION_DURATION)
                )
            },
        ) {
            val viewModel: QuranBookmarkViewModel = hiltViewModel()

            QuranBookmarkScreen(
                viewModel = viewModel,
                onNavigateDetail = { id ->
                    navHostController.navigate(QuranRoute.SurahDetail.createRoute(id))
                },
                onNavigateBack = { navHostController.popBackStack() }
            )
        }

        composable(
            route = QuranRoute.SurahDetail.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType }),
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
            val viewModel: QuranDetailViewModel = hiltViewModel()

            QuranDetailScreen (
                viewModel = viewModel,
                onNavigateBack = { navHostController.popBackStack() },
            )
        }

        composable(
            route = QuranRoute.Settings.route,
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
            val viewModel: SettingsViewModel = hiltViewModel()

            SettingsScreen(
                viewModel = viewModel,
                onNavigateBack = {navHostController.popBackStack()}
            )
        }
    }
}

