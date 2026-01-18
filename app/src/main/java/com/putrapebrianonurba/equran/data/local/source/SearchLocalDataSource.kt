package com.putrapebrianonurba.equran.data.local.source

import com.putrapebrianonurba.equran.data.local.database.dao.SearchDao
import com.putrapebrianonurba.equran.data.local.database.entity.history.SearchEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchLocalDataSource @Inject constructor(
    private val local: SearchDao
) {
    suspend fun insertKeyword(keyword: SearchEntity) {
        return local.insertKeyword(keyword)
    }

    suspend fun deleteKeyword(id: Int) {
        return local.deleteKeyword(id)
    }

    fun getKeywords(): Flow<List<SearchEntity>> {
        return local.getKeywords()
    }
}