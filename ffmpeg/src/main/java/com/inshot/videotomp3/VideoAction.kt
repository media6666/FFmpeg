package com.inshot.videotomp3

import android.content.Context
import android.text.TextUtils
import android.util.Log
import s62
import java.io.File
import java.io.IOException
import kotlin.math.max


class VideoAction {
    companion object : OnlySingletonHolder<VideoAction>(::VideoAction)

    private var libLoaded: Boolean = false

    init {
        try {
            System.loadLibrary("ijkffmpeg")
            System.loadLibrary("isvideolib")
            libLoaded = true
        } catch (e: UnsatisfiedLinkError) {
            libLoaded = false
            Log.e("Init lib error", e.message.orEmpty())
        }
    }

    fun initLib(callback: (Boolean) -> Unit) {
        if (libLoaded) {
            callback.invoke(true)
        } else {
            callback.invoke(false)
        }
    }

    val loadedVideoLib get() = libLoaded

    fun setCancelFlag(flag: Int = 9527) {
        if (loadedVideoLib) {
            VideoLib.setCancelFlag(flag)
        }
    }

    fun runCommand(
        command: Array<String>,
        outputPath: String,
        durationTotal: Long,
        progressCallBack: ProgressCallBack
    ): Int {
        setConvertListener(durationTotal, outputPath, progressCallBack)
        return VideoLib.runMultiCommands(command)
    }

    fun runVideoToMp3(
        context: Context,
        inputPath: String,
        outputPath: String,
        durationTotal: Long,
        videoInfo: VideoInfo,
        videoEditor: VideoEditor,
        progressCallBack: ProgressCallBack
    ): Int {
        // TODO check lại startTime, endTime, FadeIn, FadeOut xem đã đúng là giá trị second chưa
        setConvertListener(durationTotal, inputPath, progressCallBack)
        val startTimeInMil = videoEditor.startTime
        val endTimeInMil = videoEditor.endTime
        val startTime = startTimeInMil / 1000f
        val length = (endTimeInMil - startTimeInMil) / 1000f

        val sb = StringBuilder()
        val volume = videoEditor.volume
        val fadeIn = videoEditor.fadeInt
        val fadeOut = videoEditor.fadeOut
        if (volume != 1.0f) {
            sb.append("volume=$volume")
            if (fadeIn > 0 || fadeOut > 0) {
                sb.append(",")
            }
        }
        if (fadeIn > 0) {
            sb.append("afade=in:st=$startTime")
            sb.append(":d=$fadeIn")
            if (fadeOut > 0) {
                sb.append(",")
            }
        }
        if (fadeOut > 0) {
            sb.append("afade=out:st=${endTimeInMil - fadeOut}")
            sb.append(":d=$fadeOut")
        }
        val command = sb.toString()
        val currentAudioBitrate = stringToLong(videoInfo.audioBitrate)
        val audioBitrate = if (videoEditor.isRetainFormatAndBitrate) {
            if (currentAudioBitrate > 0) {
                videoInfo.audioBitrate
            } else {
                videoEditor.bitrate
            }
        } else {
            videoEditor.bitrate
        }

        val correctFormatValue = if (videoEditor.isRetainFormatAndBitrate) {
            val audioCodec = videoInfo.audioCodec
            val indexOfAudioCodec = listAudioFormatExtension.indexOfFirst {
                it == audioCodec
            }
            if (indexOfAudioCodec != -1) {
                listAudioFormatValue[indexOfAudioCodec]
            } else {
                "mp3"
            }
        } else {
            videoEditor.formatValue
        }
        val list = listOf(
            inputPath,
            outputPath,
            startTime.toString(),
            length.toString(),
            correctFormatValue,
            audioBitrate,
            correctFrequency(videoEditor, videoInfo).toString(),
            videoEditor.channel.toString(),
            command,
            videoEditor.videoEditorTag.title,
            videoEditor.videoEditorTag.artist,
            videoEditor.videoEditorTag.album,
            videoEditor.videoEditorTag.genre,
            videoEditor.videoEditorTag.trackNo,
            videoEditor.videoEditorTag.year
        )
        return VideoLib.toMp3(
            inputPath,
            outputPath,
            startTime.toString(),
            length.toString(),
            correctFormatValue,
            audioBitrate,
            correctFrequency(videoEditor, videoInfo).toString(),
            videoEditor.channel.toString(),
            command,
            videoEditor.videoEditorTag.title,
            videoEditor.videoEditorTag.artist,
            videoEditor.videoEditorTag.album,
            videoEditor.videoEditorTag.genre,
            videoEditor.videoEditorTag.trackNo,
            videoEditor.videoEditorTag.year
        )
    }

