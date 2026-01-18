package com.putrapebrianonurba.equran.features.prayer.navigation

sealed class PrayerRoute(val route: String) {
    // ROOT GRAPH
    object ROOT: PrayerRoute("prayer_root_graph")

    // FEED MAIN MENU
    object FEED: PrayerRoute("prayer/feed")
    object CITIES: PrayerRoute("prayer/feed/cities")
}