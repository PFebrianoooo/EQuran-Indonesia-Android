package com.putrapebrianonurba.equran.data.remote.api

import com.putrapebrianonurba.equran.data.remote.dto.dua.DuaDetailDto
import com.putrapebrianonurba.equran.data.remote.dto.dua.DuaDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DuaApi {
    // GET ALL DUAS
    @GET("api")
    suspend fun getAllDuas(): List<DuaDto>

    // GET DUA BY ID
    @GET("api/{id}")
    suspend fun getDuaById(
        @Path("id") id: Int
    ): List<DuaDetailDto>
}