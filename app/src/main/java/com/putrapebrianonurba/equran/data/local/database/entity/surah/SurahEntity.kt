package com.putrapebrianonurba.equran.data.local.database.entity.surah

import androidx.room.Entity
import androidx.room.PrimaryKey

// SURAH ENTITY
@Entity(tableName = "surah")
data class SurahEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val latinName: String,
    val totalVerses: Long,
    val revelationPlace: String,
    val meaning: String? = null,
    val fullAudio: Map<String, String>? = null
)

