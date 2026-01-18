package com.putrapebrianonurba.equran.data.remote.dto.prayers

data class PrayerScheduleDto(
    val imsak: String,
    val subuh: String,
    val terbit: String,
    val dhuha: String,
    val dzuhur: String,
    val ashar: String,
    val maghrib: String,
    val isya: String,
    val date: String,
)
