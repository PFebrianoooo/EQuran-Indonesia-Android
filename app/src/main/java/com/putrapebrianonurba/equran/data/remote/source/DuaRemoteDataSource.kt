package com.putrapebrianonurba.equran.data.remote.source

import com.putrapebrianonurba.equran.data.remote.api.DuaApi
import com.putrapebrianonurba.equran.data.remote.dto.dua.DuaDetailDto
import com.putrapebrianonurba.equran.data.remote.dto.dua.DuaDto
import javax.inject.Inject

class DuaRemoteDataSource @Inject constructor(
    private val api: DuaApi
) {
    suspend fun fetchAllDuas(): List<DuaDto> {
        return api.getAllDuas()
    }

    suspend fun fetchDuaById(id: Int): List<DuaDetailDto> {
        return api.getDuaById(id)
    }
}