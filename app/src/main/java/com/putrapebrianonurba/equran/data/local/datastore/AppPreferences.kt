package com.putrapebrianonurba.equran.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.putrapebrianonurba.equran.domain.model.settings.options.QoriOptions
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore("app_preferences")

class AppPreferences @Inject constructor(
    @ApplicationContext private val context: Context
) {
    val darkTheme: Flow<Boolean> =
        context.dataStore.data.map {
            it[PreferencesKeys.DARK_THEME] ?: false
        }

    val qoriOptions: Flow<QoriOptions> =
        context.dataStore.data.map {
            QoriOptions.valueOf(
                it[PreferencesKeys.MURROTAL_QORI] ?: QoriOptions.ABDURAHMAN_AS_SUDAIS.name
            )
        }

    val currentCity: Flow<Int> =
        context.dataStore.data.map {
            it[PreferencesKeys.CURRENT_CITY] ?: 1301
        }
    val isOnboarding: Flow<Boolean> =
        context.dataStore.data.map {
            it[PreferencesKeys.IS_ONBOARDING] ?: false
        }

    suspend fun setDarkTheme(value: Boolean) {
        context.dataStore.edit {
            it[PreferencesKeys.DARK_THEME] = value
        }
    }

    suspend fun setQoriOptions(qori: QoriOptions) {
        context.dataStore.edit {
            it[PreferencesKeys.MURROTAL_QORI] = qori.name
        }
    }

    suspend fun setCurrentCity(cityId: Int) {
        context.dataStore.edit {
            it[PreferencesKeys.CURRENT_CITY] = cityId
        }
    }

    suspend fun setOnboardingDone(isDone: Boolean) {
        context.dataStore.edit {
            it[PreferencesKeys.IS_ONBOARDING] = isDone
        }
    }
}