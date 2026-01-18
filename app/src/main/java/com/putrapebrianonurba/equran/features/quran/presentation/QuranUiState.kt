package com.putrapebrianonurba.equran.features.quran.presentation

import com.putrapebrianonurba.equran.domain.model.quran.Search
import com.putrapebrianonurba.equran.domain.model.quran.Surah

data class QuranUiState(
    // FEED
    val allSurahIsLoading: Boolean = true,
    val allSurah: List<Surah> = emptyList(),

    // DETAIL
    val detailIsLoading: Boolean = true,
    val detailAudioIsPlaying: Boolean = false,
    val detailSurah: Surah? = null,
    val surahIsBookmarked: Boolean = false,

    // BOOKMARK
    val bookmarkIsLoading: Boolean = true,
    val bookmarksSurah: List<Surah> = emptyList(),

    // SEARCH
    val searchTerm: String = "",
    val lastSearchTerm: String = "",
    val searchIsLoading: Boolean = true,
    val searchedSurah: List<Surah> = emptyList(),

    // SEARCH HISTORY
    val searchHistoryIsLoading: Boolean = true,
    val searchHistory: List<Search> = emptyList()
)
