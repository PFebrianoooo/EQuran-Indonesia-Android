package com.putrapebrianonurba.equran.features.prayer.ui.components.cities

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.core.components.ShimmerItem
import com.putrapebrianonurba.equran.core.components.shimmerEffect

@Composable
fun CitiesItemShimmer() {
    val brush = shimmerEffect()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // TEXT SHIMMER
        ShimmerItem(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(17.dp)
                .clip(RoundedCornerShape(5.dp)),
            brush = brush
        )

        // RADIO SHIMMER
        ShimmerItem(
            modifier = Modifier
                .size(12.dp)
                .clip(RoundedCornerShape(5.dp)),
            brush = brush
        )
    }
}