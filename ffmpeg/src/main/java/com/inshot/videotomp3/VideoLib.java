package com.inshot.videotomp3;

import androidx.annotation.Keep;

public class VideoLib {

    private static ConvertListener convertListener;

    public static void setConvertListener(ConvertListener listener) {
        convertListener = listener;
    }

    public static void removeConvertListener() {
        convertListener = null;
    }

    //outputPath của VideoToMp3 - tương đương với inputPath
    @Keep
    public static native int addMp3Thumbnail(String outputPath, String tempPath, String inputPathCover);

    //aCodec xác định xem cần format đồi với audio là aac hay chỉ cần dùng copy
    @Keep
    public static native int compressVideo(String inputPath, String outputPath, String aCodec, String videoCodec, String formatValueText, String lengthText, String command, boolean z, boolean z2, boolean z3);

    @Keep
    public static native int cutAudio(String inputPath, String outputPath, String startTime, String length, String audioBitrate, String frequency, String formatExtensionValue, String command, String str9, String str10, String str11, String str12, String str13, String str14);

    @Keep
    public static native int cutMiddleAudio(String inputPath, String outputPath, String startTime, String length, String durationInSecond, String audioBitrate, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18);

    @Keep
    public static native int cutVideo(String inputPath, String outputPath, String inputStartTime, String startTime, String lengthOrEndTime, String resolution, boolean videoSupportEncode, boolean audioSupportEncode, String compareRotateBitrateSize, String commandVolume, String str9);

    @Keep
    protected static native void ffmpegVersion();

    @Keep
    public static native int formatAudio(String inputPath, String outputPath, String typeFormat, String bitrate, String frequency, String channel, String title, String artist, String album, String genre, String track, String year);

    // formatType  {"mp4", "3gp", "mov", "flv", "mkv", "avi", "m4v", "mts", "m2ts", "ts"};
    // typeFormatAudio: mp3, copy
    @Keep
    public static native int formatVideo(String inputPath, String outputPath, String formatType, String codec, String typeFormatAudio, String str6, String audioBitrate);

    @Keep
    public static native int mergeVideo(String[] listPath, String outputPath, boolean z, String str2, String str3, String str4, String str5, String str6, String str7);

    @Keep
    public static native int mergerToMp3(String[] strArr, String outputPath, String commandFFMpeg, String sizeList, String frequency, String bitrate);

    @Keep
    public static native String nativeErrorMessage(int i);

    @Keep
    public static native byte[] nativeGenerateWaveformData(String audioPath, int frameDuration);

    @Keep
    public static native String nativeGetAudioInfo(String audioPath);

    @Keep
    public static native String nativeGetVideoInfo(String videoPath);

    @Keep
    public static void onProgressCallback(long progress) {
        if (convertListener != null) {
            convertListener.progress(progress / 1000);
        }
    }

    @Keep
    public static native int runMultiCommands(String[] strArr);

    @Keep
    public static native void setCancelFlag(int i);

    @Keep
    public static native int speedAudio(String inputPath, String outputPath, String max, String a, String str5, String str6, String str7, String str8);

    @Keep
    public static native int speedVideo(String inputPath, String outputPath, String str3, String str4, String str5, String str6, String str7, String str8);

    @Keep
    public static native int toMp3(String inputPath, String outputPath, String startTime, String endTimeOrLength, String formatMp3, String bitrate, String frequency, String channel, String volumeFadeInFadeOut, String title, String artist, String album, String genre, String track, String year);
}
