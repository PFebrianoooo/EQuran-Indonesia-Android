package com.putrapebrianonurba.equran.data.remote.dto.prayers

import com.google.gson.annotations.SerializedName

data class PrayersDto(
    val id: Int,
    @SerializedName("lokasi")
    val location: String,
    @SerializedName("daerah")
    val province: String,
    @SerializedName("jadwal")
    val schedule: PrayerScheduleDto
)
