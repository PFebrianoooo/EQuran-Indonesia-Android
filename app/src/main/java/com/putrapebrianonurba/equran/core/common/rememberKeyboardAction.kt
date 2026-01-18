package com.putrapebrianonurba.equran.core.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun rememberKeyboardActions(): (onAction: () -> Unit) -> Unit {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val scope = rememberCoroutineScope()

    // Kita return lambda yang menerima action navigasi lu
    return remember(keyboardController, focusManager, scope) {
        { onAction ->
            scope.launch {
                keyboardController?.hide()
                focusManager.clearFocus()
                delay(220)
                onAction()
            }
        }
    }
}