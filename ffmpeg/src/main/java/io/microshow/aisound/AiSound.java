package io.microshow.aisound;

import android.content.Context;
import android.os.Handler;

import org.fmod.FMOD;


public class AiSound {

    public static final int TYPE_FMOD_DSP_SFXREVERB = 9;
    public static final int TYPE_FMOD_DSP_TYPE_CHANNEL = 2;
    public static final int TYPE_FMOD_DSP_TYPE_CHORUS = 7;
    public static final int TYPE_FMOD_DSP_TYPE_DISTORTION = 8;
    public static final int TYPE_FMOD_DSP_TYPE_ECHO = 3;
    public static final int TYPE_FMOD_DSP_TYPE_FLANGE = 4;
    public static final int TYPE_FMOD_DSP_TYPE_NORMALIZE = 1;
    public static final int TYPE_FMOD_DSP_TYPE_OSCILLATOR = 6;
    public static final int TYPE_FMOD_DSP_TYPE_PITCHSHIFT = 0;
    public static final int TYPE_FMOD_DSP_TYPE_THREE_EQ = 10;
    public static final int TYPE_FMOD_DSP_TYPE_TREMOLO = 5;
    public static final int TYPE_NORMAL = 0;

    public interface OnSaveListener {
        void onSaveError(String error);
    }

    public static native void addShortBg(long j10);

    public static native int bgTotalDuration();

    public static native void clearShortBg();

    public static void close() {
        if (FMOD.checkInit()) {
            FMOD.close();
        }
    }

    public static native int curentDuration();

    public static void init(Context context) {
        if (context == null || FMOD.checkInit()) {
            return;
        }
        FMOD.init(context.getApplicationContext());
    }

    public static native boolean isInterruptedSaved();

    public static native boolean isPause();

    public static native boolean isPlay();

    public static void playSoundAsync(final String str, final boolean z10) {
        new Handler().post(() -> {
            if (isPlay()) {
                stopSound();
            }
            playSound(str, z10);
        });
    }

    public static native void pauseSound();

    public static native void playAvatarBgSound(String str);

    public static native void playBgSound(String str, boolean loop);

    public static native void playSound(String str, boolean loop);


    public static native void removeAllEffect();

    public static native void removeEffect(int i10);

    public static native void resumeSound();

    public static void saveSoundAsync(String inputSoundPath, String outputSoundPath, int type, final OnSaveListener listener) {
        new Thread(() -> {
            try {
                if (isPlay()) {
                    stopSound();
                }
            } catch (Exception error) {
                if (listener != null) {
                    listener.onSaveError(error.getMessage());
                }
            }
        }).start();
    }

    public static native void seekToDuration(long j10);

    public static void seekToDurationAsync(final long duration) {
        new Handler().post(() -> AiSound.seekToDuration(duration));
    }

    public static native void setAvatarBgVolume(float volume);

    public static native void setBgVolume(float volume);

    public static native void setEffect(int i10, int i11, float... fArr);

    public static native void setInterruptedSaved(boolean z10);

    public static native void setOriginalVolume(float volume);

    public static native void setOutputEffect(int i10, int i11, float... fArr);

    //sampleRate : 32000
    // channelCount : 2
    // z10 value lấy từ BgEffect
    // f10 value lấy từ BgEffect
    public static native int startSaveSound(String inputPath, String outputPath, String ambientPath, float ambientVolume, boolean ambientOk, String backgroundBgPath, float volumeBgEffect, int sampleRate, int channelCount);

    public static native void endSaveSound(String inputPath, String outputPath, float ambientVolume, int sampleRate, int channelCount);

    public static native int curentSaveProgress();

    public static native void stopAvatarBgSound();

    public static native void stopBgSound();

    public static native void stopSound();

    public static void stopSoundAsync() {
        new Handler().post(AiSound::stopSound);
    }

    public static native int totalDuration();
}
