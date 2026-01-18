package com.putrapebrianonurba.equran.data.remote.dto.prayers

data class PrayersResponseDto<T>(
    val status: Boolean,
    val data: T
)
