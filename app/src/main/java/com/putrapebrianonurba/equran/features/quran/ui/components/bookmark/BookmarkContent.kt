package com.putrapebrianonurba.equran.features.quran.ui.components.bookmark

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
import com.putrapebrianonurba.equran.core.components.TextBanner
import com.putrapebrianonurba.equran.core.constants.AppConstants
import com.putrapebrianonurba.equran.features.quran.presentation.QuranUiState
import com.putrapebrianonurba.equran.features.quran.ui.components.shared.EmptySurah
import com.putrapebrianonurba.equran.features.quran.ui.components.shared.SurahCard
import com.putrapebrianonurba.equran.features.quran.ui.components.shared.SurahCardShimmer

@Composable
fun BookmarkContent(
    uiState: QuranUiState,
    onNavigateDetail: (Int) -> Unit
) {
    // CONTAINER
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(
            top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 45.dp,
            bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding(),
        ),
    ) {
        // BANNER
        item { TextBanner(AppConstants.QURAN_BOOKMARK_BANNER_TITLE) }

        // LIST BOOKMARKED SURAH
        when {
            uiState.bookmarkIsLoading -> { items(2) { SurahCardShimmer() } }
            uiState.bookmarksSurah.isNotEmpty() -> {
                items(uiState.bookmarksSurah) { surah ->
                    SurahCard(
                        surah = surah,
                        onNavigateDetail = { onNavigateDetail(surah.id) }
                    )
                }
            }
            else -> { item { EmptySurah(AppConstants.QURAN_BOOKMARK_EMPTY_SURAH_TITLE) } }
        }
    }
}