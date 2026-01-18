package com.putrapebrianonurba.equran.data.local.database.entity.surah

import androidx.room.Embedded
import androidx.room.Relation

data class SurahWithAyahs(
    @Embedded val surah: SurahEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "surahId"
    )
    val ayahs: List<AyahsEntity>
)
