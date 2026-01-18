package com.putrapebrianonurba.equran.features.quran.ui.components.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.core.components.ShimmerItem
import com.putrapebrianonurba.equran.core.components.shimmerEffect

@Composable
fun DetailAyahCardShimmer() {
    val brush = shimmerEffect()

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.Transparent,
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                // ORNAMENT NUMBER
                ShimmerItem(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    brush = brush
                )

                // ARABIC TEXT SHIMMER
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    ShimmerItem(
                        modifier = Modifier
                            .fillMaxWidth(0.95f)
                            .height(22.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        brush = brush
                    )

                    ShimmerItem(
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .height(22.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        brush = brush
                    )
                }

                // LATIN (TRANSLITERATION) SHIMMER
                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    ShimmerItem(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(16.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        brush = brush
                    )

                    ShimmerItem(
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .height(16.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        brush = brush
                    )
                }

                // TRANSLATION TEXT SHIMMER
                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    ShimmerItem(
                        modifier = Modifier
                            .fillMaxWidth(0.95f)
                            .height(16.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        brush = brush
                    )

                    ShimmerItem(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(16.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        brush = brush
                    )

                    ShimmerItem(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(16.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        brush = brush
                    )
                }
            }

            // REAL DIVIDER
            HorizontalDivider(
                thickness = 0.25.dp,
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}