    fun getAudioInfo(inputPath: String): String {
        return VideoLib.nativeGetAudioInfo(inputPath)
    }


    fun formatAudio(
        inputPath: String,
        outputPath: String,
        audioFormatExtension: String,
        durationTotal: Long,
        audioInfo: AudioInfo,
        progressCallBack: ProgressCallBack
    ): Int {
        setConvertListener(durationTotal, inputPath, progressCallBack)
        val audioFormatType = audioFormatExtension.toAudioFormatType()
        val channel = if (audioFormatType == AudioFormatType.OGG) {
            listValueChannel[0]
        } else {
            audioInfo.channel.ifBlank { listValueChannel[1] }
        }
        val frequency = getCorrectFrequency(audioInfo.frequency, audioFormatExtension)
        return VideoLib.formatAudio(
            inputPath,
            outputPath,
            audioFormatType.rawType,
            audioInfo.bitrate,
            frequency.toString(),
            channel.toString(),
            audioInfo.title,
            audioInfo.artist,
            audioInfo.album,
            audioInfo.genre,
            audioInfo.trackNo,
            audioInfo.year
        )
    }

    fun getNativeErrorMessage(resultCode: Int): String {
        return VideoLib.nativeErrorMessage(resultCode)
    }

    private fun setConvertListener(
        durationTotal: Long, inputPath: String, progressCallBack: ProgressCallBack
    ) {
        VideoLib.setConvertListener(object : ConvertListener {
            override fun progress(progress: Long) {
                val correctProgress =
                    if (progress * 100 / durationTotal > 100) 0 else progress * 100 / durationTotal
                progressCallBack.progress(inputPath, correctProgress.toInt())
            }
        })
    }

    fun removeConvertListener() {
        VideoLib.removeConvertListener()
    }

    fun getVideoInfo(inputPath: String): String {
        return VideoLib.nativeGetVideoInfo(inputPath)
    }

    fun formatVideo(
        inputPath: String,
        outputPath: String,
        newExtensionVideo: String,
        videoInfo: VideoInfo,
        durationTotal: Long,
        progressCallBack: ProgressCallBack
    ): Int {
        setConvertListener(durationTotal, inputPath, progressCallBack)
        val videoFormatType = newExtensionVideo.toVideoFormatType()
        val fileInputPath = File(inputPath)
        val currentExtension = fileInputPath.extension
        val audioExtension = videoInfo.audioCodec
        val audioBitrate = if (audioExtension == "mp3") {
            "44100"
        } else {
            ""
        }
        val listDataFormatVideo = listDataFormatVideo()[newExtensionVideo].orEmpty()
        val listDataCodex = listDataFormatVideo.firstOrNull().orEmpty()
        val vCodec = if (currentExtension == "avi" && "h264" == videoInfo.videoCodec) {
            "h264"
        } else if (listDataCodex.contains(videoInfo.videoCodec)) {
            "copy"
        } else {
            listDataCodex.getOrNull(0).orEmpty()
        }
        val listAudioFormatType = listDataFormatVideo.getOrNull(1).orEmpty()
        val aCodec = if (listAudioFormatType.contains(videoInfo.audioCodec)) {
            if (audioBitrate.isBlank()) {
                "copy"
            } else {
                "mp3"
            }
        } else {
            listAudioFormatType.getOrNull(0).orEmpty()
        }
        return VideoLib.formatVideo(
            inputPath,
            outputPath,
            newExtensionVideo,
            vCodec,
            aCodec,
            newExtensionVideo,
            audioBitrate
        )
    }

