package com.putrapebrianonurba.equran.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.putrapebrianonurba.equran.data.local.database.entity.surah.AyahsEntity
import com.putrapebrianonurba.equran.data.local.database.entity.surah.SurahEntity
import com.putrapebrianonurba.equran.data.local.database.entity.surah.SurahWithAyahs

@Dao
interface SurahDao {
    // OPERATIONS
    @Upsert
    suspend fun upsertSurah(surah: SurahEntity) // INTERNAL USED

    @Upsert
    suspend fun upsertAllSurah(allSurah: List<SurahEntity>)

    @Upsert
    suspend fun upsertAyahs(ayahs: List<AyahsEntity>) // INTERNAL USED

    @Transaction
    suspend fun upsertSurahWithAyahs(surah: SurahEntity, ayahs: List<AyahsEntity>) {
        upsertSurah(surah)
        upsertAyahs(ayahs)
    }

    @Query("SELECT * FROM surah ORDER BY id ASC")
    suspend fun getAllSurah(): List<SurahEntity>

    @Transaction
    @Query("SELECT * FROM surah WHERE id = :id")
    suspend fun getSurahWithAyahsById(id: Int): SurahWithAyahs?

    @Query("""
    SELECT * FROM surah
    WHERE LOWER(REPLACE(latinName, '-', ' '))
    LIKE '%' || :query || '%'
    """)
    suspend fun getSurahByQuery(query: String): List<SurahEntity>

}