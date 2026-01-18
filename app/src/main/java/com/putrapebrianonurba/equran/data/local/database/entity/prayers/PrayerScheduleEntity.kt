package com.putrapebrianonurba.equran.data.local.database.entity.prayers

import androidx.room.Entity

@Entity(
    tableName = "prayer_schedule",
    primaryKeys = ["cityId", "date"]
)
data class PrayerScheduleEntity(
    val cityId: Int,
    val date: String,
    val imsak: String,
    val subuh: String,
    val terbit: String,
    val dhuha: String,
    val dzuhur: String,
    val ashar: String,
    val maghrib: String,
    val isya: String,
    val lastUpdated: Long
)

