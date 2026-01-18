package com.putrapebrianonurba.equran.features.quran.ui.components.search

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.core.components.IconButton
import com.putrapebrianonurba.equran.core.components.OutlinedTextFieldIcon

@Composable
fun SearchedTopBar(
    isScrolled: Boolean,
    searchTerm: String = "Cari surah pada al-quran",
    onNavigateBack: () -> Unit,
    onSearchClick: () -> Unit
) {
    // DRAW LINE COLOR
    val outline = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                drawLine(
                    color = if (isScrolled) outline else Color.Transparent,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 0.5.dp.toPx()
                )
            },
        color = if (isScrolled) MaterialTheme.colorScheme.background else Color.Transparent,
        shadowElevation = if (isScrolled) 1.dp else 0.dp
    ) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(horizontal = 14.dp, vertical = 10.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // BACK BUTTON
                IconButton(
                    icon = Icons.Default.ArrowBackIosNew,
                    size = 18.dp,
                    onClick = onNavigateBack
                )

                // SEARCH FIELD
                Box(modifier = Modifier.weight(1f)) {
                    OutlinedTextFieldIcon(
                        placeholder = searchTerm,
                        onSearchClick = onSearchClick
                    )
                }
            }
        }
    }
}