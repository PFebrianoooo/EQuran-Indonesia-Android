package com.putrapebrianonurba.equran.features.quran.ui.components.detail.banner

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.R
import com.putrapebrianonurba.equran.features.quran.presentation.QuranUiState

@Composable
fun DetailSurahBanner(
    uiState: QuranUiState,
    onClick: () -> Unit
) {
    // CONTAINER
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp)
            .padding(bottom = 10.dp)
            .clip(RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ){
        // BACKGROUND
        Image(
            painterResource(R.drawable.ic_surah_background),
            contentDescription = R.drawable.ic_surah_background.toString(),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxWidth(),
        )

        when {
            uiState.detailIsLoading -> { BannerContentShimmer() }
            else -> {
                BannerContent(
                    surah = uiState.detailSurah,
                    isPlaying = uiState.detailAudioIsPlaying,
                    onClick = onClick
                )
            }
        }
    }
}