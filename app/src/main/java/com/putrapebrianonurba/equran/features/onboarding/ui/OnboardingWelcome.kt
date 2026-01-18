package com.putrapebrianonurba.equran.features.onboarding.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.putrapebrianonurba.equran.R
import com.putrapebrianonurba.equran.core.constants.AppConstants
import com.putrapebrianonurba.equran.features.onboarding.presentation.OnboardingViewModel

@Composable
fun OnboardingWelcome(
    viewModel: OnboardingViewModel,
    onFinish: () -> Unit
) {
    // CONTAINER
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(
                start = 14.dp,
                end = 14.dp,
                top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding(),
                bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
            )
    ) {
        // CONTENT
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // IMAGE
            Image(
                painter = painterResource(R.drawable.ic_onboarding_ilustration),
                contentDescription = R.drawable.ic_onboarding_ilustration.toString(),
                modifier = Modifier.aspectRatio(1f)
            )

            Spacer(modifier = Modifier.height(15.dp))

            // WELCOMING TEXT
            Text(
                text = AppConstants.ONBOARDING_WELCOMING_TITLE,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Start,
                lineHeight = 25.sp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // SUMMARY APP
            Text(
                text = AppConstants.ONBOARDING_SUMMARY_TITLE,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary,
                textAlign = TextAlign.Start,
                lineHeight = 17.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // GET STARTED BUTTON
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = {
                        viewModel.setOnboardingDone()
                        onFinish()
                    }
                )
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = AppConstants.ONBOARDING_GET_STARTED_BUTTON_TITLE,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
    }
}