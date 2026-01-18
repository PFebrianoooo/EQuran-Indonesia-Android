package com.putrapebrianonurba.equran.data.local.source

import com.putrapebrianonurba.equran.data.local.database.dao.SurahDao
import com.putrapebrianonurba.equran.data.local.database.entity.surah.AyahsEntity
import com.putrapebrianonurba.equran.data.local.database.entity.surah.SurahEntity
import com.putrapebrianonurba.equran.data.local.database.entity.surah.SurahWithAyahs
import javax.inject.Inject

class SurahLocalDataSource @Inject constructor(
    private val local: SurahDao
) {
    suspend fun upsertAllSurah(allSurah: List<SurahEntity>) {
        return local.upsertAllSurah(allSurah)
    }

    suspend fun upsertSurahWithAyahs(surah: SurahEntity, ayahs: List<AyahsEntity>){
        return local.upsertSurahWithAyahs(surah, ayahs)
    }

    suspend fun getAllSurah(): List<SurahEntity> {
        return local.getAllSurah()
    }

    suspend fun getSurahWithAyahsById(id: Int): SurahWithAyahs? {
        return local.getSurahWithAyahsById(id)
    }

    suspend fun getSurahByQuery(query: String): List<SurahEntity> {
        return local.getSurahByQuery(query)
    }
}