package com.putrapebrianonurba.equran.features.dua.ui.components.duaDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.features.dua.presentation.DuaUiState

@Composable
fun DuaDetailContent(uiState: DuaUiState) {
    // CONTAINERS
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(
                top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 54.dp,
                bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding(),
            )
    ) {
        // DUA DETAIL
        when {
            uiState.duaDetailIsLoading -> { DuaDetailShimmer() }
            else -> { DetailContent(uiState.duaDetail) }
        }
    }
}