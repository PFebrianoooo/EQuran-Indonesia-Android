package com.putrapebrianonurba.equran.features.quran.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.putrapebrianonurba.equran.domain.model.settings.options.QoriOptions
import com.putrapebrianonurba.equran.domain.repository.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val repository: SettingsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(repository.getInitialSettings())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.settingsFlow.collectLatest {
                _uiState.value = it
            }
        }
    }

    fun onThemeToggle(value: Boolean) {
        _uiState.update { it.copy(darkTheme = value) }
        viewModelScope.launch {
            repository.setDarkTheme(value)
        }
    }

    fun onQoriSelected(qori: QoriOptions) {
        _uiState.update { it.copy(murrotalQori = qori) }
        viewModelScope.launch {
            repository.setQoriOptions(qori)
        }
    }

}