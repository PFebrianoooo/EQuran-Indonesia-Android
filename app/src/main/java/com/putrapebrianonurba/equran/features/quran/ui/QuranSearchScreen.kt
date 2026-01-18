package com.putrapebrianonurba.equran.features.quran.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.putrapebrianonurba.equran.core.common.rememberKeyboardActions
import com.putrapebrianonurba.equran.features.quran.presentation.QuranSearchViewModel
import com.putrapebrianonurba.equran.features.quran.ui.components.search.SearchContent
import com.putrapebrianonurba.equran.features.quran.ui.components.search.SearchTopBar

@Composable
fun QuranSearchScreen(
    viewModel: QuranSearchViewModel,
    onNavigateSearched: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    // UI STATE
    val uiState by viewModel.uiState.collectAsState()

    // HELPERS KEYBOARD HIDE & NAVIGATE
    val runWithHideKeyboard = rememberKeyboardActions()

    // DISPOSE AND CLEARED SEARCH TERM
    DisposableEffect(Unit) { onDispose { viewModel.clearSearch() } }

    // CONTAINER
    Box(modifier = Modifier.fillMaxSize()) {
        // CONTENT
        SearchContent(
            uiState = uiState,
            onDeletedHistory = { viewModel.deleteKeyword(it) }
        )

        // TOP BAR
        SearchTopBar(
            isScrolled = true,
            searchTerm = uiState.searchTerm,
            onValueChange = { viewModel.onSearchTermChange(it) },
            onSearchSubmit = { query ->
                runWithHideKeyboard {
                    onNavigateSearched(query)
                    viewModel.onSearchSubmit()
                }
            },
            onNavigateBack = {
                runWithHideKeyboard {
                    onNavigateBack()
                }
            }
        )
    }
}