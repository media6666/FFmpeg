package io.microshow.aisound.model

import io.microshow.aisound.normalEffect

data class DataVoiceChanger(
    val inputPath: String,
    val outputPath: String,
    val videoOutputPath: String,
    val effectItem: EffectItem,
    val volumeBgEffect: Float,

    val ambientEffectItem: BgEffectItem,
    val ambientVolume: Float,

    val sampleRate: Int,
    val channelCount: Int,
    val bitrate: Int,
    val duration: Long,
) {
    companion object {
        val DEFAULT = DataVoiceChanger(
            inputPath = "",
            outputPath = "",
            effectItem = normalEffect(),
            volumeBgEffect = 1f,
            ambientEffectItem = normalBgEffect(),
            ambientVolume = 1f,
            sampleRate = 32000,
            channelCount = 2,
            videoOutputPath = "",
            bitrate = 128000,
            duration = 0L
        )
    }

    val isNormal get() = ambientEffectItem.isNormal() && effectItem.isNormal()

    // Nếu là videoChanger thì videoOutputPath sẽ  NotEmpty
    val finalPath get() = videoOutputPath.ifBlank { outputPath }
}