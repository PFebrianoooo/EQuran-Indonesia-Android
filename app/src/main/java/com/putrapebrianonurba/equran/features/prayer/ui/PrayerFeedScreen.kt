package com.putrapebrianonurba.equran.features.prayer.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.putrapebrianonurba.equran.core.common.topBarScrollBehavior
import com.putrapebrianonurba.equran.features.prayer.presentation.PrayerFeedViewModel
import com.putrapebrianonurba.equran.features.prayer.ui.components.feed.FeedContent
import com.putrapebrianonurba.equran.features.prayer.ui.components.feed.FeedTopBar

@Composable
fun PrayerFeedScreen(
    viewModel: PrayerFeedViewModel,
    onNavigateCities: () -> Unit
) {
    // UI STATE
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    // SCROLL BEHAVIOR TOP BAR PROPERTIES
    val scrollState = rememberLazyListState()
    val isScrolled = scrollState.topBarScrollBehavior()

    // CONTAINER
    Box(modifier = Modifier.fillMaxSize()) {
        // CONTENT
        FeedContent(
            uiState = uiState,
            scrollState = scrollState
        )

        // TOP BAR
        FeedTopBar(
            isScrolled = isScrolled,
            location = uiState.selectedCity,
            onClick = onNavigateCities
        )
    }
}