package com.putrapebrianonurba.equran.core.common

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

fun redirectOpenUrl(
    context: Context,
    url: String
) {
    if (url.isBlank()) return

    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
    context.startActivity(intent)
}