package com.putrapebrianonurba.equran.features.quran.ui.components.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
fun SurahCardShimmer() {
    val brush = shimmerEffect()

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.Transparent
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // LEFT CONTENT
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {

                    // ORNAMENT NUMBER SHIMMER
                    ShimmerItem(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(RoundedCornerShape(15.dp)),
                        brush = brush
                    )

                    // SURAH INFORMATION SHIMMER
                    Column(
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {

                        // Latin name
                        ShimmerItem(
                            modifier = Modifier
                                .fillMaxWidth(0.65f)
                                .height(14.dp)
                                .clip(RoundedCornerShape(6.dp)),
                            brush = brush
                        )

                        // REVELATION PLACE & AYAHS COUNT
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ShimmerItem(
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(12.dp)
                                    .clip(RoundedCornerShape(6.dp)),
                                brush = brush
                            )

                            ShimmerItem(
                                modifier = Modifier
                                    .width(60.dp)
                                    .height(12.dp)
                                    .clip(RoundedCornerShape(6.dp)),
                                brush = brush
                            )
                        }
                    }
                }

                // RIGHT CONTENT (ARABIC NAME)
                ShimmerItem(
                    modifier = Modifier
                        .width(50.dp)
                        .height(24.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    brush = brush
                )
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
