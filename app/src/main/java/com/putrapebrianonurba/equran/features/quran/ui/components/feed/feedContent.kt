package com.putrapebrianonurba.equran.features.quran.ui.components.feed

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
import com.putrapebrianonurba.equran.core.constants.AppConstants
import com.putrapebrianonurba.equran.features.quran.presentation.QuranUiState
import com.putrapebrianonurba.equran.features.quran.ui.components.shared.SurahCard
import com.putrapebrianonurba.equran.features.quran.ui.components.shared.SurahCardShimmer

@Composable
fun FeedContent(
    uiState: QuranUiState,
    scrollState: LazyListState,
    onNavigateDetail: (Int) -> Unit
) {
    // CONTAINER
    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(
            top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 54.dp,
            bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding() + 50.dp,
        ),
    ) {
        // BANNER
        item { FeedBanner(AppConstants.QURAN_CAROUSEL_IMAGE_ITEMS) }

        // LIST SURAH
        when {
            uiState.allSurahIsLoading -> { items(10) { SurahCardShimmer() } }
            else -> {
                items(uiState.allSurah) { surah ->
                    SurahCard(
                        surah = surah,
                        onNavigateDetail = {onNavigateDetail(surah.id)}
                    )
                }
            }
        }
    }
}