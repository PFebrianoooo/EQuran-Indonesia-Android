package com.putrapebrianonurba.equran.data.remote.api

import com.putrapebrianonurba.equran.data.remote.dto.prayers.CitiesDto
import com.putrapebrianonurba.equran.data.remote.dto.prayers.PrayersDto
import com.putrapebrianonurba.equran.data.remote.dto.prayers.PrayersResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PrayersApi {
    @GET("sholat/kota/semua")
    suspend fun getAllCities(): PrayersResponseDto<List<CitiesDto>>

    @GET("sholat/kota/{cityId}")
    suspend fun getCityById(
        @Path("cityId") cityId: Int
    ): PrayersResponseDto<CitiesDto>

    @GET("sholat/jadwal/{kota}/{date}")
    suspend fun getPrayerSchedule(
        @Path("kota") cityId: Int,
        @Path("date") date: String
    ): PrayersResponseDto<PrayersDto>
}