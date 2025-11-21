# FFmpegMedia6666

**Android FFmpeg Library — Video/Audio Converter, Cutter, Merger, Mixer**

FFmpegMedia6666 is a lightweight Android library that bundles FFmpeg binaries and allows you to run any FFmpeg command directly from your Android app.

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
implementation 'com.github.media6666:FFmpegMedia6666:v1'
```

## Usage

### Video → MP3
```kotlin
FFmpegMedia.run(
    command = "-i ${videoPath} -vn -ar 44100 -ac 2 -b:a 192k ${outputPath}",
    onSuccess = { Log.d("FFmpeg", "Converted successfully.") },
    onFailure = { error -> Log.e("FFmpeg", "Error: $error") }
)
```

### Audio Cutter
```kotlin
val cmd = "-i $input -ss 00:00:05 -to 00:00:12 -c copy $output"
FFmpegMedia.run(cmd)
```

### Merge 2 Audio Files
```kotlin
val cmd = "-i $input1 -i $input2 -filter_complex amix=inputs=2:duration=longest $output"
FFmpegMedia.run(cmd)
```

## API Overview
```kotlin
FFmpegMedia.run(
    command: String,
    onSuccess: () -> Unit,
    onFailure: (String) -> Unit
)
```

## Notes
- FFmpeg binaries included — no extra setup required.
- Supports Android 5.0+
- Handle storage permissions for Android < 10 if needed.

## License
MIT License
