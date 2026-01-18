package com.putrapebrianonurba.equran.data.remote.dto.surah

import com.google.gson.annotations.SerializedName

data class SurahDto(
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
)
