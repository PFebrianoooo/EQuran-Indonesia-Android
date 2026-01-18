package com.putrapebrianonurba.equran.core.common

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun LazyListState.topBarScrollBehavior(): Boolean {
    val density = LocalDensity.current
    val statusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()

    return remember(this) {
        derivedStateOf {
            // Logic: Threshold adalah jarak dari nol layar ke item pertama
            val thresholdPx = with(density) { (statusBarHeight + 54.dp).toPx() }

            firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset >= thresholdPx
        }
    }.value
}