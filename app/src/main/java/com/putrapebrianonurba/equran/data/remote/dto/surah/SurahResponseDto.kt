package com.putrapebrianonurba.equran.data.remote.dto.surah

data class SurahResponseDto<T>(
    val code: Long,
    val message: String,
    val data: T
)