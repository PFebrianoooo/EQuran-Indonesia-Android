package com.putrapebrianonurba.equran.domain.model.settings

import com.putrapebrianonurba.equran.domain.model.settings.options.QoriOptions

data class AppSettings(
    val darkTheme: Boolean = false,
    val murrotalQori: QoriOptions = QoriOptions.ABDURAHMAN_AS_SUDAIS,
    val currentCity: Int = 1301,
    val isOnboarding: Boolean = true
)


