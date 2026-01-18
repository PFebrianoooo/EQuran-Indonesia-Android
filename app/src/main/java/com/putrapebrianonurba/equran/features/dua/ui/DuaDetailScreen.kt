package com.putrapebrianonurba.equran.features.dua.ui

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
import com.putrapebrianonurba.equran.features.dua.presentation.DuaDetailViewModel
import com.putrapebrianonurba.equran.features.dua.ui.components.duaDetail.DuaDetailContent

@Composable
fun DuaDetailScreen(
    viewModel: DuaDetailViewModel,
    onNavigateBack: () -> Unit
) {
    // UI STATE
    val uiState by viewModel.uiState.collectAsState()

    // CONTAINER
    Box(modifier = Modifier.fillMaxSize()) {
        // CONTENT
        DuaDetailContent( uiState = uiState)

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