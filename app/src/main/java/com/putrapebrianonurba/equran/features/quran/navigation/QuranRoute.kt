package com.putrapebrianonurba.equran.features.quran.navigation

sealed class QuranRoute(val route: String) {
    // ROOT GRAPH
    object ROOT: QuranRoute("quran_root_graph")

    // ROOT GRAPH CHILD SCREEN
    object Feed: QuranRoute("quran/feed")
    object SurahSearch: QuranRoute("quran/feed/surah/search")
    object SurahSearched: QuranRoute("quran/feed/surah/searched/{query}") {
        fun createRoute(query: String) = "quran/feed/surah/searched/$query"
    }
    object SurahBookmarked: QuranRoute("quran/feed/bookmarked")
    object Settings: QuranRoute("quran/settings")

    // SHARED DETAIL
    object SurahDetail: QuranRoute("quran/surah/detail/{id}") {
        fun createRoute(id: Int) = "quran/surah/detail/$id"
    }
}