package com.putrapebrianonurba.equran.data.remote.dto.prayers

import com.google.gson.annotations.SerializedName

data class CitiesDto(
    val id: String,
    @SerializedName("lokasi")
    val location: String,
)
