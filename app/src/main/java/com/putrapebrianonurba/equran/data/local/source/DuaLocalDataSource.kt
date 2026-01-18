package com.putrapebrianonurba.equran.data.local.source

import com.putrapebrianonurba.equran.data.local.database.dao.DuaDao
import com.putrapebrianonurba.equran.data.local.database.entity.dua.DuaEntity
import javax.inject.Inject

class DuaLocalDataSource @Inject constructor(
    private val local: DuaDao
) {
    suspend fun upsertDua(dua: DuaEntity) {
        return local.upsertDua(dua)
    }

    suspend fun upsertDuas(duas: List<DuaEntity>) {
        return local.upsertDuas(duas)
    }

    suspend fun getDuas(): List<DuaEntity> {
        return local.getDuas()
    }

    suspend fun getDuaById(id: Int): DuaEntity? {
        return local.getDuaById(id)
    }

    suspend fun getRandomDua(): DuaEntity? {
        return local.getRandomDua()
    }
}