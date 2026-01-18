package com.putrapebrianonurba.equran.features.quran.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.putrapebrianonurba.equran.features.quran.presentation.QuranSearchViewModel
import com.putrapebrianonurba.equran.features.quran.ui.components.search.SearchedContent
import com.putrapebrianonurba.equran.features.quran.ui.components.search.SearchedTopBar

@Composable
fun QuranSearchedScreen(
    viewModel: QuranSearchViewModel,
    onNavigateDetail: (Int) -> Unit,
    onNavigateBack: () -> Unit,
    onSearchClick: () -> Unit
) {
    // UI STATE
    val uiState by viewModel.uiState.collectAsState()

    // CONTAINER
    Box(modifier = Modifier.fillMaxSize()) {
        // CONTENT
        SearchedContent(
            uiState = uiState,
            onNavigateDetail = onNavigateDetail
        )

        // TOP BAR
        SearchedTopBar(
            isScrolled = true,
            searchTerm = uiState.lastSearchTerm,
            onNavigateBack = onNavigateBack,
            onSearchClick = onSearchClick
        )
    }
}
