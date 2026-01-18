package com.putrapebrianonurba.equran.features.dua.ui.components.duas

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
import com.putrapebrianonurba.equran.features.dua.presentation.DuaUiState
import com.putrapebrianonurba.equran.features.dua.ui.components.shared.DuaCard
import com.putrapebrianonurba.equran.features.dua.ui.components.shared.DuaCardShimmer

@Composable
fun DuasContent(
    uiState: DuaUiState,
    onNavigateDetail: (Int) -> Unit
) {
    // CONTAINER
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(
            top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 40.dp,
            bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding(),
        ),
    ) {
        // DUAS BANNER
        item { TextBanner(AppConstants.DUAS_TITLE) }

        // DUAS
        when {
            uiState.duasIsLoading -> { items(15) { DuaCardShimmer() } }
            else -> {
                items(uiState.duas) { duas ->
                    DuaCard(
                        dua = duas,
                        onNavigateDetail = { onNavigateDetail(duas.id) }
                    )
                }
            }
        }
    }
}
