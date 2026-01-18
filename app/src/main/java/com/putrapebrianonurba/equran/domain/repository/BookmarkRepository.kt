package com.putrapebrianonurba.equran.domain.repository

import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.domain.model.quran.Surah
import kotlinx.coroutines.flow.Flow

interface BookmarkRepository {
    suspend fun saveToBookmark(surahId: Int)
    fun getAllSurah(): Flow<Resource<List<Surah>>>
    suspend fun deleteSurahFromBookmark(surahId: Int)
    fun isSurahBookmarked(surahId: Int): Flow<Boolean>
}