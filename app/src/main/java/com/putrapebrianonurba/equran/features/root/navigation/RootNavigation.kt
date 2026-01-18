package com.putrapebrianonurba.equran.features.root.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.putrapebrianonurba.equran.features.dua.navigation.duaGraph
import com.putrapebrianonurba.equran.features.onboarding.navigation.onBoardingGraph
import com.putrapebrianonurba.equran.features.prayer.navigation.prayerGraph
import com.putrapebrianonurba.equran.features.quran.navigation.QuranRoute
import com.putrapebrianonurba.equran.features.quran.navigation.quranGraph

/**
 * Root Navigation
 *
 * This serves as the primary Navigation Graph Tree for the entire application.
 * It acts as the top-level orchestrator for global routing, encapsulating
 * the main feature modules and their respective sub-graphs, including:
 * - Prayers: Navigation for prayer schedules and cities.
 * - Quran: Routes for the digital Quran reading and listening experience.
 * - Dua: Navigation for the collection of daily supplications and invocations.
 */
@Composable
fun RootNavigation(
    navHostController: NavHostController,
    startDecisionRoute: String,
    paddingValues: PaddingValues
) {
    val ANIM_DURATION = 200

    NavHost(
        navController = navHostController,
        startDestination = startDecisionRoute,
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        enterTransition = { fadeIn(animationSpec = tween(ANIM_DURATION)) },
        exitTransition = { fadeOut(animationSpec = tween(ANIM_DURATION)) },
        ) {

        onBoardingGraph(navHostController)

        navigation(
            route = RootRoute.Main.route,
            startDestination = QuranRoute.ROOT.route
        ) {
            prayerGraph(navHostController)
            quranGraph(navHostController)
            duaGraph(navHostController)
        }
    }
}
