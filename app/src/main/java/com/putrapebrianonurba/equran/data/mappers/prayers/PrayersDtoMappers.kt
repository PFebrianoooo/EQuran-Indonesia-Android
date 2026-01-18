package com.putrapebrianonurba.equran.data.mappers.prayers

import com.putrapebrianonurba.equran.core.common.titleCase
import com.putrapebrianonurba.equran.data.local.database.entity.prayers.CitiesEntity
import com.putrapebrianonurba.equran.data.local.database.entity.prayers.PrayerScheduleEntity
import com.putrapebrianonurba.equran.data.remote.dto.prayers.CitiesDto
import com.putrapebrianonurba.equran.data.remote.dto.prayers.PrayerScheduleDto

fun CitiesDto.toEntity(): CitiesEntity {
    return CitiesEntity(
        id = id.toInt(),
        location = location.titleCase()
    )
}

fun PrayerScheduleDto.toEntity(cityId: Int): PrayerScheduleEntity {
    return PrayerScheduleEntity(
        cityId = cityId,
        date = date,
        imsak = imsak,
        subuh = subuh,
        terbit = terbit,
        dhuha = dhuha,
        dzuhur = dzuhur,
        ashar = ashar,
        maghrib = maghrib,
        isya = isya,
        lastUpdated = System.currentTimeMillis()
    )
}


