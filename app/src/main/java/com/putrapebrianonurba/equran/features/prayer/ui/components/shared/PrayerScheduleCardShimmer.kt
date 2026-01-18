package com.putrapebrianonurba.equran.features.prayer.ui.components.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun PrayerScheduleCardShimmer() {
    val brush = shimmerEffect()

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(bottom = 6.dp),
        shape = RoundedCornerShape(12.dp),
        color = Color.Transparent
    ) {
        Box {

            // ICON PLACEHOLDER
            ShimmerItem(
                modifier = Modifier
                    .size(55.dp)
                    .align(Alignment.TopEnd)
                    .clip(RoundedCornerShape(28.dp)),
                brush = brush
            )

            // CONTENT
            Column(
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {

                // PRAY NAME
                ShimmerItem(
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .height(16.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    brush = brush
                )

                // PRAY TIME
                ShimmerItem(
                    modifier = Modifier
                        .fillMaxWidth(0.25f)
                        .height(22.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    brush = brush
                )
            }
        }
    }
}