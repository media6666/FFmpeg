package io.microshow.aisound.model

data class DspInfo(
    val aiSoundType: Int,
    var dspEffects: List<DspEffect>
)