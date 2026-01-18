package com.putrapebrianonurba.equran.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.putrapebrianonurba.equran.features.quran.presentation.SettingsViewModel
import com.putrapebrianonurba.equran.features.root.RootScreen
import com.putrapebrianonurba.equran.features.root.navigation.RootRoute
import com.putrapebrianonurba.equran.ui.theme.EquranTheme
import com.putrapebrianonurba.equran.ui.theme.SystemBars
import dagger.hilt.android.AndroidEntryPoint

/**
 * Application Entry Point
 *
 * The MainActivity serves as the Application Entry Point.
 * It is the first activity launched by the system and is responsible for setting the visual foundation of the app.
 * It handles the transition from the system splash screen to the functional UI, configures the global styling, and directs the user to the appropriate landing screen. Including:
 * - Splash Screen orchestration.
 * - Global Theme and design system application.
 * - Onboarding status evaluation (Onboard Decider).
 * - Navigation handover to the Root Screen and primary Top Bar.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            val viewModel: SettingsViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            val startDecisionRoute = if (!uiState.isOnboarding) { RootRoute.Onboarding.route }
            else RootRoute.Main.route
            EquranTheme(darkTheme = uiState.darkTheme) {
                SystemBars(uiState.darkTheme)
                RootScreen(
                    startDecisionRoute = startDecisionRoute
                )
            }
        }
    }
}