package com.putrapebrianonurba.equran.data.repository

import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.data.local.database.entity.history.SearchEntity
import com.putrapebrianonurba.equran.data.local.source.SearchLocalDataSource
import com.putrapebrianonurba.equran.data.mappers.history.toDomain
import com.putrapebrianonurba.equran.domain.model.quran.Search
import com.putrapebrianonurba.equran.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val localSource: SearchLocalDataSource
): SearchRepository {
    override suspend fun saveHistory(keyword: String) {
        localSource.insertKeyword(SearchEntity(keyword = keyword))
    }

    override suspend fun deleteKeyword(id: Int) {
        localSource.deleteKeyword(id)
    }

    override fun getKeywords(): Flow<Resource<List<Search>>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                localSource.getKeywords().collect { list ->
                    emit(Resource.Success(
                        data = list.map { it.toDomain() }
                    ))
                }
                emit(Resource.Loading(false))

            } catch (e: Exception) {
                emit(Resource.Error(  e.localizedMessage ?:"Error Getting History Data" ))
            }
        }
    }

}