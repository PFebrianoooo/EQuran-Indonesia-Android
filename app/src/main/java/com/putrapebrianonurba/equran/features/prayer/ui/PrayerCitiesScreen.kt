package com.putrapebrianonurba.equran.features.prayer.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.putrapebrianonurba.equran.core.components.IconButton
import com.putrapebrianonurba.equran.core.components.NavigationTopBar
import com.putrapebrianonurba.equran.features.prayer.presentation.PrayerCitiesViewModel
import com.putrapebrianonurba.equran.features.prayer.ui.components.cities.CitiesContent

@Composable
fun PrayerCitiesScreen(
    viewModel: PrayerCitiesViewModel,
    onNavigateBack: () -> Unit
) {
    // UI STATE
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    // CONTAINER
    Box(modifier = Modifier.fillMaxSize()) {
        // CONTENT
        CitiesContent(
            uiState = uiState,
            onSelectedCity = { city ->
                viewModel.onSelectedCity(city)
            }
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