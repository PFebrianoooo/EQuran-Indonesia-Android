package com.putrapebrianonurba.equran.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.R

@Composable
fun SurahBanner() {
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
                    text = "An-Nasr",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )

                Text(
                    text = "Pertolongan",
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
                        text = "Madinah",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.White
                    )

                    Text(
                        text = "• 7 Ayat",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.White
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(22.dp)
                    )

                    Text(
                        text = "Play Murrotal",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.White
                    )
                }
            }

            // BASMALLAH ICON
            Image(
                painterResource(R.drawable.ic_surah_basmallah),
                contentDescription = "basmallah_icon",
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }
}