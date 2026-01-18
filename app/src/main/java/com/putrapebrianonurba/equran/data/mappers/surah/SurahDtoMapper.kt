package com.putrapebrianonurba.equran.data.mappers.surah

import com.putrapebrianonurba.equran.data.local.database.entity.surah.AyahsEntity
import com.putrapebrianonurba.equran.data.local.database.entity.surah.SurahEntity
import com.putrapebrianonurba.equran.data.remote.dto.surah.SurahDetailDto
import com.putrapebrianonurba.equran.data.remote.dto.surah.SurahDto


// FROM DTO TO ENTITY
fun SurahDto.toEntity(): SurahEntity {
    return SurahEntity(
        id = id,
        name = name,
        latinName = latinName,
        totalVerses = totalVerses,
        revelationPlace = revelationPlace
    )
}

// FROM DTO TO ENTITY
fun SurahDetailDto.toEntity(): SurahEntity {
    return SurahEntity(
        id = id,
        name = name,
        latinName = latinName,
        totalVerses = totalVerses,
        revelationPlace = revelationPlace,
        meaning = meaning,
        fullAudio = fullAudio
    )
}

// FROM DTO TO DOMAIN
fun SurahDetailDto.toAyahEntity(): List<AyahsEntity> {
    return verses.map {
        AyahsEntity(
            verseNumber = it.verseNumber,
            arabicText = it.arabicText,
            latinText = it.latinText,
            translationText = it.translationText,
            surahId = this.id
        )
    }
}