    fun compressVideo(
        inputPath: String,
        outputPath: String,
        newWidth: Int,
        newHeight: Int,
        videoInfo: VideoInfo,
        percentScale: Int,
        durationTotal: Long,
        progressCallBack: ProgressCallBack
    ): Int {
        val fileInputPath = File(inputPath)
        if (checkFileBeforeAction(fileInputPath).not()) {
            return -1
        }
        setConvertListener(durationTotal, inputPath, progressCallBack)
        val currentAudioCodecExtension = videoInfo.audioCodec
        val var6 = "aac"
        var audioCodecExtension =
            if (!"aac".equals(currentAudioCodecExtension, ignoreCase = true) && !"ac3".equals(
                    currentAudioCodecExtension, ignoreCase = true
                )
            ) {
                "aac"
            } else {
                "copy"
            }

        var z2 = false
        var z3 = false
        val currentExtension = File(inputPath).extension
        if ("m2ts".equals(currentExtension, ignoreCase = true) || "mts".equals(
                currentExtension, ignoreCase = true
            ) || "ts".equals(currentExtension, ignoreCase = true)
        ) {
            if ("aac".equals(currentAudioCodecExtension, ignoreCase = true)) {
                audioCodecExtension = var6
            }
            if ("ac3".equals(
                    currentAudioCodecExtension, ignoreCase = true
                ) || "mp2" == currentAudioCodecExtension
            ) {
                z2 = true
                z3 = true
            }
        } else {
            z2 = false
            z3 = false
        }
        val rotate = stringToInt(videoInfo.rotate, 0)
        val (width, height) = if (rotate % 180 != 0) {
            Pair(newHeight, newWidth)
        } else {
            Pair(newWidth, newHeight)
        }
        val command = StringBuilder()
        command.append("scale=")
        command.append(width)
        command.append(":")
        command.append(height)
        val currentLengthFile = fileInputPath.length()
        val lengthText = if (currentLengthFile > 10485760L) {
            formatLength(currentLengthFile)
        } else {
            "10M"
        }
        val bitrate =
            stringToInt(videoInfo.videoOutBitrate, 0) - stringToInt(videoInfo.audioBitrate, 0)
        val formatValue = formatNewLength(percentScale, bitrate, currentLengthFile)
        val formatValueText = "${formatValue}k"

        return VideoLib.compressVideo(
            inputPath,
            outputPath,
            audioCodecExtension,
            "h264",
            formatValueText,
            lengthText,
            command.toString(),
            false,
            z2,
            z3
        )
    }


    fun speedAudio(
        inputPath: String,
        outputPath: String,
        audioInfo: AudioInfo,
        speed: Float,
        durationTotal: Long,
        progressCallBack: ProgressCallBack
    ): Int {
        val fileInputPath = File(inputPath)
        if (checkFileBeforeAction(fileInputPath).not()) {
            return -1
        }
        setConvertListener(durationTotal, inputPath, progressCallBack)
        val frequency = getCorrectFrequency(audioInfo.frequency, fileInputPath.extension)
        var max = max(0, 100).toFloat() / 1000.0f
        var a = checkValue(durationTotal * 1.0f - 0, 1000.0f, 3)
        val command = StringBuilder()
        if (speed != 1.0f) {
            max = checkValue(max, speed, 3)
            a = checkValue(a, speed, 3)
        }
        if (speed < 0.5f) {
            command.append("atempo=0.5,atempo=")
            command.append(checkValue(speed, 0.5f, 2))
        } else if (speed > 2.0f) {
            command.append("atempo=2,atempo=")
            command.append(checkValue(speed, 2.0f, 2))
        } else {
            command.append("atempo=")
            command.append(speed)
        }

        val aCodec = compareAudioCodec(fileInputPath.extension, audioInfo.formatExtension)
        var bitrate = audioInfo.bitrate
        if (stringToInt(bitrate, 0) <= 1000 && audioInfo.outBitrate.isNotBlank()) {
            bitrate = audioInfo.outBitrate
        }
        val correctBitrate = stringToInt(bitrate, 128000)
        val list = listOf(
            inputPath,
            outputPath,
            max.toString(),
            a.toString(),
            aCodec,
            correctBitrate.toString(),
            frequency.toString(),
            command.toString()
        )
        return VideoLib.speedAudio(
            inputPath,
            outputPath,
            max.toString(),
            a.toString(),
            aCodec,
            correctBitrate.toString(),
            frequency.toString(),
            command.toString()
        )

    }

