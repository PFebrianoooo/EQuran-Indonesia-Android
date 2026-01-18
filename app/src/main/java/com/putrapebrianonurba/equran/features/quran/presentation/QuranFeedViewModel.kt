package com.putrapebrianonurba.equran.features.quran.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.domain.repository.SurahRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuranFeedViewModel @Inject constructor(
    private val repository: SurahRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(QuranUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadAllSurah()
    }

    private fun loadAllSurah() {
        viewModelScope.launch {
            repository.getAllSurah().collect { result ->
                when(result) {
                    is Resource.Error -> {
                        _uiState.update { it.copy(allSurahIsLoading = true) }
                    }
                    is Resource.Loading -> {
                        _uiState.update { it.copy(allSurahIsLoading = result.isLoading) }
                    }
                    is Resource.Success -> {
                        result.data?.let { allSurah ->
                            _uiState.update {
                                it.copy(
                                    allSurah = allSurah,
                                    allSurahIsLoading = false
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}