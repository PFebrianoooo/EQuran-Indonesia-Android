package com.putrapebrianonurba.equran.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.putrapebrianonurba.equran.data.local.database.entity.prayers.CitiesEntity
import com.putrapebrianonurba.equran.data.local.database.entity.prayers.PrayerScheduleEntity

@Dao
interface PrayersDao {
    @Upsert
    suspend fun upsertCities(cities: List<CitiesEntity>)

    @Query("SELECT * FROM cities ORDER BY location ASC")
    suspend fun getCities(): List<CitiesEntity>

    @Query("SELECT * FROM cities WHERE id = :cityId")
    suspend fun getCityById(cityId: Int): CitiesEntity?

    @Query("""
        SELECT * FROM prayer_schedule
        WHERE cityId = :cityId AND date = :date
        LIMIT 1
    """)
    suspend fun getSchedule(
        cityId: Int,
        date: String
    ): PrayerScheduleEntity?

    @Upsert
    suspend fun upsertPrayerSchedule(schedule: PrayerScheduleEntity)

    @Query("DELETE FROM prayer_schedule WHERE date < :today")
    suspend fun deleteOldPrayerSchedule(today: String)
}