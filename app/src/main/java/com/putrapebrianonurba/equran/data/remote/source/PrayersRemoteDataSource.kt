package com.putrapebrianonurba.equran.data.remote.source

import com.putrapebrianonurba.equran.data.remote.api.PrayersApi
import com.putrapebrianonurba.equran.data.remote.dto.prayers.CitiesDto
import com.putrapebrianonurba.equran.data.remote.dto.prayers.PrayersDto
import com.putrapebrianonurba.equran.data.remote.dto.prayers.PrayersResponseDto
import javax.inject.Inject

class PrayersRemoteDataSource @Inject constructor(
    private val api: PrayersApi
) {
    suspend fun getAllCities(): PrayersResponseDto<List<CitiesDto>> {
        return api.getAllCities()
    }

    suspend fun getCityById(cityId: Int): PrayersResponseDto<CitiesDto> {
        return api.getCityById(cityId)
    }

    suspend fun getPrayersSchedule(cityId: Int, date: String): PrayersResponseDto<PrayersDto> {
        return api.getPrayerSchedule(cityId, date)
    }
}