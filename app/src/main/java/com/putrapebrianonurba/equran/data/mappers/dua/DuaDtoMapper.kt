package com.putrapebrianonurba.equran.data.mappers.dua

import com.putrapebrianonurba.equran.data.local.database.entity.dua.DuaEntity
import com.putrapebrianonurba.equran.data.remote.dto.dua.DuaDetailDto
import com.putrapebrianonurba.equran.data.remote.dto.dua.DuaDto

fun DuaDto.toEntity(): DuaEntity {
    return DuaEntity(
        id = id.toInt(),
        dua = dua,
        verse = null,
        latinName = null,
        meaning = null
    )
}

fun DuaDetailDto.toEntity(): DuaEntity {
    return DuaEntity(
        id = id.toInt(),
        dua = dua,
        verse = verse,
        latinName = latinName,
        meaning = meaning
    )
}
