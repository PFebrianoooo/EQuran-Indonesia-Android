package com.putrapebrianonurba.equran.domain.repository

import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.domain.model.quran.Search
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun saveHistory(keyword: String)
    suspend fun deleteKeyword(id: Int)
    fun getKeywords():  Flow<Resource<List<Search>>>
}