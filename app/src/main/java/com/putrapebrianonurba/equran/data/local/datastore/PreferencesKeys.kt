package com.putrapebrianonurba.equran.data.local.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {
    val DARK_THEME = booleanPreferencesKey("dark_theme")
    val MURROTAL_QORI = stringPreferencesKey("murrotal_qori")
    val CURRENT_CITY = intPreferencesKey("current_city")
    val IS_ONBOARDING = booleanPreferencesKey("is_onboarding")
}
