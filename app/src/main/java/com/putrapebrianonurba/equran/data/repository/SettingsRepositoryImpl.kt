package com.putrapebrianonurba.equran.data.repository

import com.putrapebrianonurba.equran.data.local.source.SettingsDataLocalSource
import com.putrapebrianonurba.equran.domain.model.settings.AppSettings
import com.putrapebrianonurba.equran.domain.model.settings.options.QoriOptions
import com.putrapebrianonurba.equran.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsRepositoryImpl @Inject constructor(
    private val dataSource: SettingsDataLocalSource
) : SettingsRepository {
    override val settingsFlow: Flow<AppSettings> =
        dataSource.settingsFlow

    override fun getInitialSettings(): AppSettings {
        return runBlocking { settingsFlow.first() }
    }

    override suspend fun setDarkTheme(value: Boolean) {
        dataSource.setDarkTheme(value)
    }

    override suspend fun setQoriOptions(qori: QoriOptions) {
        dataSource.setMurrotalQori(qori)
    }

    override suspend fun setCurrentCity(cityId: Int) {
        dataSource.setCurrentCity(cityId)
    }

    override suspend fun setOnboardingDone(isDone: Boolean) {
        dataSource.setOnboardingDone(isDone)
    }
}
