package com.putrapebrianonurba.equran.features.dua.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.domain.repository.DuaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DuaDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: DuaRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(DuaUiState())
    val uiState = _uiState.asStateFlow()

    private val id = savedStateHandle["id"] ?: 0

    init { loadDetailDua() }

    private fun loadDetailDua() {
        viewModelScope.launch {
            repository.getDuaById(id).collect { result ->
                when(result) {
                    is Resource.Error -> {
                        _uiState.update { it.copy(duaDetailIsLoading = true) }
                    }
                    is Resource.Loading -> {
                        _uiState.update { it.copy(duaDetailIsLoading = result.isLoading) }
                    }
                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                duaDetail = result.data,
                                duaDetailIsLoading = false
                            )
                        }
                    }
                }
            }
        }
    }
}