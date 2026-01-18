package com.putrapebrianonurba.equran.features.root

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.putrapebrianonurba.equran.features.root.navigation.BottomNavItem
import com.putrapebrianonurba.equran.features.root.navigation.RootNavigation

/**
 * Root Screen
 *
 * The RootScreen serves as the primary navigation controller for the application.
 * It manages the conditional visibility of the Bottom Navigation Bar and orchestrates the routing logic between the main features accessible via that bar.
 *
 * @param[startDecisionRoute] his parameter acts as the entry-point logic gate for the application.
 * It determines the destination route immediately following the initialization phase.
 */

@Composable
fun RootScreen(
    startDecisionRoute: String
) {
    // NAV CONTROLLER STATE
    val navController = rememberNavController()

    // GETTING CURRENT ENTRY FOR BACKSTACK
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // PICK ROUTES WHERE BOTTOM BAR MUST SHOWN
    val topLevelRoutes = BottomNavItem.menuItems.map { it.startDestinationRoute }.toSet()

    // SHOW BOTTOM BAR ONLY IN TOP LEVEL ROUTES
    val showBottomBar = currentDestination?.route?.startsWith("onboarding") != true &&
            currentDestination?.route in topLevelRoutes

    Scaffold(
        bottomBar = { if (showBottomBar) BottomNavigationBar(navController, currentDestination) },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        RootNavigation(navController, startDecisionRoute, paddingValues)
    }
}