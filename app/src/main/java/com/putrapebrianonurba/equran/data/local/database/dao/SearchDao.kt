package com.putrapebrianonurba.equran.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.putrapebrianonurba.equran.data.local.database.entity.history.SearchEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKeyword(keyword: SearchEntity)

    @Query("SELECT * FROM search ORDER BY createdAt DESC LIMIT 5")
    fun getKeywords(): Flow<List<SearchEntity>>

    @Query("DELETE FROM search WHERE id = :id")
    suspend fun deleteKeyword(id: Int)
}