package com.putrapebrianonurba.equran.data.mappers.dua

import com.putrapebrianonurba.equran.data.local.database.entity.dua.DuaEntity
import com.putrapebrianonurba.equran.domain.model.dua.Dua

fun DuaEntity.toDomain(): Dua {
    return Dua(
        id = id,
        dua = dua,
        verse = verse,
        latinName = latinName,
        meaning = meaning
    )
}

fun DuaEntity.isFull(): Boolean {
    return verse != null && latinName != null && meaning != null
}