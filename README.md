# FFmpeg : This is an open-source library, free to use in all applications. No license or permission is required.

**Android FFmpeg Library — Video/Audio Converter, Cutter, Merger, Mixer**

FFmpeg is a lightweight Android library and allows you to run any FFmpeg command directly from your Android app.

## Features
- Video to MP3
- Audio Cutter
- Audio Merger
- Audio Mixer
- Change speed / volume
- Video Cutter / Compressor
- Supports all FFmpeg custom commands

## Installation

### Step 1 — Add JitPack
In `settings.gradle`:
```gradle
dependencyResolutionManagement {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

### Step 2 — Add the dependency
```gradle
implementation("com.github.media6666:FFmpeg:1.12")
```

### Step 3 — Init
```
FFmpegMedia.getInstance().initLib { loaded ->
            Log.e("LIB loaded", "$loaded")
        }
```

## Usage

### Video → MP3
```kotlin
        val cmd = "-i ${videoPath} -vn -ar 44100 -ac 2 -b:a 192k ${outputPath}"
        val commandArray = cmd.split(" ").toTypedArray()
        FFmpegMedia.getInstance().run(
            command = commandArray,
            durationTotal = 10, //  duration audio,
            progressCallBack = progressCallBack
        )
```

### Audio Cutter
```kotlin
val cmd = "-i $input -ss 00:00:05 -to 00:00:12 -c copy $output"
        FFmpegMedia.getInstance().run(
            command = arrayOf(""),
            durationTotal = 10, // total duration,
            progressCallBack = progressCallBack
        )
```

### Merge 2 Audio Files
```kotlin
        val cmd = "-i $input1 -i $input2 -filter_complex amix=inputs=2:duration=longest $output"
        val commandArray = cmd.split(" ").toTypedArray()
        FFmpegMedia.getInstance().run(
            command = commandArray,
            durationTotal = 10, //  duration audio,
            progressCallBack = progressCallBack
        )
```

## API Overview
```kotlin
        FFmpegMedia.getInstance().run(
            command = commandArray,
            durationTotal = 10, //  duration audio,
            progressCallBack = progressCallBack
        )
```

## Notes
- FFmpeg binaries included — no extra setup required.
- Supports Android 5.0+
- Handle storage permissions for Android < 10 if needed.

## License
MIT License
