package com.inshot.videotomp3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlin.math.max
import kotlin.math.min

enum class AudioInfoParams(val rawValue: String) {
    DURATION("1UgQUfkN"),
    OUT_BITRATE("wOw1nNcL"),
    FREQUENCY("BPvnLrNG"),
    BITRATE("wOwYbNVc"),
    FORMAT_EXTENSION("wszr2sAQ"),
    CHANNEL("taUcSkao"),
    TITLE("JwX2n3bF"),
    ARTIST("aGR1Bsgw"),
    ALBUM("xyQ0hlM0"),
    GENRE("n8jOmT4r"),
    TRACK_NO("nb0OmT4N"),
    YEAR("bh4OmT5C"),
}

@Parcelize
data class AudioInfo(
    val channel: String,
    val title: String,
    val artist: String,
    val album: String,
    val genre: String,
    val trackNo: String,
    val year: String,
    val frequency: String,
    val bitrate: String,
    val outBitrate: String,
    val formatExtension: String,
    val duration: Long,
) : Parcelable {
    companion object {
        val EMPTY = AudioInfo(
            channel = "",
            title = "",
            artist = "",
            album = "",
            genre = "",
            trackNo = "",
            year = "",
            frequency = "",
            bitrate = "",
            outBitrate = "",
            formatExtension = "",
            duration = 0L
        )
    }

    fun haveItemBitrateInAudioCutter(): Boolean {
        val audioBitrateData = stringToLong(bitrate, -1)
        return audioBitrateData in 1..999999
    }

    fun getAudioBitrateText(): String {
        val audioBitrate = bitrate.toIntOrNull() ?: -1
        return if (audioBitrate > 0) {
            "${audioBitrate / 1000}kb/s"
        } else {
            "${bitrate}b/s"
        }
    }
}

// cái này chỉ dùng cho audio info
fun String.toMap(): Map<String, String> {
    val hashMap = HashMap<String, String>()
    split(",").forEach { split2 ->
        val split3 = split2.split("=")
        if (split3.size == 2) {
            hashMap[split3[0]] = split3[1]
        }
    }
    return hashMap
}

fun Map<String, String>.toAudioInfo(): AudioInfo {
    return AudioInfo(
        channel = getOrDefault(AudioInfoParams.CHANNEL.rawValue, ""),
        title = getOrDefault(AudioInfoParams.TITLE.rawValue, ""),
        artist = getOrDefault(AudioInfoParams.ARTIST.rawValue, ""),
        album = getOrDefault(AudioInfoParams.ALBUM.rawValue, ""),
        genre = getOrDefault(AudioInfoParams.GENRE.rawValue, ""),
        trackNo = getOrDefault(AudioInfoParams.TRACK_NO.rawValue, ""),
        year = getOrDefault(AudioInfoParams.YEAR.rawValue, ""),
        frequency = getOrDefault(AudioInfoParams.FREQUENCY.rawValue, ""),
        bitrate = getOrDefault(AudioInfoParams.BITRATE.rawValue, ""),
        formatExtension = getOrDefault(AudioInfoParams.FORMAT_EXTENSION.rawValue, ""),
        duration = getOrDefault(AudioInfoParams.DURATION.rawValue, "0").toLongOrNull() ?: 0,
        outBitrate = getOrDefault(AudioInfoParams.OUT_BITRATE.rawValue, "")
    )
}

fun getCorrectFrequency(currentFrequency: String, formatExtension: String): Int {
    val iArr = listFrequency
    val frequencyDefault = iArr[3]
    val checkFrequency = frequencyToInOrDefault(currentFrequency, frequencyDefault)
    val value = if ("mp3" == formatExtension || "ac3" == formatExtension) {
        min(checkFrequency, frequencyDefault)
    } else {
        min(checkFrequency, 96000)
    }
    return max(value, iArr[0])
}

fun frequencyToInOrDefault(frequency: String, frequencyDefault: Int): Int {
    return frequency.toIntOrNull() ?: frequencyDefault
}