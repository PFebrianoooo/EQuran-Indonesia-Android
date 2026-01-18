package com.putrapebrianonurba.equran.data.local.database.entity.surah

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

// AYAHS ENTITY
@Entity(
    tableName = "ayah",
    foreignKeys = [
        ForeignKey(
            entity = SurahEntity::class,
            parentColumns = ["id"],
            childColumns = ["surahId"],
            onDelete = ForeignKey.Companion.CASCADE,
        )
    ],
    indices = [Index("surahId")]
)
data class AyahsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val verseNumber: Int,
    val arabicText: String,
    val latinText: String,
    val translationText: String,
    val surahId: Int,
)