package com.putrapebrianonurba.equran.core

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application Dependency Initializer
 *
 * The DependencyInitializer (or Application Class) acts as the central entry point for the application's lifecycle.
 * It is responsible for bootstrapping the dependency injection graph using Dagger Hilt, ensuring that all core architectural components are instantiated and ready for use before the UI layers are rendered.
 */
@HiltAndroidApp
class EQuranApp: Application() {}