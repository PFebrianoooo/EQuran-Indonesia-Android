package com.putrapebrianonurba.equran.domain.repository

import com.putrapebrianonurba.equran.domain.model.settings.AppSettings
import com.putrapebrianonurba.equran.domain.model.settings.options.QoriOptions
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    val settingsFlow: Flow<AppSettings>
    fun getInitialSettings(): AppSettings
    suspend fun setDarkTheme(value: Boolean)
    suspend fun setQoriOptions(qori: QoriOptions)
    suspend fun setCurrentCity(cityId: Int)
    suspend fun setOnboardingDone(isDone: Boolean)
}