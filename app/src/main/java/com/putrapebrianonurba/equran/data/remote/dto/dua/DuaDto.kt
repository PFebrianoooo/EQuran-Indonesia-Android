package com.putrapebrianonurba.equran.data.remote.dto.dua

import com.google.gson.annotations.SerializedName

data class DuaDto(
    val id: String,

    @SerializedName("doa")
    val dua: String,
)
