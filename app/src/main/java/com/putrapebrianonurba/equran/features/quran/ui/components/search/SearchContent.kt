package com.putrapebrianonurba.equran.features.quran.ui.components.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.features.quran.presentation.QuranUiState

@Composable
fun SearchContent(
    uiState: QuranUiState,
    onDeletedHistory: (Int) -> Unit
) {
    // CONTAINER
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(
            top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 64.dp,
            bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding() + 50.dp,
        ),
        userScrollEnabled = false
    ) {
        // SEARCH HISTORY
        when {
            uiState.searchHistory.isNotEmpty() -> {
                items(uiState.searchHistory) { search ->
                    SearchHistoryCard(
                        search = search,
                        onDeletedHistory = { onDeletedHistory(search.id) }
                    )
                }
            }
        }
    }
}