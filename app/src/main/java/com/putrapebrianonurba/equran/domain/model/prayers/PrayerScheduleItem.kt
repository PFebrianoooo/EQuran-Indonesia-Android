package com.putrapebrianonurba.equran.domain.model.prayers

import androidx.compose.ui.graphics.vector.ImageVector

data class PrayerScheduleItem(
    val icon: ImageVector,
    val prayName: String,
    val prayTime: String
)