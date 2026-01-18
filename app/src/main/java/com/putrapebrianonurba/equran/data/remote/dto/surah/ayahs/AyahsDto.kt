package com.putrapebrianonurba.equran.data.remote.dto.surah.ayahs

import com.google.gson.annotations.SerializedName

data class AyahsDto(

    @SerializedName("nomorAyat")
    val verseNumber: Int,

    @SerializedName("teksArab")
    val arabicText: String,

    @SerializedName("teksLatin")
    val latinText: String,

    @SerializedName("teksIndonesia")
    val translationText: String,
)
