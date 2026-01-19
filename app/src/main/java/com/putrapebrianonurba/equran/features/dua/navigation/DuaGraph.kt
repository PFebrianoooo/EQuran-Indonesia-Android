package com.putrapebrianonurba.equran.features.dua.navigation

import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.putrapebrianonurba.equran.features.dua.presentation.DuaDetailViewModel
import com.putrapebrianonurba.equran.features.dua.presentation.DuasTestViewModel
import com.putrapebrianonurba.equran.features.dua.presentation.DuasViewModel
import com.putrapebrianonurba.equran.features.dua.ui.DuaDetailScreen
import com.putrapebrianonurba.equran.features.dua.ui.DuaFeedScreen
import com.putrapebrianonurba.equran.features.dua.ui.DuasScreen
import com.putrapebrianonurba.equran.features.dua.ui.DuasTestScreen

fun NavGraphBuilder.duaGraph(navHostController: NavHostController) {
    val ANIMATION_DURATION = 400

    navigation(
        startDestination = DuaRoute.Feed.route,
        route = DuaRoute.ROOT.route,
    ) {
        // COMPOSABLE
        composable(
            route = DuaRoute.Feed.route,
            enterTransition = {
                fadeIn(animationSpec = tween(ANIMATION_DURATION))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(ANIMATION_DURATION))
            }
        ) {
            DuaFeedScreen(
                onNavigateDuas = {
                    navHostController.navigate(DuaRoute.Duas.route)
                },
                onNavigateDuaTest = {
                    navHostController.navigate(DuaRoute.DuasTest.route)
                }
            )
        }

        composable(
            route = DuaRoute.Duas.route,
            enterTransition = {
                slideIntoContainer(
                    towards = SlideDirection.Left,
                    animationSpec = tween(ANIMATION_DURATION)
                )
            },
            exitTransition = {
                fadeOut(animationSpec = tween(ANIMATION_DURATION))
            },
            popEnterTransition = {
                fadeIn(animationSpec = tween(ANIMATION_DURATION))
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = SlideDirection.Right,
                    animationSpec = tween(ANIMATION_DURATION)
                )
            },
        ) {
            val viewModel: DuasViewModel = hiltViewModel()

            DuasScreen(
                viewModel = viewModel,
                onNavigateBack = { navHostController.popBackStack() },
                onNavigateDetail = { id ->
                    navHostController.navigate(DuaRoute.DuaDetail.createRoute(id))
                }
            )
        }

        composable(
            route = DuaRoute.DuasTest.route,
            ) {
            val viewModel: DuasTestViewModel = hiltViewModel()

            DuasTestScreen(
                viewModel = viewModel,
                onNavigateBack = { navHostController.popBackStack() }
            )
        }


        composable(
            route = DuaRoute.DuaDetail.route,
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
            val viewModel: DuaDetailViewModel = hiltViewModel()

            DuaDetailScreen (
                viewModel = viewModel,
                onNavigateBack = { navHostController.popBackStack() }
            )
        }
    }
}