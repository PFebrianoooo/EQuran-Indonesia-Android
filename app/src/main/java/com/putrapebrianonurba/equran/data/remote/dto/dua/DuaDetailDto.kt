package com.putrapebrianonurba.equran.data.remote.dto.dua

import com.google.gson.annotations.SerializedName

data class DuaDetailDto(
    val id: String,

    @SerializedName("doa")
    val dua: String,

    @SerializedName("ayat")
    val verse: String,

    @SerializedName("latin")
    val latinName: String,

    @SerializedName("artinya")
    val meaning: String
)
