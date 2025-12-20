package io.microshow.aisound.model

import com.inshot.videotomp3.R

data class BgEffectItem(
    val nameEffect: String,
    val iconEffect: Int,
    val pathEffect: String,
    val volumeEffect: Float,
    var volumeEffectCustom: Float,
    val isOkEffect: Boolean,
    val isPro: Boolean,
    val minVolume: Float = 0.0f,
    val maxVolume: Float = 3.0f
) {

    fun canShowCustom(): Boolean {
        return isNormal().not()
    }

    fun isNormal(): Boolean {
        return nameEffect == "None"
    }
}

fun normalBgEffect() = BgEffectItem(
    nameEffect = "None",
    iconEffect = R.drawable.a_normal,
    pathEffect = "",
    volumeEffect = 1.0f,
    volumeEffectCustom = 1.0f,
    isPro = false,
    isOkEffect = false
)

fun seaBgEffect() = BgEffectItem(
    nameEffect = "Sea",
    iconEffect = R.drawable.a_sea,
    pathEffect = "ambient/sea.wav",
    volumeEffect = 1.0f,
    volumeEffectCustom = 1.0f,
    isPro = false,
    isOkEffect = false
)

fun heavyBgEffect() = BgEffectItem(
    nameEffect = "Heavy Rain",
    iconEffect = R.drawable.a_heavy_rain,
    pathEffect = "ambient/heavy_rain.wav",
    volumeEffect = 0.5f,
    volumeEffectCustom = 0.5f,
    isOkEffect = true,
    isPro = false,
)

fun strongWindBgEffect() = BgEffectItem(
    nameEffect = "Storm",
    iconEffect = R.drawable.a_strong_wind,
    pathEffect = "ambient/strong_wind.mp3",
    volumeEffect = 0.5f,
    volumeEffectCustom = 0.5f,
    isOkEffect = true,
    isPro = false,
)

fun summerNightBgEffect() = BgEffectItem(
    nameEffect = "Summer Night",
    iconEffect = R.drawable.a_summer_night,
    pathEffect = "ambient/summer_night.mp3",
    volumeEffect = 0.5f,
    volumeEffectCustom = 0.5f,
    isOkEffect = true,
    isPro = true,
)

fun childrenBgEffect() = BgEffectItem(
    nameEffect = "Children",
    iconEffect = R.drawable.a_children_playing,
    pathEffect = "ambient/children_playing.mp3",
    volumeEffect = 1.5f,
    volumeEffectCustom = 1.5f,
    isOkEffect = true,
    isPro = false,
)

fun barNoiseBgEffect() = BgEffectItem(
    nameEffect = "Bar noise",
    iconEffect = R.drawable.a_bar_noise,
    pathEffect = "ambient/bar.wav",
    volumeEffect = 1.5f,
    volumeEffectCustom = 1.5f,
    isOkEffect = true,
    isPro = false,
)

fun fireWorkBgEffect() = BgEffectItem(
    nameEffect = "Fireworks",
    iconEffect = R.drawable.a_fireworks,
    pathEffect = "ambient/fireworks.mp3",
    volumeEffect = 2.0f,
    volumeEffectCustom = 2.0f,
    isOkEffect = true,
    isPro = false,
)

fun noiseStreetBgEffect() = BgEffectItem(
    nameEffect = "Noise street",
    iconEffect = R.drawable.a_noise_street,
    pathEffect = "ambient/cars_on_street.wav",
    volumeEffect = 0.5f,
    volumeEffectCustom = 0.5f,
    isOkEffect = true,
    isPro = false,
)

fun birdBgEffect() = BgEffectItem(
    nameEffect = "Bird",
    iconEffect = R.drawable.a_bird,
    pathEffect = "ambient/birds.wav",
    volumeEffect = 1.0f,
    volumeEffectCustom = 1.0f,
    isOkEffect = true,
    isPro = false,
)

fun trainBgEffect() = BgEffectItem(
    nameEffect = "Train",
    iconEffect = R.drawable.a_train,
    pathEffect = "ambient/train.mp3",
    volumeEffect = 1.0f,
    volumeEffectCustom = 1.0f,
    isOkEffect = false,
    isPro = false,
)

fun alarmBgEffect() = BgEffectItem(
    nameEffect = "Alarm",
    iconEffect = R.drawable.a_alarm,
    pathEffect = "ambient/alarm.mp3",
    volumeEffectCustom = 1.0f,
    volumeEffect = 1.0f,
    isOkEffect = true,
    isPro = false,
)

fun dogBgEffect() = BgEffectItem(
    nameEffect = "Dog",
    iconEffect = R.drawable.a_dog,
    pathEffect = "ambient/dog_bark.mp3",
    volumeEffect = 1.0f,
    volumeEffectCustom = 1.0f,
    isOkEffect = true,
    isPro = false,
)

fun catBgEffect() = BgEffectItem(
    nameEffect = "Cat",
    iconEffect = R.drawable.a_cat,
    pathEffect = "ambient/cat.mp3",
    volumeEffectCustom = 1.0f,
    volumeEffect = 1.0f,
    isOkEffect = true,
    isPro = false,
)

fun wolfBgEffect() = BgEffectItem(
    nameEffect = "wolf",
    iconEffect = R.drawable.a_wolf,
    pathEffect = "ambient/wolf.mp3",
    volumeEffect = 1.0f,
    volumeEffectCustom = 1.0f,
    isOkEffect = false,
    isPro = false,
)

fun tigerBgEffect() = BgEffectItem(
    nameEffect = "Tiger",
    iconEffect = R.drawable.a_tiger,
    pathEffect = "ambient/tiger.mp3",
    volumeEffect = 1.0f,
    volumeEffectCustom = 1.0f,
    isOkEffect = false,
    isPro = false,
)

fun policeBgEffect() = BgEffectItem(
    nameEffect = "Police",
    iconEffect = R.drawable.a_police_siren,
    pathEffect = "ambient/police_siren.mp3",
    volumeEffect = 1.0f,
    volumeEffectCustom = 1.0f,
    isOkEffect = false,
    isPro = false,
)

fun doorBellBgEffect() = BgEffectItem(
    nameEffect = "Door Bell",
    iconEffect = R.drawable.a_doorbell,
    pathEffect = "ambient/door_bell.mp3",
    volumeEffect = 1.0f,
    volumeEffectCustom = 1.0f,
    isOkEffect = true,
    isPro = false,
)

fun snoringBgEffect() = BgEffectItem(
    nameEffect = "Snoring",
    iconEffect = R.drawable.a_snoring,
    pathEffect = "ambient/snoring.mp3",
    volumeEffect = 1.0f,
    volumeEffectCustom = 1.0f,
    isOkEffect = true,
    isPro = false,
)

fun fartBgEffect() = BgEffectItem(
    nameEffect = "Fart",
    iconEffect = R.drawable.a_fart,
    pathEffect = "ambient/fart.mp3",
    volumeEffect = 1.0f,
    volumeEffectCustom = 1.0f,
    isOkEffect = false,
    isPro = false,
)

fun telephoneBgEffect() = BgEffectItem(
    nameEffect = "Telephone",
    iconEffect = R.drawable.a_telephone_ring,
    pathEffect = "ambient/telephone_ring.wav",
    volumeEffect = 1.0f,
    isOkEffect = true,
    volumeEffectCustom = 1.0f,
    isPro = false,
)

fun BgEffectItem.fullPathEffect(): String {
    return "file:///android_asset/${pathEffect}"
}