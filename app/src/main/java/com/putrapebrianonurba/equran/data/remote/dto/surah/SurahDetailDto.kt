package com.putrapebrianonurba.equran.data.remote.dto.surah

import com.google.gson.annotations.SerializedName
import com.putrapebrianonurba.equran.data.remote.dto.surah.ayahs.AyahsDto

data class SurahDetailDto(
    @SerializedName("nomor")
    val id: Int,

    @SerializedName("nama")
    val name: String,

    @SerializedName("namaLatin")
    val latinName: String,

    @SerializedName("jumlahAyat")
    val totalVerses: Long,

    @SerializedName("tempatTurun")
    val revelationPlace: String,

    @SerializedName("arti")
    val meaning: String,

    @SerializedName("audioFull")
    val fullAudio: Map<String, String>,

    @SerializedName("ayat")
    val verses: List<AyahsDto>,
)
