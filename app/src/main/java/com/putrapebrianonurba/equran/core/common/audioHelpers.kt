package com.putrapebrianonurba.equran.core.common

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class AudioPlayerHelper(context: Context) {
    private val player: ExoPlayer = ExoPlayer.Builder(context).build()

    val isPlaying: Boolean get() = player.isPlaying

    fun play(url: String) {
        player.setMediaItem(MediaItem.fromUri(url))
        player.prepare()
        player.play()
    }
    fun stop() = player.stop()

    fun pause() = player.pause()

    fun release() = player.release()
}
