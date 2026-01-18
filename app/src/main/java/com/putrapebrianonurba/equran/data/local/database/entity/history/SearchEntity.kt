package com.putrapebrianonurba.equran.data.local.database.entity.history

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search")
data class SearchEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val keyword: String,
    val createdAt: Long = System.currentTimeMillis()
)
