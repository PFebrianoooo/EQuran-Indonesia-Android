package com.putrapebrianonurba.equran.domain.repository

import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.domain.model.dua.Dua
import kotlinx.coroutines.flow.Flow

interface DuaRepository {
    suspend fun getDuas(): Flow<Resource<List<Dua>>>
    suspend fun getDuaById(id: Int): Flow<Resource<Dua>>
    suspend fun getRandomDua(): Flow<Resource<Dua>>
}