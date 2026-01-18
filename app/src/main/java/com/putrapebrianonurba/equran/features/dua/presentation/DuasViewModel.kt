package com.putrapebrianonurba.equran.features.dua.presentation

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
class DuasViewModel @Inject constructor(
    private val repository: DuaRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(DuaUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadDuas()
    }

    private fun loadDuas() {
        viewModelScope.launch {
            repository.getDuas().collect { result ->
                when(result) {
                    is Resource.Error -> {
                        _uiState.update { it.copy(duasIsLoading = true) }
                    }
                    is Resource.Loading -> {
                        _uiState.update { it.copy(duasIsLoading = result.isLoading) }
                    }
                    is Resource.Success -> {
                        result.data?.let { duas ->
                            _uiState.update {
                                it.copy(
                                    duas = duas,
                                    duasIsLoading = false
                                ) }
                        }
                    }
                }
            }
        }
    }


}