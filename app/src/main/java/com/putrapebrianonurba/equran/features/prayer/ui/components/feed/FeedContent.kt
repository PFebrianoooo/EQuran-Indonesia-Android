package com.putrapebrianonurba.equran.features.prayer.ui.components.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.core.constants.AppConstants
import com.putrapebrianonurba.equran.features.prayer.presentation.PrayerUiState
import com.putrapebrianonurba.equran.features.prayer.ui.components.shared.PrayerScheduleCard
import com.putrapebrianonurba.equran.features.prayer.ui.components.shared.PrayerScheduleCardShimmer
import com.putrapebrianonurba.equran.features.quran.ui.components.shared.EmptySurah

@Composable
fun FeedContent(
    uiState: PrayerUiState,
    scrollState: LazyListState,
) {
    // CONTAINER
    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentPadding = PaddingValues(
            bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding() + 50.dp,
        )
    ) {
        // DATE INFORMATION
        item { FeedBanner() }

        // PRAYER SCHEDULE TITLE
        item { FeedScheduleTitle(title = AppConstants.PRAYER_PRAYER_SCHEDULE_TITLE) }

        // SCHEDULES
        when {
            uiState.prayersScheduleIsLoading -> { items(8) {  PrayerScheduleCardShimmer()} }
            uiState.prayersSchedule.isNotEmpty() -> {
                items(uiState.prayersSchedule) { schedule ->
                    PrayerScheduleCard(schedule)
                }
            }
            else -> { item { EmptySurah(AppConstants.PRAYER_EMPTY_SCHEDULE_TITLE) } }
        }
    }
}
