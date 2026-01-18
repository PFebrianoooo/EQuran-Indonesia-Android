package com.putrapebrianonurba.equran.features.prayer.presentation

import com.putrapebrianonurba.equran.domain.model.prayers.City
import com.putrapebrianonurba.equran.domain.model.prayers.PrayerScheduleItem

data class PrayerUiState(
    // CITIES
    val citiesIsLoading: Boolean = true,
    val cities: List<City> = emptyList(),

    // PRAYER SCHEDULE
    val selectedCityIsLoading: Boolean = true,
    val selectedCity: String = "",
    val prayersScheduleIsLoading: Boolean = true,
    val prayersSchedule: List<PrayerScheduleItem> = emptyList()
)
