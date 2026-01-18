package com.putrapebrianonurba.equran.features.quran.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.core.components.IconButton
import com.putrapebrianonurba.equran.core.components.NavigationTopBar
import com.putrapebrianonurba.equran.features.quran.presentation.QuranBookmarkViewModel
import com.putrapebrianonurba.equran.features.quran.ui.components.bookmark.BookmarkContent

@Composable
fun QuranBookmarkScreen(
    viewModel: QuranBookmarkViewModel,
    onNavigateDetail: (Int) -> Unit,
    onNavigateBack: () -> Unit
) {
    // UI STATE
    val uiState by viewModel.uiState.collectAsState()

    // CONTAINER
    Box(modifier = Modifier.fillMaxSize()) {
        // CONTENT
        BookmarkContent(
            uiState = uiState,
            onNavigateDetail = onNavigateDetail
        )

        // TOP BAR
        NavigationTopBar(
            isScrolled = true,
            leading = {
                IconButton(
                    icon = Icons.Default.ArrowBackIosNew,
                    size = 18.dp,
                    onClick = onNavigateBack
                )
            }
        )
    }
}