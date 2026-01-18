package com.putrapebrianonurba.equran.core.common

import java.util.Locale

fun String?.orEmpty() = this ?: ""

fun String.sentenceCase(): String = lowercase(Locale.getDefault()).replaceFirstChar { it.titlecase(Locale.getDefault()) }

fun String.titleCase(): String =
    lowercase(Locale.getDefault())
        .split(" ")
        .joinToString(" ") { word ->
            word.replaceFirstChar { it.titlecase(Locale.getDefault()) }
        }