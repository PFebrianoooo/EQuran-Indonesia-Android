package com.putrapebrianonurba.equran.data.mappers.history

import com.putrapebrianonurba.equran.data.local.database.entity.history.SearchEntity
import com.putrapebrianonurba.equran.domain.model.quran.Search

fun SearchEntity.toDomain(): Search {
    return Search(
        id = id,
        keyword = keyword
    )
}