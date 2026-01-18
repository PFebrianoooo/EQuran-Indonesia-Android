package com.putrapebrianonurba.equran.features.prayer.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.domain.model.prayers.City
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
class PrayerCitiesViewModel @Inject constructor(
    private val prayerRepository: PrayerRepository,
    private val settingsRepository: SettingsRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(PrayerUiState())
    val uiState = _uiState.asStateFlow()

    private var cityJob: Job? = null

    init {
        loadCities()
        observeSelectedCity()
    }

    private fun observeSelectedCity() {
        viewModelScope.launch {
            settingsRepository.settingsFlow.collectLatest { settings ->
                cityJob?.cancel()
                cityJob = launch { getCityById(settings.currentCity) }
            }
        }
    }

    private fun loadCities() {
        viewModelScope.launch {
            prayerRepository.getCities().collect { result ->
                when(result) {
                    is Resource.Error -> {
                        _uiState.update { it.copy(citiesIsLoading = true) }
                    }
                    is Resource.Loading -> {
                        _uiState.update { it.copy(citiesIsLoading = result.isLoading) }
                    }
                    is Resource.Success-> {
                        result.data?.let { cities ->
                            _uiState.update {
                                it.copy(
                                    cities = cities,
                                    citiesIsLoading = false
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun getCityById(cityId: Int) {
        viewModelScope.launch {
            prayerRepository.getCityById(cityId).collect { result ->
                when(result) {
                    is Resource.Error -> {
                        _uiState.update { it.copy(selectedCityIsLoading = true) }
                    }
                    is Resource.Loading -> {
                        _uiState.update { it.copy(selectedCityIsLoading = result.isLoading) }
                    }
                    is Resource.Success-> {
                        result.data?.let { city ->
                            _uiState.update {
                                it.copy(
                                    selectedCity = city.location,
                                    selectedCityIsLoading = false
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    // FUNCTIONALITY
    fun onSelectedCity(city: City) {
        viewModelScope.launch { settingsRepository.setCurrentCity(city.id) }
    }
}