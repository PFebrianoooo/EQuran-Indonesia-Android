package com.putrapebrianonurba.equran.features.root.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.ui.graphics.vector.ImageVector
import com.putrapebrianonurba.equran.features.dua.navigation.DuaRoute
import com.putrapebrianonurba.equran.features.prayer.navigation.PrayerRoute
import com.putrapebrianonurba.equran.features.quran.navigation.QuranRoute

sealed class BottomNavItem(
    val graphRoute: String,
    val startDestinationRoute: String,
    val title: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector
) {
    object Prayer: BottomNavItem (
        graphRoute = PrayerRoute.ROOT.route,
        startDestinationRoute = PrayerRoute.FEED.route,
        title = "Adzan",
        icon = Icons.Default.Schedule,
        selectedIcon = Icons.Filled.Schedule
    )

    object Quran: BottomNavItem (
        graphRoute = QuranRoute.ROOT.route,
        startDestinationRoute = QuranRoute.Feed.route,
        title = "Al Quran",
        icon = Icons.AutoMirrored.Default.MenuBook,
        selectedIcon = Icons.AutoMirrored.Filled.MenuBook
    )

    object Dua: BottomNavItem (
        graphRoute = DuaRoute.ROOT.route,
        startDestinationRoute = DuaRoute.Feed.route,
        title = "Doa-Doa",
        icon = Icons.Default.Book,
        selectedIcon = Icons.Filled.Book
    )

    companion object {
        val menuItems = listOf(Prayer, Quran, Dua)
    }
}