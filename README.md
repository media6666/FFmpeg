# FFmpeg Android Library

**Android FFmpeg Library — Video/Audio Converter, Cutter, Merger, Mixer**

FFmpeg is an open-source Android library that allows you to run FFmpeg commands directly inside your Android application.

---

## Features
- Video to MP3
- Audio Cutter
- Audio Merger
- Audio Mixer
- Change speed / volume
- Video Cutter / Compressor
- Supports all FFmpeg custom commands
- AI Sound / AI Voice Changer

---

## Installation

### Step 1 — Add JitPack
```gradle
dependencyResolutionManagement {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

### Step 2 — Add Dependency
```gradle
// Version 1.12: Media only (audio/video features)
implementation("com.github.media6666:FFmpeg:1.12")

// Version 1.14: Media + AI Sound features
// implementation("com.github.media6666:FFmpeg:1.14")
```

### Step 3 — Init FFmpeg
```kotlin
FFmpegMedia.getInstance().initLib { loaded ->
    Log.e("LIB loaded", "$loaded")
}
```

---

## Usage

### Video → MP3
```kotlin
val cmd = "-i ${videoPath} -vn -ar 44100 -ac 2 -b:a 192k ${outputPath}"
val commandArray = cmd.split(" ").toTypedArray()
FFmpegMedia.getInstance().run(
    command = commandArray,
    durationTotal = 10,
    progressCallBack = progressCallBack
)
```

---

### Audio Cutter
```kotlin
val cmd = "-i $input -ss 00:00:05 -to 00:00:12 -c copy $output"
val commandArray = cmd.split(" ").toTypedArray()
FFmpegMedia.getInstance().run(
    command = commandArray,
    durationTotal = 10,
    progressCallBack = progressCallBack
)
```

---

### Merge 2 Audio Files
```kotlin
val cmd = "-i $input1 -i $input2 -filter_complex amix=inputs=2:duration=longest $output"
val commandArray = cmd.split(" ").toTypedArray()
FFmpegMedia.getInstance().run(
    command = commandArray,
    durationTotal = 10,
    progressCallBack = progressCallBack
)
```

---

### Change Speed / Volume
```kotlin
val cmd = "-i $input -filter:a "atempo=1.25,volume=1.5" $output"
val commandArray = cmd.split(" ").toTypedArray()
FFmpegMedia.getInstance().run(
    command = commandArray,
    durationTotal = 10,
    progressCallBack = progressCallBack
)
```

---

## AI Sound / AI Voice Changer

AI Sound allows users to transform audio voices using AI-powered effects.

### Supported Voice Effects
- Girl
- Baby
- Woman
- Boy
- Man
- Chipmunk
- Bee
- Sheep

---

### Init AI Voice Engine
```kotlin
AIVoiceChanger
    .getInstance()
    .initLibrary(context = this) { success ->
        if (success) {
            // AI Sound initialized
        }
    }
```

---

### Play AI Voice Effect
```kotlin
AIVoiceChanger.getInstance()
    .playAvatarBgSound(effectItem.fullEffectPath())
```

---

### Set AI Voice Effect Volume
```kotlin
AIVoiceChanger.getInstance()
    .setAvatarBgVolume(effectItem.volumeBgEffect)
```

---

### Release AI Resources
```kotlin
override fun onDestroy() {
    super.onDestroy()
    AIVoiceChanger.getInstance().close()
}
```

---

## API Overview
```kotlin
FFmpegMedia.getInstance().run(
    command = commandArray,
    durationTotal = 10,
    progressCallBack = progressCallBack
)
```

---

## Notes
- FFmpeg binaries included — no extra setup required.
- AI Sound works offline.
- Supports Android 7.0+
- Handle storage permissions for Android < 10 if needed.

---

## Reference Libraries
- https://github.com/bilibili/ijkplayer
- https://github.com/bilibili/FFmpeg
- https://github.com/microshow/AiSound

---

## License
MIT License
