package com.putrapebrianonurba.equran.features.root.navigation

sealed class RootRoute(val route: String) {
    data object Onboarding : RootRoute("onboarding_graph")
    data object Main : RootRoute("root_graph")
}
