package io.microshow.aisound

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.inshot.videotomp3.OnlySingletonHolder
import io.microshow.aisound.model.DataVoiceChanger
import io.microshow.aisound.model.fullPathEffect
import org.fmod.FMOD

class AIVoiceChanger {
    companion object : OnlySingletonHolder<AIVoiceChanger>(::AIVoiceChanger)

    private var libLoaded: Boolean = false

    val checkLibLoaded: Boolean get() = libLoaded

    init {
        try {
            System.loadLibrary("fmod")
            System.loadLibrary("fmodL")
            System.loadLibrary("aisound")
            libLoaded = true
        } catch (exception: UnsatisfiedLinkError) {
            libLoaded = false
        }
    }

    fun initLibrary(context: Context, callback: (Boolean) -> Unit) {
        if (libLoaded) {
            FMOD.init(context)
            AiSound.init(context)
            callback.invoke(true)
        } else {
            callback.invoke(false)
        }
    }

    fun close() {
        if (libLoaded.not()) {
            return
        }
        try {
            AiSound.pauseSound()
            AiSound.stopSound()
            AiSound.stopBgSound()
            AiSound.stopAvatarBgSound()
            AiSound.close()
        } catch (e: Exception) {
            Log.e("Error %s", e.message.orEmpty())
        }
    }

    fun pause() {
        if (libLoaded.not()) {
            return
        }
        AiSound.pauseSound()
    }

    fun resume() {
        if (libLoaded.not()) {
            return
        }
        AiSound.resumeSound()
    }

    fun currentDuration(): Int {
        if (libLoaded.not()) {
            return 0
        }
        return AiSound.curentDuration()
    }

    fun currentSaveProgress(): Int {
        if (libLoaded.not()) {
            return 0
        }
        return AiSound.curentSaveProgress()
    }

    fun isPause(): Boolean {
        if (libLoaded.not()) {
            return true
        }
        return AiSound.isPause()
    }

    fun isPlay(): Boolean {
        if (libLoaded.not()) {
            return true
        }
        return AiSound.isPlay()
    }

    fun playSoundAsync(path: String, looping: Boolean) {
        if (libLoaded.not()) {
            return
        }
        AiSound.playSoundAsync(path, looping)
    }

    fun playSound(path: String, looping: Boolean) {
        if (libLoaded.not()) {
            return
        }
        try {
            AiSound.playSound(path, looping)
        } catch (e: Exception) {
            Log.e("Error %s", e.message.orEmpty())
        }
    }

    fun playAvatarBgSound(path: String) {
        if (libLoaded.not()) {
            return
        }
        AiSound.playAvatarBgSound(path)
    }

    fun setAvatarBgVolume(volume: Float) {
        if (libLoaded.not()) {
            return
        }
        AiSound.setAvatarBgVolume(volume)
    }

    fun stopAvatarBg() {
        if (libLoaded.not()) {
            return
        }
        AiSound.stopAvatarBgSound()
    }

    fun playAmbientSound(path: String, looping: Boolean) {
        if (libLoaded.not()) {
            return
        }
        AiSound.playBgSound(path, looping)
    }

    fun addShortBg(value: Long) {
        if (libLoaded.not()) {
            return
        }
        AiSound.addShortBg(value)
    }

    fun bgTotalDuration(): Int {
        if (libLoaded.not()) {
            return 0
        }
        return AiSound.bgTotalDuration()
    }

    fun clearShortBg() {
        if (libLoaded.not()) {
            return
        }
        AiSound.clearShortBg()
    }

    fun totalDuration(): Int {
        if (libLoaded.not()) {
            return 0
        }
        return AiSound.totalDuration()
    }

    fun seekToDurationAsync(duration: Long) {
        if (libLoaded.not()) {
            return
        }
        Handler(Looper.getMainLooper()).post { AiSound.seekToDuration(duration) }
    }

    fun setAmbientVolume(volume: Float) {
        if (libLoaded.not()) {
            return
        }
        AiSound.setBgVolume(volume)
    }

    fun setOriginVolume(volume: Float) {
        if (libLoaded.not()) {
            return
        }
        AiSound.setOriginalVolume(volume)
    }

    fun save(dataVoiceChanger: DataVoiceChanger) {
        if (libLoaded.not()) {
            return
        }
        val effectItem = dataVoiceChanger.effectItem
        AiSound.startSaveSound(
            dataVoiceChanger.inputPath,
            dataVoiceChanger.outputPath,
            dataVoiceChanger.ambientEffectItem.fullPathEffect(),
            dataVoiceChanger.ambientVolume,
            dataVoiceChanger.ambientEffectItem.isOkEffect,
            effectItem.fullEffectPath(),
            dataVoiceChanger.volumeBgEffect,
            dataVoiceChanger.sampleRate,
            dataVoiceChanger.channelCount
        )
        effectItem.dspInfoList.forEach {
            val size = it.dspEffects.size
            when (size) {
                3 -> {
                    AiSound.setOutputEffect(
                        it.aiSoundType,
                        3,
                        it.dspEffects[0].getValueApplyEffect(),
                        it.dspEffects[1].getValueApplyEffect(),
                        it.dspEffects[2].getValueApplyEffect()
                    )
                }

                1 -> {
                    AiSound.setOutputEffect(
                        it.aiSoundType,
                        1,
                        it.dspEffects[0].getValueApplyEffect(),
                    )
                }

                2 -> {
                    AiSound.setOutputEffect(
                        it.aiSoundType,
                        1,
                        it.dspEffects[0].getValueApplyEffect(),
                        it.dspEffects[1].getValueApplyEffect(),
                    )
                }

                4 -> {
                    AiSound.setOutputEffect(
                        it.aiSoundType,
                        4,
                        it.dspEffects[0].getValueApplyEffect(),
                        it.dspEffects[1].getValueApplyEffect(),
                        it.dspEffects[2].getValueApplyEffect(),
                        it.dspEffects[3].getValueApplyEffect(),
                    )
                }

                6 -> {
                    AiSound.setOutputEffect(
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
                    AiSound.setOutputEffect(
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
                    AiSound.setOutputEffect(
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
        AiSound.endSaveSound(
            dataVoiceChanger.inputPath,
            dataVoiceChanger.outputPath,
            dataVoiceChanger.ambientVolume,
            dataVoiceChanger.sampleRate,
            dataVoiceChanger.channelCount
        )
    }
}