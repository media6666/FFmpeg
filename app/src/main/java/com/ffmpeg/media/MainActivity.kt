package com.ffmpeg.media

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.inshot.videotomp3.FFmpegMedia

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FFmpegMedia.getInstance().initLib { loaded ->
            Log.e("LIB loaded", "$loaded")
        }
        val input = ""
        val output = "output"
        val cmd = "-i $input -ss 00:00:05 -to 00:00:12 -c copy $output"
        val commandArray = cmd.split(" ").toTypedArray()

//        FFmpegMedia.getInstance().run(
//            command = commandArray,
//            durationTotal = 10, //  duration audio,
//            progressCallBack = progressCallBack
//        )
    }
}