    fun speedVideo(
        inputPath: String,
        outputPath: String,
        videoInfo: VideoInfo,
        speed: Float,
        isMute: Boolean,
        durationTotal: Long,
        progressCallBack: ProgressCallBack
    ): Int {
        val fileInputPath = File(inputPath)
        if (checkFileBeforeAction(fileInputPath).not()) {
            return -1
        }
        setConvertListener(durationTotal, inputPath, progressCallBack)
        val videoOutBitrate = stringToInt(videoInfo.videoOutBitrate, -1)
        val data = if (videoOutBitrate > 0) {
            Math.round(videoOutBitrate.toFloat() / 1000.0f)
        } else {
            t(
                stringToInt(videoInfo.width),
                stringToInt(videoInfo.height),
                videoOutBitrate,
                stringToInt(videoInfo.width),
                stringToInt(videoInfo.height)
            )
        }
        val dataK = "${data}k"
        var bitrate = videoInfo.audioBitrate
        if (stringToInt(bitrate, 0) <= 1000 && videoInfo.audioOutBitrate.isNotBlank()) {
            bitrate = videoInfo.audioOutBitrate
        }
        val correctBitrate = "${(stringToInt(bitrate, 128000) / 1000)}k"
        val aCodec = compareAudioCodec(fileInputPath.extension, videoInfo.audioCodec)
        val command = StringBuilder()
        command.append("[0:v]setpts=(1/")
        command.append(speed)
        command.append(")*PTS[v]")
        if (aCodec.isNotBlank()) {
            command.append(";[0:a]")
            if (speed < 0.5f) {
                command.append("atempo=0.5,atempo=")
                command.append(checkValue(speed, 0.5f, 2))
            } else if (speed > 2.0f) {
                command.append("atempo=2,atempo=")
                command.append(checkValue(speed, 2.0f, 2))
            } else {
                command.append("atempo=")
                command.append(speed)
            }
            if (isMute) {
                command.append(",volume=")
                command.append(0.0f)
            }
            command.append("[a]")
        }
        if (aCodec.isNotBlank() && TextUtils.isEmpty(command) && isMute) {
            command.append("volume=")
            command.append(0.0f)
        }
        val frequency = stringToInt(videoInfo.frequency, 44100)
        val compareVideoCodec = compareVideoCodec(fileInputPath.extension, videoInfo.videoCodec)
        return VideoLib.speedVideo(
            inputPath,
            outputPath,
            compareVideoCodec,
            dataK,
            aCodec,
            correctBitrate,
            frequency.toString(),
            command.toString()
        )
    }

    fun cutVideo(
        inputPath: String,
        outputPath: String,
        videoInfo: VideoInfo,
        startTime: Long,
        endTime: Long,
        widthResolution: Int,
        heightResolution: Int,
        stable: Boolean, // Có 2 loại. 1 là stable thì bình thường, 2 là  fast convert
        volume: Float,
        durationTotal: Long,
        progressCallBack: ProgressCallBack
    ): Int {
        val fileInputPath = File(inputPath)
        if (checkFileBeforeAction(fileInputPath).not()) {
            return -1
        }
        setConvertListener(durationTotal, inputPath, progressCallBack)
        val rotate = stringToInt(videoInfo.rotate)
        val isVideoSupportEncode = videoInfo.isVideoSupportEncode()
        val videoCopy = stable.not() && isVideoSupportEncode

        //    val length = (stringToFloat(videoInfo.duration) - fromDuration) / 1000f
        val startTimeInSecond = startTime / 1000f
        val lengthInSecond = (endTime - startTime) / 1000f
        val commandVolume = if (volume != 1.0f) {
            String.format("volume=%s", volume)
        } else {
            ""
        }
        val valueSupportEncode = if (videoCopy) {
            30f
        } else {
            15f
        }
        val correctStartTime: Float
        val inputStartTime: String
        if (startTimeInSecond > valueSupportEncode) {
            inputStartTime = (startTimeInSecond - valueSupportEncode).toString()
            correctStartTime = valueSupportEncode
        } else {
            inputStartTime = ""
            correctStartTime = startTimeInSecond
        }

        var newWidth = widthResolution
        var newHeight = heightResolution

        val resolution = if (rotate % 180 != 0) {
            if (heightResolution % 2 == 1) {
                newHeight = heightResolution - 1
            }
            if (widthResolution % 2 == 1) {
                newWidth = widthResolution - 1
            }
            "${newHeight}x${newWidth}"
        } else {
            "${newWidth}x${newHeight}"
        }
        val audioSupportEncode = videoInfo.isAudioSupportEncode()
        val videoBitrate = if (videoCopy.not()) {
            "${
                s(
                    resolution.split("x").first().toInt(),
                    resolution.split("x")[1].toInt(),
                    stringToInt(videoInfo.videoBitrate, -1),
                    stringToInt(videoInfo.width),
                    stringToInt(videoInfo.height)
                )
            }k"
        } else {
            ""
        }

