package com.putrapebrianonurba.equran.features.quran.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.domain.repository.SearchRepository
import com.putrapebrianonurba.equran.domain.repository.SurahRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuranSearchViewModel @Inject constructor(
    private val surahRepository: SurahRepository,
    private val searchRepository: SearchRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(QuranUiState())
    val uiState = _uiState.asStateFlow()

    init { loadAllHistory() }

    fun onSearchSubmit() {
        val query = _uiState.value.searchTerm
        if (query.isBlank()) return

        val validateQuery = normalizeQuery(query)
        savedLastSearched(query)

        viewModelScope.launch {
            surahRepository.getSurahByQuery(validateQuery).collect { result ->
                when (result) {
                    is Resource.Error -> {
                        _uiState.update { it.copy(searchIsLoading = true) }
                    }
                    is Resource.Loading -> {
                        _uiState.update { it.copy(searchIsLoading = result.isLoading) }
                    }
                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                searchedSurah = result.data ?: emptyList(),
                                searchIsLoading = false
                            )
                        }
                        saveKeyword(query)
                    }
                }
            }
        }
    }

    private fun loadAllHistory() {
        viewModelScope.launch {
            searchRepository.getKeywords().collect { result ->
                when(result) {
                    is Resource.Error -> {
                        _uiState.update { it.copy(searchHistoryIsLoading = true) }
                    }
                    is Resource.Loading -> {
                        _uiState.update { it.copy(searchHistoryIsLoading = result.isLoading) }
                    }
                    is Resource.Success -> {
                        result.data?.let { history ->
                            _uiState.update {
                                it.copy(
                                    searchHistory = history,
                                    searchHistoryIsLoading = false
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun saveKeyword(search: String) {
        if (search.isEmpty()) return

        viewModelScope.launch { searchRepository.saveHistory(search) }
    }

    fun deleteKeyword(id: Int) {
        viewModelScope.launch { searchRepository.deleteKeyword(id) }
    }

    // FUNCTIONALITY
    fun onSearchTermChange(newValue: String) = _uiState.update { it.copy(searchTerm = newValue) }

    fun clearSearch() =  _uiState.update { it.copy(searchTerm = "") }

    private fun savedLastSearched(query: String) {
        _uiState.update {
            it.copy(
                searchTerm = "",
                lastSearchTerm = query
            )
        }
    }

    private fun normalizeQuery(input: String): String {
        return input
            .lowercase()
            .replace(Regex("[^a-z0-9\\s]"), "")
            .trim()
            .replace(Regex("\\s+"), " ")
    }
}