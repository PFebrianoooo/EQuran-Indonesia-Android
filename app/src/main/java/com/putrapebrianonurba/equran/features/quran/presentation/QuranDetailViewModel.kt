package com.putrapebrianonurba.equran.features.quran.presentation

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.putrapebrianonurba.equran.core.common.AudioPlayerHelper
import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.domain.repository.BookmarkRepository
import com.putrapebrianonurba.equran.domain.repository.SettingsRepository
import com.putrapebrianonurba.equran.domain.repository.SurahRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuranDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val surahRepository: SurahRepository,
    private val bookmarkRepository: BookmarkRepository,
    private val settingsRepository: SettingsRepository,
    @ApplicationContext private val context: Context
): ViewModel() {
    private val _uiState = MutableStateFlow(QuranUiState())
    val uiState = _uiState.asStateFlow()

    private val surahId = savedStateHandle["id"] ?: 0

    // AUDIO FEATURE
    private var currentQori = settingsRepository.getInitialSettings().murrotalQori
    private val audioPlayer = AudioPlayerHelper(context)

    init {
        loadDetailSurah()
        observeBookmarkStatus()
        observeSettings()
    }

    override fun onCleared() {
        super.onCleared()
        audioPlayer.release()
    }

    private fun loadDetailSurah() {
        viewModelScope.launch {
            surahRepository.getSurahById(surahId).collect { result ->
                when(result) {
                    is Resource.Error -> {
                        _uiState.update { it.copy(detailIsLoading = true) }
                    }
                    is Resource.Loading -> {
                        _uiState.update { it.copy(detailIsLoading = result.isLoading) }
                    }
                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                detailSurah = result.data,
                                detailIsLoading = false
                            )
                        }
                    }
                }
            }
        }
    }

    // FUNCTIONALITY
    private fun observeBookmarkStatus() {
        viewModelScope.launch {
            bookmarkRepository
                .isSurahBookmarked(surahId)
                .collectLatest{ isBookmarked ->
                    _uiState.update {
                        it.copy(surahIsBookmarked = isBookmarked)
                    }
                }
        }
    }

    fun toggleBookmarkedButton() {
        val isBookmarked = _uiState.value.surahIsBookmarked

        viewModelScope.launch {
            if (isBookmarked) {
                bookmarkRepository.deleteSurahFromBookmark(surahId)
            } else {
                bookmarkRepository.saveToBookmark(surahId)
            }
        }
    }

    fun toggleAudioPlayer() {
        val surah = _uiState.value.detailSurah ?: return
        val audioUrl = surah.fullAudio?.get(currentQori.audioKey) ?: return

        val isPlaying = _uiState.value.detailAudioIsPlaying

        if (isPlaying) audioPlayer.pause() else audioPlayer.play(audioUrl)

        _uiState.update { it.copy(detailAudioIsPlaying = !isPlaying) }
    }

    private fun observeSettings() {
        viewModelScope.launch {
            settingsRepository.settingsFlow.collect { settings ->
                currentQori = settings.murrotalQori
            }
        }
    }

}