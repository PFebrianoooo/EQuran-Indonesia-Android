package com.putrapebrianonurba.equran.features.quran.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.BookmarkRemove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.core.common.topBarScrollBehavior
import com.putrapebrianonurba.equran.core.components.IconButton
import com.putrapebrianonurba.equran.core.components.NavigationTopBar
import com.putrapebrianonurba.equran.features.quran.presentation.QuranDetailViewModel
import com.putrapebrianonurba.equran.features.quran.ui.components.detail.DetailContent

@Composable
fun QuranDetailScreen(
    viewModel: QuranDetailViewModel,
    onNavigateBack: () -> Unit,
) {
    // UI STATE
    val uiState by viewModel.uiState.collectAsState()

    // SCROLL STATE ANIMATION
    val scrollState = rememberLazyListState()
    val isScrolled = scrollState.topBarScrollBehavior()

    // CONTAINER
    Box(modifier = Modifier.fillMaxSize()) {
        // CONTENT
        DetailContent(
            uiState = uiState,
            scrollState = scrollState,
            onClick = { viewModel.toggleAudioPlayer() }
        )

        // TOP BAR
        NavigationTopBar(
            isScrolled = isScrolled,
            leading = {
                IconButton(
                    icon = Icons.Default.ArrowBackIosNew,
                    size = 18.dp,
                    onClick = onNavigateBack
                )
            },
            trailing = {
                IconButton(
                    icon = if (uiState.surahIsBookmarked)
                        Icons.Default.Bookmark else
                        Icons.Outlined.BookmarkRemove,
                    size = 18.dp,
                    onClick = { viewModel.toggleBookmarkedButton() }
                )
            }
        )
    }
}