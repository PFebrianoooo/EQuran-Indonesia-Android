package com.putrapebrianonurba.equran.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dua")
data class DuaEntity(
    @PrimaryKey
    val id: String,
    val dua: String,
    val verse: String?,
    val latinName: String?,
    val meaning: String?
)
