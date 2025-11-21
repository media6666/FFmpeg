package com.inshot.videotomp3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

enum class VideoInfoParams(val rawValue: String) {
    VIDEO_SUPPORT_ENCODE("zz8lJi6I"),
    FREQUENCY("BPvnLrNG"),
    TITLE("JwX2n3bF"),
    ARTIST("aGR1Bsgw"),
    GENRE("n8jOmT4r"),
    ALBUM("xyQ0hlM0"),
    TRACK_NO("nb0OmT4N"),
    YEAR("bh4OmT5C"),
    AUDIO_SUPPORT_ENCODE("0SdJw2cS"),
    AUDIO_BITRATE("wOwYbNVc"),
    AUDIO_OUT_BITRATE("wOw1nNcL"),
    VIDEO_BITRATE("Ey2fCh0r"),
    VIDEO_OUT_BITRATE("b0pfCh4E"),
    DURATION("1UgQUfkN"),
    VIDEO_CODEC("DwOxyfPa"),
    WIDTH("IuHg0EbB"),
    HEIGHT("WX6V1ecJ"),
    ROTATE("1ecJWX6V"),
    AUDIO_CODEC("wszr2sAQ")
}

@Parcelize
data class VideoInfo(
    val videoSupportEncode: String,
    val frequency: String,
    val title: String,
    val artist: String,
    val genre: String,
    val album: String,
    val trackNo: String,
    val year: String,
    val audioSupportEncode: String,
    val audioBitrate: String,
    val audioOutBitrate: String,
    val videoBitrate: String,
    val videoOutBitrate: String,
    val duration: String,
    val videoCodec: String,
    val width: String,
    val height: String,
    val rotate: String,
    val audioCodec: String,
    val videoPath: String = "",
    val volume: Float = 1f
) : Parcelable {

    companion object {
        val EMPTY = VideoInfo(
            videoSupportEncode = "0",
            frequency = "",
            title = "",
            artist = "",
            genre = "",
            album = "",
            trackNo = "",
            year = "",
            audioSupportEncode = "0",
            audioBitrate = "",
            videoBitrate = "",
            videoCodec = "",
            videoOutBitrate = "",
            width = "",
            height = "",
            rotate = "",
            audioCodec = "",
            audioOutBitrate = "",
            duration = ""
        )
    }

    fun isFileError(): Boolean {
        return stringToInt(width) == 0
            && stringToInt(height) == 0
            && stringToLong(duration) == 0L
    }

    fun isVideoSupportEncode(): Boolean {
        return videoSupportEncode == "1"
    }

    fun isAudioSupportEncode(): Boolean {
        return audioSupportEncode == "1"
    }

    fun videoSizeText(): String {
        return String.format("%s x %s", width, height)
    }

    val bitrate get() = stringToInt(videoOutBitrate) - stringToInt(audioBitrate)

    fun getSizeVideo(): Pair<Int, Int> {
        val width = stringToInt(width)
        val height = stringToInt(height)
        return if (stringToInt(rotate) % 180 != 0) {
            Pair(height, width)
        } else {
            Pair(width, height)
        }
    }
}


fun Map<String, String>.toVideoInfo(videoPath: String): VideoInfo {
    return VideoInfo(
        videoPath = videoPath,
        videoSupportEncode = getOrDefault(VideoInfoParams.VIDEO_SUPPORT_ENCODE.rawValue, "1"),
        frequency = getOrDefault(VideoInfoParams.FREQUENCY.rawValue, ""),
        title = getOrDefault(VideoInfoParams.TITLE.rawValue, ""),
        artist = getOrDefault(VideoInfoParams.ARTIST.rawValue, ""),
        genre = getOrDefault(VideoInfoParams.GENRE.rawValue, "Unknown"),
        album = getOrDefault(VideoInfoParams.ALBUM.rawValue, ""),
        trackNo = getOrDefault(VideoInfoParams.TRACK_NO.rawValue, ""),
        year = getOrDefault(VideoInfoParams.YEAR.rawValue, ""),
        audioSupportEncode = getOrDefault(VideoInfoParams.AUDIO_SUPPORT_ENCODE.rawValue, ""),
        audioBitrate = getOrDefault(VideoInfoParams.AUDIO_BITRATE.rawValue, ""),
        audioOutBitrate = getOrDefault(VideoInfoParams.AUDIO_OUT_BITRATE.rawValue, ""),
        videoBitrate = getOrDefault(VideoInfoParams.VIDEO_BITRATE.rawValue, ""),
        videoOutBitrate = getOrDefault(VideoInfoParams.VIDEO_OUT_BITRATE.rawValue, ""),
        duration = getOrDefault(VideoInfoParams.DURATION.rawValue, "0"),
        videoCodec = getOrDefault(VideoInfoParams.VIDEO_CODEC.rawValue, ""),
        width = getOrDefault(VideoInfoParams.WIDTH.rawValue, "0"),
        height = getOrDefault(VideoInfoParams.HEIGHT.rawValue, "0"),
        rotate = getOrDefault(VideoInfoParams.ROTATE.rawValue, "0"),
        audioCodec = getOrDefault(VideoInfoParams.AUDIO_CODEC.rawValue, "")
    )
}

