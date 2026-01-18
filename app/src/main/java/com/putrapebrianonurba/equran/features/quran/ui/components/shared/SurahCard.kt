package com.putrapebrianonurba.equran.features.quran.ui.components.shared

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.core.components.OrnamentNumber
import com.putrapebrianonurba.equran.domain.model.quran.Surah

@Composable
fun SurahCard(
    surah: Surah,
    onNavigateDetail: () -> Unit
) {
    // CONTAINER
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onNavigateDetail
            ),
        color = Color.Transparent,
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // LEFT CONTENT
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    // ORNAMENT NUMBER
                    OrnamentNumber(number = surah.id)

                    // SURAH INFORMATION
                    Column{
                        Text(
                            text = surah.latinName,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.secondary,
                            maxLines = 2
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Text(
                                text = surah.revelationPlace,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.secondary,
                                maxLines = 1,
                            )

                            Text(
                                text = "• ${surah.totalVerses} Ayat",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.secondary,
                                maxLines = 1,
                            )
                        }

                    }
                }


                // RIGHT CONTENT
                Text(
                    text = surah.name,
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            HorizontalDivider(
                thickness = 0.25.dp,
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}