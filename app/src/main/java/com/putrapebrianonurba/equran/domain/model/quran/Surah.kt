package com.putrapebrianonurba.equran.domain.model.quran

data class Surah(
    val id: Int,
    val name: String,
    val latinName: String,
    val totalVerses: Long,
    val revelationPlace: String,
    val meaning: String? = null,
    val fullAudio: Map<String, String>? = null,
    val verses: List<Ayah>? = null,
)