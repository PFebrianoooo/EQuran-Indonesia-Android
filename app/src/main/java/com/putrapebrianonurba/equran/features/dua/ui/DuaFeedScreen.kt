package com.putrapebrianonurba.equran.features.dua.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.equran.R
import com.putrapebrianonurba.equran.core.constants.AppConstants
import com.putrapebrianonurba.equran.features.dua.ui.components.shared.DuaNavigateCard

@Composable
fun DuaFeedScreen(
    onNavigateDuas: () -> Unit,
    onNavigateDuaTest: () -> Unit
) {
    // CONTAINER
    Box(modifier = Modifier.fillMaxSize()) {
        // IMAGE BACKGROUND
        Image(
            painter = painterResource(R.drawable.ic_dua_background),
            contentDescription = R.drawable.ic_dua_background.toString(),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )

        // NAVIGATE BUTTON
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // NAVIGATE TO ALL DUA
            DuaNavigateCard(
                icon = R.drawable.ic_dua_duas,
                title = AppConstants.DUAS_TITLE,
                onNavigate = onNavigateDuas,
            )

            // NAVIGATE TO DUA TEST
            DuaNavigateCard(
                icon = R.drawable.ic_dua_duas_test,
                title = AppConstants.DUAS_TEST_TITLE,
                onNavigate = onNavigateDuaTest,
            )
        }
    }
}