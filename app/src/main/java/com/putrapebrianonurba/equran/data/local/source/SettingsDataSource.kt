package com.putrapebrianonurba.equran.data.local.source

import com.putrapebrianonurba.equran.data.local.datastore.AppPreferences
import com.putrapebrianonurba.equran.domain.model.settings.AppSettings
import com.putrapebrianonurba.equran.domain.model.settings.options.QoriOptions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class SettingsDataSource @Inject constructor(
    private val prefs: AppPreferences
) {
    val settingsFlow: Flow<AppSettings> =
        combine(prefs.darkTheme, prefs.qoriOptions) { dark, qori ->
            AppSettings(
                darkTheme = dark,
                murrotalQori = qori
            )
        }

    suspend fun setDarkTheme(value: Boolean) = prefs.setDarkTheme(value)

    suspend fun setMurrotalQori(qori: QoriOptions) = prefs.setQoriOptions(qori)
}