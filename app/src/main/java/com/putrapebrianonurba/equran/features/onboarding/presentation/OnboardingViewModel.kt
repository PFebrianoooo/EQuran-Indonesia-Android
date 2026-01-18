package com.putrapebrianonurba.equran.features.onboarding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.putrapebrianonurba.equran.domain.repository.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository
): ViewModel() {
    fun setOnboardingDone() {
        viewModelScope.launch {
            settingsRepository.setOnboardingDone(true)
        }
    }
}