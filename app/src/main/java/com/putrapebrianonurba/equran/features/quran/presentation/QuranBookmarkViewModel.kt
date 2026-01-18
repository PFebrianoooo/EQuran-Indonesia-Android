package com.putrapebrianonurba.equran.features.quran.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.domain.repository.BookmarkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuranBookmarkViewModel @Inject constructor(
    private val repository: BookmarkRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(QuranUiState())
    val uiState = _uiState.asStateFlow()

    init { loadBookmarkedAllSurah() }

    private fun loadBookmarkedAllSurah() {
        viewModelScope.launch {
            repository.getAllSurah().collectLatest { result ->
                when(result) {
                    is Resource.Error -> {
                        _uiState.update { it.copy(bookmarkIsLoading = false) }
                    }
                    is Resource.Loading -> {
                        _uiState.update { it.copy(bookmarkIsLoading = result.isLoading) }
                    }
                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                bookmarksSurah = result.data ?: emptyList(),
                                bookmarkIsLoading = false
                            )
                        }
                    }
                }
            }
        }
    }
}