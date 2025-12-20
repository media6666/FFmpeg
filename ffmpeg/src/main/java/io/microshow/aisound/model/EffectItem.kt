package io.microshow.aisound.model

import io.microshow.aisound.AIVoiceChanger
import io.microshow.aisound.AiSound

data class EffectItem(
    var dspInfoList: List<DspInfo>,
    var pathBgEffect: String,
    var iconResId: Int,
    var iconResIdSmall: Int,
    var name: String,
    var i4: Int,
    var i5: Int,
    var isPro: Boolean,
    var volumeBgEffect: Float = 1f,
    var isBgEffectPlaying: Boolean = false,
) {

    fun canShowCustom(): Boolean {
        return listDspEffectCustom().isNotEmpty() || showBgEffect()
    }

    fun listDspEffectCustom(): List<DspEffect> {
        return dspInfoList.flatMap { it.dspEffects }.filter { it.isCustom }
    }

    fun updateDspEffect(newDspEffect: DspEffect) {
        dspInfoList.forEach { dspInfo ->
            if (dspInfo.dspEffects.any { it.textId == newDspEffect.textId }) {
                val newList = dspInfo.dspEffects.map { current ->
                    if (current.textId == newDspEffect.textId) newDspEffect else current
                }
                dspInfo.dspEffects = newList  // gán lại list mới
            }
        }
    }

    fun resetDspEffect() {
        isBgEffectPlaying = false
        dspInfoList.forEach { dspInfo ->
            dspInfo.dspEffects.forEach {
                it.valueCustom = it.value1
            }
        }
    }

    fun showBgEffect(): Boolean {
        return pathBgEffect.isNotBlank()
    }

    fun fullEffectPath(): String {
        if (pathBgEffect.isBlank()) {
            return ""
        }
        return "file:///android_asset/avatarbg/${pathBgEffect}"
    }

    fun isNormal(): Boolean {
        return name == "None"
    }

    fun isMusicEffect(): Boolean {
        return name == "Music"
    }

    fun isMusicNormal(): Boolean {
        return name == "Normal"
    }

    fun isMusicRock(): Boolean {
        return name == "Rock"
    }

    fun isMusicPop(): Boolean {
        return name == "Pop"
    }

    fun isMusicJazz(): Boolean {
        return name == "Jazz"
    }

    fun isMusicClassic(): Boolean {
        return name == "Classic"
    }

    fun isMusicVocal(): Boolean {
        return name == "Vocal"
    }

}

fun EffectItem.applyEffect() {
    if (AIVoiceChanger.getInstance().checkLibLoaded.not()) {
        return
    }
    AiSound.removeAllEffect()
    dspInfoList.forEach {
        val size = it.dspEffects.size
        when (size) {
            3 -> {
                AiSound.setEffect(
                    it.aiSoundType,
                    3,
                    it.dspEffects[0].getValueApplyEffect(),
                    it.dspEffects[1].getValueApplyEffect(),
                    it.dspEffects[2].getValueApplyEffect()
                )
            }

            1 -> {
                AiSound.setEffect(
                    it.aiSoundType,
                    1,
                    it.dspEffects[0].getValueApplyEffect(),
                )
            }

            2 -> {
                AiSound.setEffect(
                    it.aiSoundType,
                    1,
                    it.dspEffects[0].getValueApplyEffect(),
                    it.dspEffects[1].getValueApplyEffect(),
                )
            }

            4 -> {
                AiSound.setEffect(
                    it.aiSoundType,
                    4,
                    it.dspEffects[0].getValueApplyEffect(),
                    it.dspEffects[1].getValueApplyEffect(),
                    it.dspEffects[2].getValueApplyEffect(),
                    it.dspEffects[3].getValueApplyEffect(),
                )
            }

            6 -> {
                AiSound.setEffect(
                    it.aiSoundType,
                    6,
                    it.dspEffects[0].getValueApplyEffect(),
                    it.dspEffects[1].getValueApplyEffect(),
                    it.dspEffects[2].getValueApplyEffect(),
                    it.dspEffects[3].getValueApplyEffect(),
                    it.dspEffects[4].getValueApplyEffect(),
                    it.dspEffects[5].getValueApplyEffect(),
                )
            }

            8 -> {
                AiSound.setEffect(
                    it.aiSoundType,
                    8,
                    it.dspEffects[0].getValueApplyEffect(),
                    it.dspEffects[1].getValueApplyEffect(),
                    it.dspEffects[2].getValueApplyEffect(),
                    it.dspEffects[3].getValueApplyEffect(),
                    it.dspEffects[4].getValueApplyEffect(),
                    it.dspEffects[5].getValueApplyEffect(),
                    it.dspEffects[6].getValueApplyEffect(),
                    it.dspEffects[7].getValueApplyEffect(),
                )
            }

            13 -> {
                AiSound.setEffect(
                    it.aiSoundType,
                    13,
                    it.dspEffects[0].getValueApplyEffect(),
                    it.dspEffects[1].getValueApplyEffect(),
                    it.dspEffects[2].getValueApplyEffect(),
                    it.dspEffects[3].getValueApplyEffect(),
                    it.dspEffects[4].getValueApplyEffect(),
                    it.dspEffects[5].getValueApplyEffect(),
                    it.dspEffects[6].getValueApplyEffect(),
                    it.dspEffects[7].getValueApplyEffect(),
                    it.dspEffects[8].getValueApplyEffect(),
                    it.dspEffects[9].getValueApplyEffect(),
                    it.dspEffects[10].getValueApplyEffect(),
                    it.dspEffects[11].getValueApplyEffect(),
                    it.dspEffects[12].getValueApplyEffect(),
                )
            }
        }
    }
    AiSound.resumeSound()
}