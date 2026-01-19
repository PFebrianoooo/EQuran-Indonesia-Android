package com.putrapebrianonurba.equran.data.remote.api

import com.putrapebrianonurba.equran.data.remote.dto.surah.SurahDetailDto
import com.putrapebrianonurba.equran.data.remote.dto.surah.SurahDto
import com.putrapebrianonurba.equran.data.remote.dto.surah.SurahResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface QuranApi {
    // GET ALL SURAH
    @GET("surat")
    suspend fun getAllSurah(): SurahResponseDto<List<SurahDto>>

    // GET SURAH BY ID
    @GET("surat/{id}")
    suspend fun getSurahById(
        @Path("id") id: Int
    ): SurahResponseDto<SurahDetailDto>
}