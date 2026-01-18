package com.putrapebrianonurba.equran.data.mappers.prayers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.FilterDrama
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.NightlightRound
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.filled.WbTwilight
import com.putrapebrianonurba.equran.data.local.database.entity.prayers.CitiesEntity
import com.putrapebrianonurba.equran.data.local.database.entity.prayers.PrayerScheduleEntity
import com.putrapebrianonurba.equran.domain.model.prayers.City
import com.putrapebrianonurba.equran.domain.model.prayers.PrayerSchedule
import com.putrapebrianonurba.equran.domain.model.prayers.PrayerScheduleItem

fun CitiesEntity.toDomain(): City {
    return City(
        id = id,
        location = location
    )
}

fun PrayerScheduleEntity.toDomain(): PrayerSchedule {
    return PrayerSchedule(
        imsak = imsak,
        subuh = subuh,
        terbit = terbit,
        dhuha = dhuha,
        dzuhur = dzuhur,
        ashar = ashar,
        maghrib = maghrib,
        isya = isya
    )
}

fun PrayerSchedule.toList(): List<PrayerScheduleItem> {
    return listOf(
        PrayerScheduleItem(Icons.Filled.Bedtime, "Imsak", imsak),
        PrayerScheduleItem(Icons.Filled.WbTwilight, "Subuh", subuh),
        PrayerScheduleItem(Icons.Filled.LightMode, "Terbit", terbit),
        PrayerScheduleItem(Icons.Filled.WbSunny, "Dhuha", dhuha),
        PrayerScheduleItem(Icons.Filled.WbSunny, "Dzuhur", dzuhur),
        PrayerScheduleItem(Icons.Filled.FilterDrama, "Ashar", ashar),
        PrayerScheduleItem(Icons.Filled.WbTwilight, "Maghrib", maghrib),
        PrayerScheduleItem(Icons.Filled.NightlightRound, "Isya", isya)
    )
}
