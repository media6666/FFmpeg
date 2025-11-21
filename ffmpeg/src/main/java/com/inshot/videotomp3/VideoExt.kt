package com.inshot.videotomp3

import android.text.TextUtils
import java.io.File
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.Locale
import kotlin.math.ceil
import kotlin.math.log10
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.roundToLong

enum class CompressVideoType(val percentScale: Int, val rawName: String) {
    SMALL(50, "Small File"), MEDIUM(75, "Medium File"), LARGE(100, "Large File"), CUSTOM(
        200,
        "Custom"
    )
}

fun checkFileBeforeAction(fileInputPath: File): Boolean {
    return fileInputPath.isFile && fileInputPath.exists() && fileInputPath.length() > 0
}

fun formatLength(length: Long): String {
    if (length <= 0) {
        return "0 B"
    }
    val d = length.toDouble()
    val log10 = (log10(d) / log10(1024.0)).toInt()
    return DecimalFormat("#,##0.#").format(d / 1024.0.pow(log10.toDouble())) + " " + arrayOf(
        "B", "kB", "MB", "GB", "TB"
    )[log10]
}

fun stringToInt(str: String, defaultValue: Int = 0): Int {
    return str.toIntOrNull() ?: defaultValue
}

fun stringToFloat(str: String, defaultValue: Float = 0f): Float {
    return str.toFloatOrNull() ?: defaultValue
}

fun stringToLong(str: String, defaultValue: Long = 0): Long {
    return str.toLongOrNull() ?: defaultValue
}

// lấy ra giá trị mới của length
fun formatNewLength(percentScale: Int, bitrate: Int, currentLengthFile: Long): Int {
    val i3 = percentScale + 10
    val f: Float = if (currentLengthFile < 5242880) {
        0.95f
    } else {
        0.8f
    }
    return min(
        ((i3.toFloat() / 100.0f).toDouble() * ceil(
            (percentScale.toFloat() / 100.0f * Math.round(
                bitrate.toFloat() * f / 1000.0f
            ).toFloat()).toDouble()
        )).toInt().toDouble(), (bitrate / 1000).toDouble()
    ).toInt()
}

fun formatVideoLength(percentScale: Int, bitrate: Int, duration: Long): Long {
    return if (bitrate == 0) {
        0
    } else ((duration.toFloat() / 60000.0f * (((percentScale + 10).toFloat() / 100.0f).toDouble() * ceil(
        (percentScale.toFloat() / 100.0f * (bitrate.toFloat() * 0.8f / 1000.0f).roundToLong()
            .toFloat()).toDouble()
    )).toInt().toFloat()).toDouble() * 0.0075 * 1024.0 * 1024.0).roundToLong()
}

fun checkValue(f: Float, f2: Float, i: Int): Float {
    if (i >= 0) {
        return BigDecimal(f.toString()).divide(BigDecimal(f2.toString()), i, 4).toFloat()
    }
    throw IllegalArgumentException("The scale must be a positive integer or zero")
}

fun e(f: Float, f2: Float, i: Int): Float {
    return BigDecimal(f.toString()).subtract(BigDecimal(f2.toString()))
        .setScale(i, 4).toFloat()
}

fun compareAudioCodec(str: String, str2: String): String {
    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
        return "aac"
    }
    if (("aac".equals(str, ignoreCase = true) || "m4a".equals(
            str, ignoreCase = true
        )) && !"aac".equals(str2, ignoreCase = true)
    ) {
        return "aac"
    }
    if ("flac".equals(str, ignoreCase = true) && !"flac".equals(str2, ignoreCase = true)) {
        return "flac"
    }
    if ("ogg".equals(str, ignoreCase = true) && !"vorbis".equals(str2, ignoreCase = true)) {
        return "vorbis"
    }
    if ("ac3".equals(str, ignoreCase = true) && !"ac3".equals(str2, ignoreCase = true)) {
        return "ac3"
    }
    return if ("mp4".equals(str2, ignoreCase = true)) {
        "aac"
    } else str2
}

fun compareVideoCodec(str: String, str2: String): String {
    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || listVideoCodecHevc().contains(str2)) {
        return "h264"
    }
    return if (!"flac".equals(str, ignoreCase = true) || "flac".equals(str2, ignoreCase = true)) {
        str2
    } else "flac"
}

fun listVideoCodecHevc(): ArrayList<String> {
    val arrayList = ArrayList<String>()
    arrayList.add("hevc")
    return arrayList
}

fun n(map: Map<String, String>): String {
    if (map.isEmpty()) {
        return ""
    }
    var str = map[AudioInfoParams.BITRATE.rawValue].orEmpty()
    if (stringToInt(str, 0) <= 1000 && map.containsKey(AudioInfoParams.OUT_BITRATE.rawValue)) {
        str = map[AudioInfoParams.OUT_BITRATE.rawValue].orEmpty()
    }
    return if (TextUtils.isEmpty(str)) {
        ""
    } else str
}

fun formatLargeOrCustomToNewSize(i: Int): Int {
    return i
}

fun formatMediumToNewSize(i: Int): Int {
    return d(75, i)
}

// cái này dùng để format sang size mới ở Dialog Select Size Video
fun formatSmallToNewSize(i: Int): Int {
    return d(50, i)
}

fun d(i: Int, i2: Int): Int {
    return checkValue((i.toFloat() / 100.0f * i2.toFloat()).toInt())
}

fun d(f: Float, f2: Float): Int {
    return BigDecimal(f.toString()).multiply(BigDecimal(f2.toString())).setScale(0, 4).toInt()
}

