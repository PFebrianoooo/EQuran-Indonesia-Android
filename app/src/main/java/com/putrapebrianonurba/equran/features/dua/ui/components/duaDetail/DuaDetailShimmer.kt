package com.putrapebrianonurba.equran.features.dua.ui.components.duaDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.core.components.ShimmerItem
import com.putrapebrianonurba.equran.core.components.shimmerEffect

@Composable
fun DuaDetailShimmer() {
    val brush = shimmerEffect()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 14.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                ShimmerItem(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(32.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    brush = brush
                )
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                ShimmerItem(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(32.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    brush = brush
                )
            }


            ShimmerItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(18.dp)
                    .clip(RoundedCornerShape(6.dp)),
                brush = brush
            )


            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {

                ShimmerItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(18.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    brush = brush
                )

                ShimmerItem(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(18.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    brush = brush
                )
            }
        }
    }
}
