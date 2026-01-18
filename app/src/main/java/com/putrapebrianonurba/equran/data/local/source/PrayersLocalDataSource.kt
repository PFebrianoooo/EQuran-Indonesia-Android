package com.putrapebrianonurba.equran.data.local.source

import com.putrapebrianonurba.equran.data.local.database.dao.PrayersDao
import com.putrapebrianonurba.equran.data.local.database.entity.prayers.CitiesEntity
import com.putrapebrianonurba.equran.data.local.database.entity.prayers.PrayerScheduleEntity
import javax.inject.Inject

class PrayersLocalDataSource @Inject constructor(
    private val local: PrayersDao
) {
    suspend fun upsertCities(cities: List<CitiesEntity>) {
        return local.upsertCities(cities)
    }

    suspend fun getCities(): List<CitiesEntity> {
        return local.getCities()
    }

    suspend fun getCityById(cityId: Int): CitiesEntity? {
        return local.getCityById(cityId)
    }

    suspend fun upsertPrayerSchedule(schedule: PrayerScheduleEntity) {
        return local.upsertPrayerSchedule(schedule)
    }

    suspend fun getSchedule(
        cityId: Int,
        date: String
    ): PrayerScheduleEntity? {
        return local.getSchedule(cityId, date)
    }

    suspend fun deleteOldPrayerSchedule(today: String) {
        return local.deleteOldPrayerSchedule(today)
    }
}