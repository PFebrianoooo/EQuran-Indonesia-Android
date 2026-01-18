package com.putrapebrianonurba.equran.features.quran.ui.components.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.features.quran.presentation.QuranUiState
import com.putrapebrianonurba.equran.features.quran.ui.components.detail.banner.DetailSurahBanner

@Composable
fun DetailContent(
    uiState: QuranUiState,
    scrollState: LazyListState,
    onClick: () -> Unit
) {
    // CONTAINER
    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(
            top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 40.dp,
            bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding(),
        ),
    ) {
        // BANNER SURAH INFORMATION
        item {
            DetailSurahBanner(
                uiState = uiState,
                onClick = onClick
            )
        }

        // AYAHS
        when {
            uiState.detailIsLoading -> {
                items(count = 10) {
                    DetailAyahCardShimmer()
                }
            }
            else -> {
                items(items = uiState.detailSurah?.verses.orEmpty()) { ayah ->
                    DetailAyahCard(ayah)
                }
            }
        }
    }
}