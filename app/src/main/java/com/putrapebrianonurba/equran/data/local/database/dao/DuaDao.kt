package com.putrapebrianonurba.equran.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.putrapebrianonurba.equran.data.local.database.entity.dua.DuaEntity

@Dao
interface DuaDao {
    // OPERATIONS
    // UPSERT OPERATIONS FOR DUA AND DUAS
    @Upsert
    suspend fun upsertDua(dua: DuaEntity)

    @Upsert
    suspend fun upsertDuas(duas: List<DuaEntity>)

    // GETTING ALL DUAS
    @Query("""SELECT * FROM dua ORDER BY id ASC""")
    suspend fun getDuas(): List<DuaEntity>

    // GETTING DUA BY ID
    @Query("""SELECT * FROM dua WHERE id = :id""")
    suspend fun getDuaById(id: Int): DuaEntity?

    // GETTING RANDOMIZE DUA
    @Query("""SELECT * FROM dua ORDER BY RANDOM() LIMIT 1""")
    suspend fun getRandomDua(): DuaEntity?
}