package com.putrapebrianonurba.equran.data.mappers.surah


import com.putrapebrianonurba.equran.data.local.database.entity.surah.AyahsEntity
import com.putrapebrianonurba.equran.data.local.database.entity.surah.SurahEntity
import com.putrapebrianonurba.equran.data.local.database.entity.surah.SurahWithAyahs
import com.putrapebrianonurba.equran.domain.model.quran.Ayah
import com.putrapebrianonurba.equran.domain.model.quran.Surah

// FROM ENTITY TO DOMAIN
fun SurahEntity.toDomain(): Surah {
    return Surah(
        id = id,
        name = name,
        latinName = latinName,
        totalVerses = totalVerses,
        revelationPlace = revelationPlace
    )
}

// FROM ENTITY TO DOMAIN
fun SurahWithAyahs.toDomain(): Surah {
    return Surah(
        id = surah.id,
        name = surah.name,
        latinName = surah.latinName,
        totalVerses = surah.totalVerses,
        revelationPlace = surah.revelationPlace,
        meaning = surah.meaning,
        fullAudio = surah.fullAudio,
        verses = ayahs.sortedBy { it.verseNumber }.map { it.toDomain() }
    )
}

// FROM ENTITY TO DOMAIN
private fun AyahsEntity.toDomain(): Ayah {
    return Ayah(
        verseNumber = verseNumber,
        arabicText = arabicText,
        latinText = latinText,
        translationText = translationText
    )
}



