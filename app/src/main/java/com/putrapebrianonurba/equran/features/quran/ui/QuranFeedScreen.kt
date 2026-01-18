package com.putrapebrianonurba.equran.features.quran.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.putrapebrianonurba.equran.core.common.topBarScrollBehavior
import com.putrapebrianonurba.equran.features.quran.presentation.QuranFeedViewModel
import com.putrapebrianonurba.equran.features.quran.ui.components.feed.FeedContent
import com.putrapebrianonurba.equran.features.quran.ui.components.feed.FeedTopBar

@Composable
fun QuranFeedScreen(
    viewModel: QuranFeedViewModel,
    onSearchClick: () -> Unit,
    onNavigateBookmark: () -> Unit,
    onNavigateSettings: () -> Unit,
    onNavigateDetail: (Int) -> Unit
) {
    // UI STATE
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    // SCROLL BEHAVIOR TOP BAR PROPERTIES
    val scrollState = rememberLazyListState()
    val isScrolled = scrollState.topBarScrollBehavior()

    // CONTAINER
    Box(modifier = Modifier.fillMaxSize()) {
        // SURAH CONTENT
        FeedContent(
            uiState = uiState,
            scrollState = scrollState,
            onNavigateDetail = onNavigateDetail
        )

        // TOP BAR
        FeedTopBar (
            isScrolled = isScrolled,
            onSearchClick = onSearchClick,
            onNavigateBookmark = onNavigateBookmark,
            onNavigateSettings = onNavigateSettings
        )
    }
}