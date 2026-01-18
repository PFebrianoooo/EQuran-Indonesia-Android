package com.putrapebrianonurba.equran.features.dua.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.R
import com.putrapebrianonurba.equran.core.components.IconButton
import com.putrapebrianonurba.equran.core.components.NavigationTopBar
import com.putrapebrianonurba.equran.features.dua.presentation.DuasTestViewModel
import com.putrapebrianonurba.equran.features.dua.ui.components.duastest.DuasTestBottomSheet
import com.putrapebrianonurba.equran.features.dua.ui.components.duastest.DuasTestContent

@Composable
fun DuasTestScreen(
    viewModel: DuasTestViewModel,
    onNavigateBack: () -> Unit
) {
    // UI STATE
    val uiState by viewModel.uiState.collectAsState()

    // CONTAINER
    Box(modifier = Modifier.fillMaxSize()) {
        // IMAGE BACKGROUND
        Image(
            painter = painterResource(R.drawable.ic_dua_background),
            contentDescription = R.drawable.ic_dua_background.toString(),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )

        // CONTENT
        DuasTestContent(
            dua = uiState.dua,
            modifier = Modifier.align(Alignment.Center),
            onClickRevealAnswer = { viewModel.onToggleAnswer() },
            onClickRefresh = { viewModel.loadRandomDua() }
        )


        // TOP BAR
        NavigationTopBar(
            isScrolled = false,
            leading = {
                IconButton(
                    icon = Icons.Default.ArrowBackIosNew,
                    size = 18.dp,
                    onClick = onNavigateBack
                )
            }
        )

        // BOTTOM SHEET
        DuasTestBottomSheet(
            dua = uiState.dua,
            isVisible = uiState.answerIsRevealed,
            onDismiss = {viewModel.onToggleAnswer()}
        )
    }
}