package com.putrapebrianonurba.equran.core.common

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

fun currentTime(): String {
    return formatNow("HH:mm")
}

fun currentDate(): String {
    return formatNow("yyyy-MM-dd")
}

fun currentFullDate(): String {
    return formatNow("EEEE, dd MMMM yyyy")
}

private fun formatNow(pattern: String): String {
    val locale = Locale.forLanguageTag("id-ID")

    return Instant.now()
        .atZone(ZoneId.systemDefault())
        .format(DateTimeFormatter.ofPattern(pattern, locale))
}
