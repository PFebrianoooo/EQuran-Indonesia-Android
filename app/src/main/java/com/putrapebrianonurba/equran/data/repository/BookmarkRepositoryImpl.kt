package com.putrapebrianonurba.equran.data.repository

import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.data.local.database.entity.surah.BookmarkEntity
import com.putrapebrianonurba.equran.data.local.source.BookmarkLocalDataSource
import com.putrapebrianonurba.equran.data.mappers.surah.toDomain
import com.putrapebrianonurba.equran.domain.model.quran.Surah
import com.putrapebrianonurba.equran.domain.repository.BookmarkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
    private val localSource: BookmarkLocalDataSource
): BookmarkRepository{
    override suspend fun saveToBookmark(surahId: Int) {
        localSource.insertSurahToBookmark(
            bookmark = BookmarkEntity(
                surahId = surahId
            )
        )
    }

    override fun getAllSurah(): Flow<Resource<List<Surah>>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                localSource.getAllBookmarksWithSurah().collect { list ->
                    emit(Resource.Success(
                        data = list.map { it.toDomain() })
                    )
                }
                emit(Resource.Loading(false))
            } catch (e: Exception) {
                emit(Resource.Error(  e.localizedMessage ?:"Error Getting Wishlist Data" ))
            }
        }
    }

    override suspend fun deleteSurahFromBookmark(surahId: Int) {
        localSource.deleteSurahFromBookmark(surahId)
    }

    override fun isSurahBookmarked(surahId: Int): Flow<Boolean> {
        return localSource.isSurahBookmarked(surahId)
    }

}