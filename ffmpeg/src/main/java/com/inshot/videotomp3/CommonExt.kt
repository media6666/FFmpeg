package com.inshot.videotomp3

import java.util.Formatter
import java.util.Locale

enum class VocalDownloadState {
    NO_START, DOWNLOADING, SUCCESS, FAIL
}

fun VocalDownloadState.isShowProgress(): Boolean {
    return this == VocalDownloadState.DOWNLOADING
}

enum class FilterSortedByType(val rawValue: String) {
    DATE("Date"), NAME("Name"), DURATION("Duration"), COUNT_FILE("File count")
}

//Descending, Ascending
enum class FilterSortOrderType {
    DESCENDING, ASCENDING
}

enum class StateMediaPlayer {
    RESUME, PAUSE, STOP, UPDATE
}

enum class SelectAudioScreen {
    ALL, FOLDER
}

enum class VideoFormatBitrateType(val rawName: String, val rawValue: String) {
    CBR_96("96kbps", "96k"),
    CBR_112("112kbps", "112k"),
    CBR_128("128kbps", "128k"),
    CBR_160("160kbps", "160k"),
    CBR_192("192kbps", "192k"),
    CBR_256("256kbps", "256k"),
    CBR_320("320kbps", "320k")
}

// extension to AudioFormatType
fun String.toAudioFormatType(): AudioFormatType {
    return when (this) {
        AudioFormatType.WAV.extension -> AudioFormatType.WAV
        AudioFormatType.MP3.extension -> AudioFormatType.MP3
        AudioFormatType.AAC.extension -> AudioFormatType.AAC
        AudioFormatType.FLAC.extension -> AudioFormatType.FLAC
        AudioFormatType.WMA.extension -> AudioFormatType.WMA
        AudioFormatType.OGG.extension -> AudioFormatType.OGG
        AudioFormatType.AC3.extension -> AudioFormatType.AC3
        else -> AudioFormatType.MP3
    }
}

enum class AudioFormatType(val rawName: String, val extension: String, val rawType: String) {
    WAV("WAV", "wav", "pcm_s16le"),
    MP3("MP3", "mp3", "libmp3lame"),
    AAC("AAC", "aac", "aac"),
    FLAC("FLAC", "flac", "flac"),
    WMA("WMA", "wma", "libmp3lame"),
    OGG("OGG", "ogg", "vorbis"),
    AC3("AC3", "ac3", "ac3")
}

enum class VideoToMp3FormatType(val rawName: String, val extension: String, val value: String) {
    MP3("MP3", "mp3", "mp3"),
    AAC("AAC", "m4a", "aac"),
    WAV("WMA", "wma", "wma"),
    FLAC("FLAC", "flac", "flac"),
    WMA("WAV", "wav", "wav"),
    AC3("AC3", "ac3", "ac3"),
    OGG("OGG", "ogg", "vorbis"),
}

fun VideoToMp3FormatType.toVideoEditor(): VideoEditor {
    return VideoEditor.EMPTY.copy(
        formatText = rawName,
        formatValue = value,
        formatExtension = extension
    )
}
//
//enum class AudioFormatType(val rawName: String, val rawValue: String) {
//    MP3("MP3", ".mp3"),
//    WAV("WAV", ".wav"),
//    AAC("AAC", ".aac"),
//    AAC_FAST_CONVERSION("AAC (Fast Conversion)", ".aac"),
//    WMA("WMA", ".wma"),
//    FLAC("FLAC", ".flac"),
//    AC3("AC3", ".ac3"),
//    OGG("OGG", ".ogg"),
//}

enum class FormatBitrateType(val rawName: String, val rawValue: String) {
    CBR_32("32kb/s CBR", "32k"),
    CBR_64("64kb/s CBR", "64k"),
    CBR_96("64kb/s CBR", "64k"),
    CBR_128("128kb/s CBR", "128k"),
    CBR_192("192kb/s CBR", "192k"),
    CBR_256("256kb/s CBR", "256k"),
    CBR_320("320kb/s CBR", "320k"),
    VRB_130("130kb/s VRB (Slow)", ""),
    VRB_190("190kb/s VRB (Slow)", ""),
    VRB_245("245kb/s VRB (Slow)", ""),
}

enum class AudioFormatBitrateType(val rawName: String, val bitrate: String) {
    BT_96("96kb/s", "96k"),
    BT_112("112kb/s", "112k"),
    BT_128("128kb/s", "128k"),
    BT_160("160kb/s", "160k"),
    BT_192("192kb/s", "192k"),
    BT_256("256kb/s", "256k"),
    BT_320("320kb/s", "320k"),
}

enum class VideoFormatType(val rawName: String, val extension: String) {
    MP4("MP4", "mp4"),
    GB3("3GB", "3gp"),
    MOV("MOV", "mov"),
    FLV("FLV", "flv"),
    MKV("MKV", "mkv"),
    AVI("AVI", "avi"),
    M4V("M4V", "m4v"),
    MTS("MTS", "mts"),
    M2TS("M2TS", "m2ts"),
    TS("TS", "ts"),
}

// extension toVideoFormatType
fun String.toVideoFormatType(): VideoFormatType {
    return when (this) {
        VideoFormatType.MP4.extension -> VideoFormatType.MP4
        VideoFormatType.GB3.extension -> VideoFormatType.GB3
        VideoFormatType.MOV.extension -> VideoFormatType.MOV
        VideoFormatType.FLV.extension -> VideoFormatType.FLV
        VideoFormatType.MKV.extension -> VideoFormatType.MKV
        VideoFormatType.AVI.extension -> VideoFormatType.AVI
        VideoFormatType.M4V.extension -> VideoFormatType.M4V
        VideoFormatType.MTS.extension -> VideoFormatType.MTS
        VideoFormatType.M2TS.extension -> VideoFormatType.M2TS
        VideoFormatType.TS.extension -> VideoFormatType.TS
        else -> VideoFormatType.MP4
    }
}

fun Long.formatVideoTimeLib(): String {
    if (this <= 0 || this >= 24 * 60 * 60 * 1000) {
        return "00:00"
    }
    val totalSeconds = this / 1000
    val seconds = totalSeconds % 60
    val minutes = totalSeconds / 60 % 60
    val hours = totalSeconds / 3600
    val stringBuilder = StringBuilder()
    val formatter = Formatter(stringBuilder, Locale.getDefault())
    return if (hours > 0) {
        formatter.format("%d:%02d:%02d", hours, minutes, seconds).toString()
    } else {
        formatter.format("%02d:%02d", minutes, seconds).toString()
    }
}