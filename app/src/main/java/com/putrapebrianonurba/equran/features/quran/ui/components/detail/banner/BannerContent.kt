package com.putrapebrianonurba.equran.features.quran.ui.components.detail.banner

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.R
import com.putrapebrianonurba.equran.domain.model.quran.Surah

@Composable
fun BannerContent(
    surah: Surah?,
    isPlaying: Boolean,
    onClick: () -> Unit
) {
    // CONTENTS
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // SURAH INFORMATION
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = surah?.latinName.orEmpty(),
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )

            Text(
                text = surah?.meaning.orEmpty(),
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
            HorizontalDivider(
                thickness = 1.dp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 5.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Text(
                    text = surah?.revelationPlace.orEmpty(),
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White
                )

                Text(
                    text = "• ${surah?.totalVerses} Ayat",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = onClick)
            ) {
                Icon(
                    imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(22.dp)
                )

                Text(
                    text = if (isPlaying) "Pause Murrotal" else  "Play Murrotal",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White
                )
            }
        }

        // BASMALLAH ICON
        Image(
            painterResource(R.drawable.ic_surah_basmallah),
            contentDescription = R.drawable.ic_surah_basmallah.toString(),
            colorFilter = ColorFilter.tint(Color.White)
        )
    }
}