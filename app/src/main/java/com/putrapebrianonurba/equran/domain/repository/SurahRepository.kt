package com.putrapebrianonurba.equran.domain.repository

import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.domain.model.quran.Surah
import kotlinx.coroutines.flow.Flow

interface SurahRepository {
    suspend fun getAllSurah(): Flow<Resource<List<Surah>>>
    suspend fun getSurahById(id: Int): Flow<Resource<Surah>>
    suspend fun getSurahByQuery(query: String): Flow<Resource<List<Surah>>>
}