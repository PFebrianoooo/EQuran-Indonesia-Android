package com.putrapebrianonurba.equran.features.dua.presentation

import com.putrapebrianonurba.equran.domain.model.dua.Dua

data class DuaUiState(
    // DUAS
    val duasIsLoading: Boolean = true,
    val duas: List<Dua> = emptyList(),

    // DUA DETAIL
    val duaDetailIsLoading: Boolean = true,
    val duaDetail: Dua? = null,

    // DUA TEST
    val duaIsLoading: Boolean = true,
    val answerIsRevealed: Boolean = false,
    val dua: Dua? = null
)
