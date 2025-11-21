package com.inshot.videotomp3

interface ProgressCallBack {
    fun progress(path: String, progress: Int, msg: String = "Converting...")
}