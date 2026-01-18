package com.putrapebrianonurba.equran.features.prayer.ui.components.cities

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
import com.putrapebrianonurba.equran.domain.model.prayers.City
import com.putrapebrianonurba.equran.features.prayer.presentation.PrayerUiState

@Composable
fun CitiesContent(
    uiState: PrayerUiState,
    onSelectedCity: (City) -> Unit
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
        // BANNER
        item { TextBanner(AppConstants.PRAYER_CITIES_BANNER_TITLE) }

        // CITIES
        when{
            uiState.citiesIsLoading -> { items(25) { CitiesItemShimmer() } }
            else -> {
                items(uiState.cities) { city ->
                    CitiesItem(
                        city = city,
                        selected = city.location == uiState.selectedCity,
                        onClick = { onSelectedCity(city) }
                    )
                }
            }
        }
    }
}