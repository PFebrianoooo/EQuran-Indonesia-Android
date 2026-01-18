package com.putrapebrianonurba.equran.data.local.source

import com.putrapebrianonurba.equran.data.local.database.dao.BookmarkDao
import com.putrapebrianonurba.equran.data.local.database.entity.surah.BookmarkEntity
import com.putrapebrianonurba.equran.data.local.database.entity.surah.SurahEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookmarkLocalDataSource @Inject constructor(
    private val local: BookmarkDao
) {
    suspend fun insertSurahToBookmark(bookmark: BookmarkEntity) {
        return local.insertSurahToBookmark(bookmark)
    }

    suspend fun deleteSurahFromBookmark(surahId: Int) {
        return local.deleteSurahFromBookmark(surahId)
    }

    fun getAllBookmarksWithSurah(): Flow<List<SurahEntity>> {
        return local.getAllBookmarksWithSurah()
    }

    fun isSurahBookmarked(surahId: Int): Flow<Boolean> {
        return local.isSurahBookmarked(surahId)
    }
}