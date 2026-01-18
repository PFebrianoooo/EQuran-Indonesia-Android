package com.putrapebrianonurba.equran.domain.model.dua

data class Dua(
    val id: Int,
    val dua: String,
    val verse: String?,
    val latinName: String?,
    val meaning: String?
)