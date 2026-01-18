package com.putrapebrianonurba.equran.data.remote.source

import com.putrapebrianonurba.equran.data.remote.api.SurahApi
import com.putrapebrianonurba.equran.data.remote.dto.surah.SurahDetailDto
import com.putrapebrianonurba.equran.data.remote.dto.surah.SurahDto
import com.putrapebrianonurba.equran.data.remote.dto.surah.SurahResponseDto
import javax.inject.Inject

class SurahRemoteDataSource @Inject constructor(
    private val api: SurahApi
) {
    // FETCH ALL SURAH FROM API
    suspend fun fetchAllSurah(): SurahResponseDto<List<SurahDto>> {
        return api.getAllSurah()
    }

    // FETCH SURAH BY ID FROM API
    suspend fun fetchSurahById(id: Int): SurahResponseDto<SurahDetailDto> {
        return api.getSurahById(id)
    }
}