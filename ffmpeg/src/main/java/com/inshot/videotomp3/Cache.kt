package com.inshot.videotomp3

import android.content.Context
import android.os.Build
import android.os.Environment

fun Context.cacheDirThumb(): String {
    val externalCacheDir = externalCacheDir
    if (externalCacheDir != null) {
        return externalCacheDir.absolutePath
    }
    val cacheDir = cacheDir ?: return ""
    val cachePath = cacheDir.absolutePath
    if (Build.VERSION.SDK_INT >= 30) {
        return "$cachePath/VideoToMp3/.cache"
    }
    return Environment.getExternalStorageDirectory().absolutePath + "/VideoToMp3/.cache"
}