        val string = listOf(
            inputPath,
            outputPath,
            inputStartTime,
            correctStartTime.toString(),
            lengthInSecond.toString(),
            resolution,
            videoCopy,
            audioSupportEncode,
            videoBitrate,
            commandVolume,
            videoInfo.audioCodec
        ).joinToString(separator = ", ")

        return VideoLib.cutVideo(
            inputPath,
            outputPath,
            inputStartTime,
            correctStartTime.toString(),
            lengthInSecond.toString(),
            resolution,
            videoCopy,
            audioSupportEncode,
            videoBitrate,
            commandVolume,
            videoInfo.audioCodec
        )
    }

    fun audioCutter(
        inputPath: String,
        outputPath: String,
        selectFormatExtension: String = "mp3",
        startTimeCutter: Long,
        endTimeCutter: Long,
        volume: Float,
        fadeIn: Float,
        fadeOut: Float,
        speed: Float,
        positionSelectFormatExtension: Int,
        positionBitrate: Int, // user k chọn thì sẽ lấy audioBitrate
        audioInfo: AudioInfo,
        durationTotal: Long,
        progressCallBack: ProgressCallBack
    ): Int {
        val fileInputPath = File(inputPath)
        if (checkFileBeforeAction(fileInputPath).not()) {
            return -1
        }
        setConvertListener(
            durationTotal = durationTotal,
            inputPath = inputPath,
            progressCallBack = progressCallBack
        )
        //TODO check fadeIn fadeOut là Milisecond
        val frequency = compareFrequency(audioInfo.frequency, selectFormatExtension)
        var startTime = max(startTimeCutter, 100) / 1000.0f
        var lengthCutter = checkValue(endTimeCutter * 1.0f - startTimeCutter, 1000.0f, 3)
        val sb = StringBuilder()
        if (volume != 1.0f) {
            sb.append("volume=")
            sb.append(volume)
            if (fadeIn > 0 || fadeOut > 0 || speed != 1.0f) {
                sb.append(",")
            }
        }
        if (speed != 1.0f) {
            startTime = checkValue(startTime, speed, 3)
            lengthCutter = checkValue(lengthCutter, speed, 3)
            sb.append("atempo=")
            sb.append(speed)
            if (fadeIn > 0 || fadeOut > 0) {
                sb.append(",")
            }
        }
        if (fadeIn > 0) {
            sb.append("afade=in:st=")
            sb.append(startTime)
            sb.append(":d=")
            sb.append(fadeIn) //fadeInInSecond
            if (fadeOut > 0) {
                sb.append(",")
            }
        }
        if (fadeOut > 0) {
            val a2 = checkValue(endTimeCutter / 1000.0f, speed, 3)
            sb.append("afade=out:st=")
            sb.append(e(a2, fadeOut, 3)) //fadeOutInSecond
            sb.append(":d=")
            sb.append(fadeOut)
        }
        val audioBitrate = if (positionBitrate >= 0) {
            listBitrateValueVideoToMp3[positionBitrate]
        } else if (stringToLong(audioInfo.bitrate, 0) > 0) {
            audioInfo.bitrate
        } else {
            listBitrateValueVideoToMp3[2]
        }
        val command = sb.toString()
        val listOf = listOf(
            inputPath,
            outputPath,
            startTime.toString(),
            lengthCutter.toString(),
            audioBitrate,
            frequency.toString(),
            listAudioCutterFormatValue[positionSelectFormatExtension],
            command,
            audioInfo.title,
            audioInfo.artist,
            audioInfo.album,
            audioInfo.genre,
            audioInfo.trackNo,
            audioInfo.year
        )
        return VideoLib.cutAudio(
            inputPath,
            outputPath,
            startTime.toString(),
            lengthCutter.toString(),
            audioBitrate,
            frequency.toString(),
            listAudioCutterFormatValue[positionSelectFormatExtension],
            command,
            audioInfo.title,
            audioInfo.artist,
            audioInfo.album,
            audioInfo.genre,
            audioInfo.trackNo,
            audioInfo.year
        )
    }

    fun audioCutterMiddle(
        inputPath: String,
        outputPath: String,
        selectFormatExtension: String = "mp3",
        startTimeCutter: Long,
        endTimeCutter: Long,
        volume: Float,
        fadeIn: Float,
        fadeOut: Float,
        speed: Float,
        positionSelectFormatExtension: Int,
        positionBitrate: Int, // user k chọn thì sẽ lấy audioBitrate
        audioInfo: AudioInfo,
        durationTotal: Long,
        progressCallBack: ProgressCallBack
    ): Int {
        val fileInputPath = File(inputPath)
        if (checkFileBeforeAction(fileInputPath).not()) {
            return -1
        }
        setConvertListener(
            durationTotal = durationTotal,
            inputPath = inputPath,
            progressCallBack = progressCallBack
        )
        val duration = audioInfo.duration
        val durationInSecond = duration / 1000f
        var startTimeInSecond = startTimeCutter / 1000f
        val endTimeInSecond = endTimeCutter / 1000f
        if (endTimeInSecond - startTimeInSecond == durationInSecond && duration > 500) {
            startTimeInSecond = 0.5f
        }
        val frequency = compareFrequency(audioInfo.frequency, selectFormatExtension)
        val volumeText = if (volume != 1.0f) {
            volume.toString()
        } else {
            null
        }

        val speedText = if (speed != 1.0f) {
            speed.toString()
        } else {
            null
        }
        val sbFadeIn = StringBuilder()
        if (fadeIn > 0) {
            sbFadeIn.append("afade=t=in:st=")
            sbFadeIn.append(0.0f)
            sbFadeIn.append(":d=")
            sbFadeIn.append(fadeIn) //fadeInInSecond
        }
        val sbFadeOut = StringBuilder()
        if (fadeOut > 0) {
            val stFadeOut =
                (((startTimeCutter + duration) - endTimeCutter) - (fadeOut * 1000f)) / 1000f
            sbFadeOut.append("afade=t=out:st=")
            sbFadeOut.append(stFadeOut)
            sbFadeOut.append(":d=")
            sbFadeOut.append(fadeOut)
        }
        val audioBitrate = if (positionBitrate >= 0) {
            listBitrateValueVideoToMp3[positionBitrate]
        } else if (stringToLong(audioInfo.bitrate, 0) > 0) {
            audioInfo.bitrate
        } else {
            listBitrateValueVideoToMp3[2]
        }
        val commandFadeIn = sbFadeIn.toString()
        val commandFadeOut = sbFadeOut.toString()

        val listOf = listOf(
            inputPath,
            outputPath,
            startTimeInSecond.toString(),
            endTimeInSecond.toString(),
            durationInSecond.toString(),
            audioBitrate,
            frequency.toString(),
            listAudioCutterFormatValue[positionSelectFormatExtension],
            volumeText,
            speedText,
            commandFadeIn,
            commandFadeOut,
            audioInfo.title,
            audioInfo.artist,
            audioInfo.album,
            audioInfo.genre,
            audioInfo.trackNo,
            audioInfo.year
        )
        return VideoLib.cutMiddleAudio(
            inputPath,
            outputPath,
            startTimeInSecond.toString(),
            endTimeInSecond.toString(),
            durationInSecond.toString(),
            audioBitrate,
            frequency.toString(),
            listAudioCutterFormatValue[positionSelectFormatExtension],
            volumeText,
            speedText,
            commandFadeIn,
            commandFadeOut,
            audioInfo.title,
            audioInfo.artist,
            audioInfo.album,
            audioInfo.genre,
            audioInfo.trackNo,
            audioInfo.year
        )
    }

    fun addMp3Thumbnail(context: Context, inputPath: String, pathCover: String): String {
        try {
            val file = File(context.cacheDirThumb())
            if (file.exists().not()) {
                file.mkdirs()
            }
            val createTempFile = File.createTempFile("thumb", ".mp3", file)
            val resultCode =
                VideoLib.addMp3Thumbnail(inputPath, createTempFile.absolutePath, pathCover)
            if (resultCode == 0) {
                val file2 = File(inputPath)
                val renameTo = createTempFile.renameTo(file2)
                if (renameTo.not()) {
                    createTempFile.copyTo(file2)
                    createTempFile.delete()
                    return inputPath
                }
                return inputPath
            }
            createTempFile.delete()
            return inputPath
        } catch (e: IOException) {
            return inputPath
        }
    }

    fun mergeToMp3(
        listPath: List<String>,
        outputPath: String,
        dataForMergeAudio: DataForMergeAudio,
        progressCallBack: ProgressCallBack
    ): Int {
        setConvertListener(
            durationTotal = dataForMergeAudio.durationTotal,
            inputPath = outputPath,
            progressCallBack = progressCallBack
        )
        return VideoLib.mergerToMp3(
            listPath.toTypedArray(),
            outputPath,
            dataForMergeAudio.command,
            listPath.size.toString(),
            dataForMergeAudio.frequency.toString(),
            dataForMergeAudio.bitrate.toString()
        )
    }

    fun mergeVideo(
        listPath: List<VideoInfo>,
        outputPath: String,
        dataForMergeVideo: DataForMergeVideo,
        progressCallBack: ProgressCallBack
    ): Int {
        //TODO check videoWidth và videoHeight trước khi start
        setConvertListener(dataForMergeVideo.totalDuration, outputPath, progressCallBack)
        val outputWidth = dataForMergeVideo.newWidth
        val outputHeight = dataForMergeVideo.newHeight
        if (outputWidth == 0 || outputHeight == 0) {
            return -1
        }
        val command12 = StringBuilder()
        val command13 = StringBuilder()
        val command14 = StringBuilder()
        val command15 = StringBuilder()
        var videoNoAudio = false
        var i = 0
        val str1 = ":v]"
        val str2 = "["
        val size = listPath.size
        while (true) {
            if (i >= size) {
                break
            }
            val videoInfo = listPath[i]
            if (videoInfo.audioCodec.isBlank()) {
                videoNoAudio = true
            } else {
                val volumeVideo = dataForMergeVideo.volumeList.getOrNull(i) ?: 1f
                var volume = volumeVideo
                if (dataForMergeVideo.mergeTypePlayVideo == 4) {
                    volume = volumeVideo * size
                }
                command12.append("[")
                command12.append(i)
                command12.append(":a]")
                command12.append("atrim=duration=")
                command12.append(stringToLong(videoInfo.duration))
                command12.append(",volume=")
                command12.append(volume)
                command12.append("[a")
                command12.append(i + 1)
                command12.append("];")
            }
            if (dataForMergeVideo.isSequence()) {
                val compareData = s62.a(
                    videoInfo.getSizeVideo().first,
                    videoInfo.getSizeVideo().second,
                    outputWidth,
                    outputHeight
                )
                command13.append("[")
                command13.append(i)
                command13.append(":v]")
                command13.append("trim=duration=")
                command13.append(stringToLong(videoInfo.duration))
                command13.append(",scale=")
                command13.append(compareData.d())
                command13.append(":")
                command13.append(compareData.a())
                command13.append(",pad=")
                command13.append(outputWidth)
                command13.append(":")
                command13.append(outputHeight)
                command13.append(":");
                command13.append(compareData.b())
                command13.append(":");
                command13.append(compareData.c())
                command13.append(",setdar=dar=")
                command13.append(dataForMergeVideo.ratioWidth)
                command13.append("/")
                command13.append(dataForMergeVideo.ratioHeight)
                command13.append("[v");
                val var7 = i + 1
                command13.append(var7)
                command13.append("];")
                command15.append("[v")
                command15.append(var7)
                command15.append("]")
                val audioCodec = videoInfo.audioCodec
                val var24 = StringBuilder()
                var24.append("[a")
                var24.append(var7)
                var24.append("]")
                command14.append(s62.b1(audioCodec, size, var24.toString()))
            }
            i++
        }

        val var25 = StringBuilder()
        if (dataForMergeVideo.isSequence()) {
            var25.append(command12)
            var25.append(command14)
            var25.append("concat=n=")
            var25.append(size)
            var25.append(":v=0:a=1[a];")
            var25.append(command13)
            var25.append(command15)
            var25.append("concat=n=")
            var25.append(size)
            var25.append(":v=1:a=0[v]")
        }

        if (dataForMergeVideo.isLeftRight() || dataForMergeVideo.isTopBottom()) {
            val videoInfo1 = listPath[0]
            val videoInfo2 = listPath[1]
            val listData = if (dataForMergeVideo.isLeftRight()) {
                s62.d1(
                    videoInfo1.getSizeVideo().first,
                    videoInfo1.getSizeVideo().second,
                    videoInfo2.getSizeVideo().first,
                    videoInfo2.getSizeVideo().second,
                    outputWidth,
                    outputHeight
                )
            } else {
                s62.e(
                    videoInfo1.getSizeVideo().first,
                    videoInfo1.getSizeVideo().second,
                    videoInfo2.getSizeVideo().first,
                    videoInfo2.getSizeVideo().second,
                    outputWidth,
                    outputHeight
                )
            }
            if (dataForMergeVideo.mergeTypePlayVideo == 4) {
                command12.append(s62.b1(videoInfo1.audioCodec, size, "[a1]"));
                command12.append(s62.b1(videoInfo2.audioCodec, size, "[a2]"));
                command12.append("amix=inputs=2:duration=longest:dropout_transition=");
                command12.append(dataForMergeVideo.totalDuration)
                command12.append("[a];")
                var i1 = 0
                while (i1 < 2) {
                    command13.append("[")
                    command13.append(i1)
                    command13.append(":v]")
                    command13.append("trim=duration=")
                    command13.append(stringToLong(listPath[i1].duration))
                    command13.append(",scale=")
                    command13.append(listData[i1].d())
                    command13.append(":")
                    command13.append(listData[i1].a())
                    if (i1 == 0) {
                        command13.append(",pad=")
                        command13.append(outputWidth)
                        command13.append(":")
                        command13.append(outputHeight)
                        command13.append(":")
                        command13.append(listData[i1].b())
                        command13.append(":")
                        command13.append(listData[i1].c())
                    }
                    command13.append(",setdar=dar=")
                    command13.append(dataForMergeVideo.ratioWidth)
                    command13.append("/")
                    command13.append(dataForMergeVideo.ratioHeight)
                    command13.append("[v")
                    i1++
                    command13.append(i1)
                    command13.append("];")
                }
                command13.append("[v1][v2]overlay=")
                command13.append(listData[1].b())
                command13.append(":")
                command13.append(listData[1].c())
                command13.append("[v]")
            } else if (dataForMergeVideo.mergeTypePlayVideo == 5) {
                var i2 = 0
                while (i2 < 2) {
                    command13.append(str2)
                    command13.append(i2)
                    command13.append(str1)
                    command13.append("trim=duration=")
                    command13.append(stringToInt(listPath[i2].duration))
                    command13.append(",scale=")
                    command13.append(listData[i2].d())
                    command13.append(":")
                    command13.append(listData[i2].a())
                    command13.append(",pad=")
                    command13.append(outputWidth)
                    command13.append(":")
                    command13.append(outputHeight)
                    command13.append(":")
                    command13.append(listData[i2].b())
                    command13.append(":")
                    command13.append(listData[i2].c())
                    command13.append(",setdar=dar=")
                    command13.append(dataForMergeVideo.ratioWidth)
                    command13.append("/")
                    command13.append(dataForMergeVideo.ratioHeight)
                    command13.append("[v")
                    ++i2
                    command13.append(i2)
                    command13.append("];")
                }
                command13.append("[v1][v2]concat=n=2:v=1:a=0[v]")
                val var20 = s62.b1(videoInfo1.audioCodec, size, "[a1]")
                command12.append(var20)
                command12.append(s62.b1(videoInfo2.audioCodec, size, "[a2]"))
                command12.append("concat=n=2:v=0:a=1[a];")
            }
            var25.append(command12)
            var25.append(command13)
        }

        val pathMuteAudio = dataForMergeVideo.mutePath
//            if (videoNoAudio && File(dataForMergeVideo.mutePath).exists() && File(dataForMergeVideo.mutePath).isFile) {
//                dataForMergeVideo.mutePath
//            } else {
//                dataForMergeVideo.mutePath
//            }
        return VideoLib.mergeVideo(
            listPath.map { it.videoPath }.toTypedArray(),
            outputPath,
            videoNoAudio,
            var25.toString(),
            "aac",
            "44100",
            "128000",
            "libx264",
            pathMuteAudio
        )
    }
}