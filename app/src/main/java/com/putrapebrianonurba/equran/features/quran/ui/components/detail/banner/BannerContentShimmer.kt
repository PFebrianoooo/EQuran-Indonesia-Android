package com.putrapebrianonurba.equran.features.quran.ui.components.detail.banner

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.core.components.ShimmerItem
import com.putrapebrianonurba.equran.core.components.shimmerEffect

@Composable
fun BannerContentShimmer() {
    val brush = shimmerEffect()

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // SURAH INFORMATION
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            // SURAH LATIN NAME
            ShimmerItem(
                modifier = Modifier
                    .fillMaxWidth(0.45f)
                    .height(18.dp)
                    .clip(RoundedCornerShape(6.dp)),
                brush = brush
            )

            // MEANING
            ShimmerItem(
                modifier = Modifier
                    .fillMaxWidth(0.35f)
                    .height(16.dp)
                    .clip(RoundedCornerShape(6.dp)),
                brush = brush
            )

            HorizontalDivider(
                thickness = 1.dp,
                color = Color.White.copy(alpha = 0.5f),
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 5.dp)
            )
        }

        // META INFORMATION
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            // REVELATION PLACE & AYAHS COUNT
            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ShimmerItem(
                    modifier = Modifier
                        .width(80.dp)
                        .height(14.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    brush = brush
                )

                ShimmerItem(
                    modifier = Modifier
                        .width(70.dp)
                        .height(14.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    brush = brush
                )
            }

            // PLAY MURROTAL
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ShimmerItem(
                    modifier = Modifier
                        .size(22.dp)
                        .clip(RoundedCornerShape(11.dp)),
                    brush = brush
                )

                ShimmerItem(
                    modifier = Modifier
                        .width(90.dp)
                        .height(14.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    brush = brush
                )
            }
        }

        // BASMALLAH ICON SHIMMER
        ShimmerItem(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(56.dp)
                .clip(RoundedCornerShape(8.dp)),
            brush = brush
        )
    }
}
