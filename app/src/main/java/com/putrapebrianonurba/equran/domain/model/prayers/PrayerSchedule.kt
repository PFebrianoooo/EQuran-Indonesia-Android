package com.putrapebrianonurba.equran.domain.model.prayers

data class PrayerSchedule(
    val imsak: String,
    val subuh: String,
    val terbit: String,
    val dhuha: String,
    val dzuhur: String,
    val ashar: String,
    val maghrib: String,
    val isya: String
)

