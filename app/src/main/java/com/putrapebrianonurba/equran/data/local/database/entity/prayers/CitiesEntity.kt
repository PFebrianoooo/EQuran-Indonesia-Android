package com.putrapebrianonurba.equran.data.local.database.entity.prayers

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
data class CitiesEntity(
    @PrimaryKey
    val id: Int,
    val location: String
)