fun String.toMapVideo(): Map<String, String> {
    val hashMap = HashMap<String, String>()
    split(",").forEach { split2 ->
        val split3 = split2.split("=")
        if (split3.size == 2) {
            hashMap[split3[0]] = split3[1]
        }
    }
    return hashMap
}

@Parcelize
data class DataForSpeedVideo(
    val isMute: Boolean,
    val speed: Float,
    val videoInfo: VideoInfo
) : Parcelable {
    companion object {
        val EMPTY = DataForSpeedVideo(
            isMute = true,
            speed = 1.0f,
            videoInfo = VideoInfo.EMPTY
        )
    }
}

@Parcelize
data class DataForCompressVideo(
    val fileName: String,
    val newWidth: Int,
    val newHeight: Int,
    val percentScale: Int,
    val videoInfo: VideoInfo
) : Parcelable {
    companion object {
        val EMPTY = DataForCompressVideo(
            fileName = "",
            newHeight = 0,
            newWidth = 0,
            percentScale = 1,
            videoInfo = VideoInfo.EMPTY
        )
    }
}

//data class VideoDataForMerge(
//    val volume: Float,
//    val ratio
//)
enum class MergeType(val rawValue: Int) {
    SEQUENCE(1), LEFT_RIGHT(2), TOP_BOTTOM(3)
}

@Parcelize
data class DataForMergeVideo(
    val fileName: String,
    val listVideoInfo: List<VideoInfo>,
    val mutePath: String,
    val newWidth: Int,
    val newHeight: Int,
    val mergeType: Int,
    val mergeTypePlayVideo: Int,
    val ratioWidth: Int,
    val ratioHeight: Int,
    val totalDuration: Long,
    val volumeList: List<Float>
) : Parcelable {

    // mergeTypePlayVideo == 5 là Sequence , --> Lần lượt
    // mergeTypePlayVideo --> cùng 1 lúc
    //mergeType theo thứ tự giống bọn nó. 1,2,3
    companion object {
        val EMPTY = DataForMergeVideo(
            fileName = "",
            newHeight = 0,
            newWidth = 0,
            mergeType = 1,
            mergeTypePlayVideo = 5,
            ratioWidth = 0,
            ratioHeight = 0,
            totalDuration = 0,
            volumeList = emptyList(),
            mutePath = "",
            listVideoInfo = emptyList()
        )
    }

    fun isLeftRight(): Boolean {
        return mergeType == 2
    }

    fun isTopBottom(): Boolean {
        return mergeType == 3
    }

    fun isSequence(): Boolean {
        return mergeType == 1
    }

    fun isSequencePlayVideo(): Boolean {
        return mergeTypePlayVideo == 5
    }
}


@Parcelize
data class DataForConvertVideo(
    val newExtension: String,
    val videoInfo: VideoInfo
) : Parcelable {
    companion object {
        val EMPTY = DataForConvertVideo(
            newExtension = "",
            videoInfo = VideoInfo.EMPTY
        )
    }
}

@Parcelize
data class DataForVideoCutter(
    val fileName: String,
    val startTime: Long,
    val endTime: Long,
    val widthResolution: Int,
    val heightResolution: Int,
    val stable: Boolean, // Có 2 loại. 1 là stable thì bình thường, 2 là  fast convert
    val volume: Float = 1.0f,
) : Parcelable {
    companion object {
        val EMPTY = DataForVideoCutter(
            startTime = 0,
            endTime = 0,
            widthResolution = 0,
            heightResolution = 0,
            stable = false,
            volume = 1.0f,
            fileName = ""
        )
    }
}

@Parcelize
data class DataForMergeAudio(
    val command: String,
    val frequency: Int,
    val bitrate: Int,
    val durationTotal: Long,
    val listPath: List<String>
) : Parcelable {
    companion object {
        val EMPTY = DataForMergeAudio(
            command = "",
            frequency = 44100,
            bitrate = 128000,
            durationTotal = 0,
            listPath = emptyList()
        )
    }
}