package com.inshot.videotomp3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoEditor(
    val fileName: String,
    val videoEditorTag: VideoEditorTag,
    val startTime: Long,
    val endTime: Long,
    val frequency: Int,
    val channel: Int,
    val fadeInt: Float,
    val fadeOut: Float,
    val volume: Float,
    val bitrate: String,
    val formatValue: String,
    val formatExtension: String,
    val formatText: String,
    val positionSelectedFormat: Int,
    val isRetainFormatAndBitrate: Boolean,
    val coverPath: String,
    val inputPath: String
) : Parcelable {
    companion object {
        val EMPTY = VideoEditor(
            fileName = "videoToMp3",
            videoEditorTag = VideoEditorTag.EMPTY,
            startTime = 0,
            endTime = 0,
            frequency = 44100,
            channel = 2,
            fadeInt = 0f,
            fadeOut = 0f,
            volume = 1.0f,
            formatText = "MP3",
            bitrate = "128k",
            formatValue = "mp3",
            formatExtension = "mp3",
            isRetainFormatAndBitrate = false,
            coverPath = "",
            positionSelectedFormat = 0,
            inputPath = ""
        )
    }

    fun hasCutter(duration: Long): Boolean {
        return startTime != 0L || (endTime != duration && endTime != 0L)
    }

    fun formatTime(): String {
        return (endTime - startTime).formatVideoTimeLib()
    }

    fun hasCover(): Boolean {
        return coverPath.isNotBlank() && isShowCover()
    }

    fun isShowCover(): Boolean {
        return formatExtension == "mp3"
    }

    fun isOgg(): Boolean {
        return formatExtension == "ogg"
    }
}

@Parcelize
data class VideoEditorTag(
    val title: String,
    val artist: String,
    val album: String,
    val trackNo: String,
    val genre: String,
    val year: String
) : Parcelable {

    companion object {
        val EMPTY = VideoEditorTag(
            title = "",
            artist = "",
            album = "",
            trackNo = "",
            genre = "",
            year = ""
        )
    }

    fun getCorrectGenre(): String {
        return if (genre == "Unknown") "" else genre
    }
}

//Unknown value  = null
val listGenre = arrayOf(
    "Unknown",
    "Classical",
    "Blues",
    "Country",
    "Disco",
    "Hip-Hop",
    "Jazz",
    "Metal",
    "Pop",
    "R&B",
    "Rap",
    "Rock",
    "Electronic",
    "Folk",
    "JPOP",
    "KPOP",
    "Other"
)


val listBitrateTextVideo = arrayOf(
    "32kb/s CBR",
    "64kb/s CBR",
    "128kb/s CBR",
    "192kb/s CBR",
    "256kb/s CBR",
    "320kb/s CBR",
    "130kb/s VBR(slow)",
    "190kb/s VBR(slow)",
    "245kb/s VBR(slow)"
)

val listBitrateValueVideoToMp3 =
    arrayOf("32k", "64k", "128k", "192k", "256k", "320k", "130k", "190k", "245k")

val listAudioFormatText2 =
    arrayOf("MP3", "AAC", "AAC(Fast Conversion)", "WMA", "FLAC", "WAV", "AC3", "OGG")
val listAudioFormatExtension2 = arrayOf("mp3", "m4a", "m4a", "wma", "flac", "wav", "ac3", "ogg")
val listAudioFormatValue2 = arrayOf("mp3", "aac", "copy", "wma", "flac", "wav", "ac3", "vorbis")


val listAudioFormatText = arrayOf("MP3", "AAC", "WMA", "FLAC", "WAV", "AC3", "OGG")
val listAudioFormatExtension = arrayOf("mp3", "m4a", "wma", "flac", "wav", "ac3", "ogg")
val listAudioFormatValue = arrayOf("mp3", "aac", "wma", "flac", "wav", "ac3", "vorbis")

val listAudioFormatTextCutter = arrayOf("MP3", "AAC")


val listAudioCutterFormatValue = arrayOf("mp3", "aac", "copy")

val listValueChannel = intArrayOf(2, 1)

val listTypeFormatAudio =
    arrayOf("pcm_s16le", "libmp3lame", "aac", "flac", "libmp3lame", "vorbis", "ac3")

val listFrequency = intArrayOf(8000, 16000, 22050, 44100, 48000)


val listFormatExtensionVideo =
    arrayOf("mp4", "3gp", "mov", "flv", "mkv", "avi", "m4v", "mts", "m2ts", "ts")


fun listDataFormatVideo(): HashMap<String, List<List<String>>> {
    val hashMap = HashMap<String, List<List<String>>>()
    val strArr = listFormatExtensionVideo
    hashMap[strArr[0]] = mergeList(
        listOf("h264", "hevc", "mpeg4"),
        listOf("aac", "mp3", "ac3", "mp2")
    )
    hashMap[strArr[1]] = mergeList(
        listOf("h264", "mpeg4", "h263"),
        listOf("aac", "amr_nb", "amr_wb")
    )
    hashMap[strArr[2]] = mergeList(
        listOf("h264", "mpeg4", "msmpeg4v3"),
        listOf("aac", "mp3")
    )
    hashMap[strArr[3]] = mergeList(
        listOf("flv1", "h264"),
        listOf("aac", "mp3")
    )
    hashMap[strArr[4]] = mergeList(
        listOf("h264", "hevc", "msmpeg4v3"),
        listOf("aac", "mp3", "ac3", "flac", "ttag")
    )
    hashMap[strArr[5]] = mergeList(
        listOf("h264", "hevc", "mpeg4", "wmv3", "wmv2"),
        listOf("aac", "mp3", "ac3", "flac", "wmav2")
    )
    hashMap[strArr[6]] = mergeList(
        listOf("h264", "mpeg4"),
        listOf("aac", "ac3")
    )
    hashMap[strArr[7]] = mergeList(
        listOf("mpeg2video"),
        listOf("mp2", "ac3", "aac")
    )
    hashMap[strArr[8]] = mergeList(
        listOf("mpeg2video"),
        listOf("mp2", "ac3", "aac")
    )
    hashMap[strArr[9]] = mergeList(
        listOf("mpeg2video"),
        listOf("mp2", "aac")
    )
    return hashMap
}

private fun mergeList(list: List<String>, list2: List<String>): List<List<String>> {
    val arrayList: ArrayList<List<String>> = ArrayList()
    arrayList.add(0, list)
    arrayList.add(1, list2)
    return arrayList
}