fun c(f: Float, f2: Float): Float {
    return BigDecimal(f.toString()).multiply(BigDecimal(f2.toString())).setScale(10, 4).toFloat()
}

fun b(f: Float, f2: Float): Int {
    return BigDecimal(f.toString()).divide(BigDecimal(f2.toString()), 0, 4).toInt()
}

fun checkValue(i: Int): Int {
    return if (i <= 0) i else i and -2
}

fun t(i: Int, i2: Int, i3: Int, i4: Int, i5: Int): Int {
    if (i3 <= 0 || i4 <= 0 || i5 <= 0) {
        return k(i, i2, 1000, 640, 640)
    }
    val k: Int = k(i, i2, i3, i4, i5)
    val k2: Int = k(i, i2, 500, 640, 640)
    if (k < k2) {
        return k2
    }
    val k3: Int = k(i, i2, 3000, 640, 640)
    return if (k > k3) {
        k3
    } else k
}

private fun k(i: Int, i2: Int, i3: Int, i4: Int, i5: Int): Int {
    return (i3.toLong() * i.toLong() * i2.toLong() / i4.toLong() / i5.toLong()).toInt()
}


fun formatDurationVideo(j: Long, z: Boolean): String {
    val i = (j / 1000).toInt()
    val i2 = i / 60
    val i3 = i2 / 60
    val i4 = i2 % 60
    var i5 = i % 60
    if (i3 == 0 && i4 == 0 && i5 == 0) {
        i5 = 0
    }
    return if (j < 3600000) {
        if (z) {
            String.format(Locale.ENGLISH, "%02d:%02d.%d", *arrayOf<Any>(i4, i5, j % 1000 / 100))
        } else String.format(Locale.ENGLISH, "%02d:%02d", *arrayOf<Any>(i4, i5))
    } else if (z) {
        String.format(Locale.ENGLISH, "%d:%02d:%02d.%d", *arrayOf<Any>(i3, i4, i5, j % 1000 / 100))
    } else {
        String.format(Locale.ENGLISH, "%d:%02d:%02d", *arrayOf<Any>(i3, i4, i5))
    }
}

fun s(i: Int, i2: Int, i3: Int, i4: Int, i5: Int): Int {
    if (i3 > 0 && i4 > 0 && i5 > 0) {
        val k: Int = k(i, i2, i3, i4, i5)
        val k2: Int = k(i, i2, 500, 640, 640)
        if (k < k2) {
            return k2
        }
        val k3: Int = k(i, i2, 3000, 640, 640)
        return if (k > k3) {
            k3
        } else k
    }
    return k(i, i2, 1000, 640, 640)
}

fun g(
    videoInfo: VideoInfo, resolutionWidth: Int, resolutionHeight: Int, isStable: Boolean, j: Long
): String {
    if (!isStable) {
        return formatLength((j * stringToLong(videoInfo.duration) / stringToLong(videoInfo.duration)))
    }
    val t: Int = s(
        resolutionWidth,
        resolutionHeight,
        stringToInt(videoInfo.videoBitrate, -1),
        stringToInt(videoInfo.width),
        stringToInt(videoInfo.height)
    )
    val i: Int = if (videoInfo.isAudioSupportEncode()) {
        var bitrate = videoInfo.audioBitrate
        if (stringToInt(bitrate, 0) <= 1000 && videoInfo.audioOutBitrate.isNotBlank()) {
            bitrate = videoInfo.audioOutBitrate
        }
        (stringToInt(bitrate, 128000) / 1000)
    } else {
        128
    }
    return formatLength(stringToLong(videoInfo.duration) * (t + i) / 8)
}

fun correctFrequency(videoEditor: VideoEditor, videoInfo: VideoInfo): Int {
    val frequency = videoEditor.frequency

    var bitrate = videoInfo.audioBitrate
    if (stringToInt(bitrate, 0) <= 1000 && videoInfo.audioOutBitrate.isNotBlank()) {
        bitrate = videoInfo.audioOutBitrate
    }

    val correctBitrate = if (videoEditor.formatValue == "copy") {
        "${stringToLong(bitrate) / 1000}k"
    } else {
        videoEditor.bitrate
    }
    if ("copy" == videoEditor.formatValue) {
        return frequency
    }
    val parseInt = correctBitrate.substring(0, correctBitrate.length - 1).toIntOrNull() ?: 0
    if (parseInt > 130) {
        return max(frequency, 44100)
    }
    if (parseInt > 100) {
        return max(frequency, 16000)
    }
    if ("ac3".equals(
            videoEditor.formatValue,
            ignoreCase = true
        ) && videoEditor.channel == 2 && parseInt < 64 && frequency >= 44100
    ) {
        return 22050
    }
    return frequency

}

fun compareFrequency(currentFrequency: String, selectFormatExtension: String): Int {
    val min: Int
    val iArr = listFrequency
    val defaultValue = iArr[3]
    val frequency = stringToInt(currentFrequency, defaultValue)
    min = if ("mp3" != selectFormatExtension && "ac3" != selectFormatExtension) {
        min(frequency, 96000)
    } else {
        min(frequency, defaultValue)
    }
    return max(min, iArr[0])
}

fun maxFrequencyForMerge(maxFrequencyInAudioList: Int): Int {
    if (maxFrequencyInAudioList == 0) {
        return 44100
    }
    return if (maxFrequencyInAudioList > 48000) {
        48000
    } else maxFrequencyInAudioList
}

fun maxBitrateForMerge(maxBitrateInAudioList: Int): Int {
    if (maxBitrateInAudioList == 0) {
        return 128000
    }
    return if (maxBitrateInAudioList > 320000) {
        320000
    } else maxBitrateInAudioList
}