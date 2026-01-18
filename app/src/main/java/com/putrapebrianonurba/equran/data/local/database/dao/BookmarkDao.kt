package com.putrapebrianonurba.equran.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.putrapebrianonurba.equran.data.local.database.entity.surah.BookmarkEntity
import com.putrapebrianonurba.equran.data.local.database.entity.surah.SurahEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {
    // OPERATIONS
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSurahToBookmark(bookmark: BookmarkEntity)

    @Query("DELETE FROM bookmark WHERE surahId = :surahId")
    suspend fun deleteSurahFromBookmark(surahId: Int)

    @Query("""
       SELECT s.* FROM surah s
        INNER JOIN bookmark b ON s.id = b.surahId
        ORDER BY b.createdAt DESC 
    """)
    fun getAllBookmarksWithSurah(): Flow<List<SurahEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM bookmark WHERE surahId = :surahId)")
    fun isSurahBookmarked(surahId: Int): Flow<Boolean>
}