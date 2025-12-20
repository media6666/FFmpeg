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

### Add JitPack
```gradle
dependencyResolutionManagement {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

### Add Dependency
```gradle
implementation("com.github.media6666:FFmpeg:1.14")
```

### Init FFmpeg
```kotlin
FFmpegMedia.getInstance().initLib { loaded ->
    Log.e("LIB loaded", "$loaded")
}
```

---

## AI Sound / AI Voice Changer

AI Sound allows users to change audio voices using AI effects.

### Supported Voices
- Girl
- Baby
- Woman
- Boy
- Man
- Chipmunk
- Bee
- Sheep

### Init AI Engine
```kotlin
AIVoiceChanger
    .getInstance()
    .initLibrary(context = this) { success ->
        // success = true if initialized
    }
```

### Play AI Effect
```kotlin
AIVoiceChanger.getInstance()
    .playAvatarBgSound(effectItem.fullEffectPath())
```

### Set Volume
```kotlin
AIVoiceChanger.getInstance()
    .setAvatarBgVolume(effectItem.volumeBgEffect)
```

### Release
```kotlin
override fun onDestroy() {
    super.onDestroy()
    AIVoiceChanger.getInstance().close()
}
```

---

## Reference Libraries
- https://github.com/bilibili/ijkplayer
- https://github.com/bilibili/FFmpeg
- https://github.com/microshow/AiSound

---

## License
MIT License
