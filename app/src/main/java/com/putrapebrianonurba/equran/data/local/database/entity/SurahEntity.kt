package com.putrapebrianonurba.equran.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.putrapebrianonurba.equran.data.converters.SurahConverters

@Entity(tableName = "surah")
@TypeConverters(SurahConverters::class)
data class SurahEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val latinName: String,
    val totalVerses: Long,
    val revelationPlace: String,
    val meaning: String? = null,
    val fullAudio: String? = null,
    val verses: String? = null
)
