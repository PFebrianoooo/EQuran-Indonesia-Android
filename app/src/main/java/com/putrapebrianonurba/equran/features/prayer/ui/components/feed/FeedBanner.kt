package com.putrapebrianonurba.equran.features.prayer.ui.components.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.R
import com.putrapebrianonurba.equran.core.common.currentFullDate
import com.putrapebrianonurba.equran.core.common.currentTime

@Composable
fun FeedBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_prayers_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // OVERLAY CONTENT
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = currentTime(),
                style = MaterialTheme.typography.displayLarge,
                color = Color.White
            )

            Text(
                text = currentFullDate(),
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
        }
    }
}