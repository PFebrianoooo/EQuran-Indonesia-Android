package com.putrapebrianonurba.equran.features.prayer.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.core.common.orEmpty
import com.putrapebrianonurba.equran.data.mappers.prayers.toList
import com.putrapebrianonurba.equran.domain.repository.PrayerRepository
import com.putrapebrianonurba.equran.domain.repository.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrayerFeedViewModel @Inject constructor(
    private val prayerRepository: PrayerRepository,
    private val settingsRepository: SettingsRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(PrayerUiState())
    val uiState = _uiState.asStateFlow()

    private var cityJob: Job? = null
    private var scheduleJob: Job? = null

    init {
        observeSelectedCity()
    }

    private fun observeSelectedCity() {
        viewModelScope.launch {
            settingsRepository.settingsFlow.collectLatest { settings ->
                cityJob?.cancel()
                scheduleJob?.cancel()
                cityJob = launch { loadCityById(settings.currentCity) }
                scheduleJob = launch { loadPrayerSchedule(settings.currentCity) }
            }
        }
    }

    private fun loadCityById(cityId: Int) {
        viewModelScope.launch {
            prayerRepository.getCityById(cityId).collect { result ->
                when(result) {
                    is Resource.Error -> {
                        _uiState.update { it.copy(selectedCityIsLoading = false) }
                    }
                    is Resource.Loading -> {
                        _uiState.update { it.copy(selectedCityIsLoading = result.isLoading) }
                    }
                    is Resource.Success-> {
                        _uiState.update {
                            it.copy(
                                selectedCity = result.data?.location.orEmpty(),
                                selectedCityIsLoading = false
                            )
                        }
                    }
                }
            }
        }
    }

    private fun loadPrayerSchedule(cityId: Int) {
        viewModelScope.launch {
            prayerRepository.getPrayerSchedule(cityId).collect { result ->
                when(result) {
                    is Resource.Error -> {
                        _uiState.update { it.copy(prayersScheduleIsLoading = false) }
                    }
                    is Resource.Loading -> {
                        _uiState.update { it.copy(prayersScheduleIsLoading = result.isLoading) }
                    }
                    is Resource.Success-> {
                        _uiState.update {
                            it.copy(
                                prayersSchedule = result.data?.toList() ?: emptyList(),
                                prayersScheduleIsLoading = false
                            )
                        }
                    }
                }
            }
        }
    }
}