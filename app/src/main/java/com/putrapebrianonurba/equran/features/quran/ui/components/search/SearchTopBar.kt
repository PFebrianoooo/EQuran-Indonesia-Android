package com.putrapebrianonurba.equran.features.quran.ui.components.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.core.components.IconButton
import com.putrapebrianonurba.equran.core.components.OutlinedTextField

@Composable
fun SearchTopBar(
    isScrolled: Boolean,
    searchTerm: String,
    onValueChange: (String) -> Unit,
    onSearchSubmit: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    // DRAW LINE COLOR
    val outline = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)

    // ENTER ANIMATION
    var enterTransition by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { enterTransition = true }

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
                AnimatedVisibility(
                    visible = enterTransition,
                    enter = scaleIn(
                        initialScale = 0.5f,
                        animationSpec = spring(
                            dampingRatio = 0.55f,
                            stiffness = Spring.StiffnessLow
                        )
                    ) + fadeIn(
                        animationSpec = tween(120)
                    )
                ) {
                    IconButton(
                        icon = Icons.Default.ArrowBackIosNew,
                        size = 18.dp,
                        onClick = onNavigateBack
                    )
                }

                // SEARCH FIELD
                Box(modifier = Modifier.weight(1f)) {
                    OutlinedTextField(
                        placeholder = "Cari surah pada al-quran",
                        value = searchTerm,
                        onValueChange = { onValueChange(it) },
                        onSearchSubmit = { onSearchSubmit(it) }
                    )
                }
            }
        }
    }
}