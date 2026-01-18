package com.putrapebrianonurba.equran.domain.repository

import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.domain.model.prayers.City
import com.putrapebrianonurba.equran.domain.model.prayers.PrayerSchedule
import kotlinx.coroutines.flow.Flow

interface PrayerRepository {
    suspend fun getCities(): Flow<Resource<List<City>>>
    suspend fun getCityById(cityId: Int): Flow<Resource<City>>
    suspend fun getPrayerSchedule(cityId: Int): Flow<Resource<PrayerSchedule>>
}