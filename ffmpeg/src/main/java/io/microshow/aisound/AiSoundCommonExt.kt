package io.microshow.aisound

import hn.com.set_ringtone.ringtone_maker.mp3.R
import io.microshow.aisound.model.DspEffect
import io.microshow.aisound.model.DspInfo
import io.microshow.aisound.model.EffectItem
import io.microshow.aisound.model.alarmBgEffect
import io.microshow.aisound.model.barNoiseBgEffect
import io.microshow.aisound.model.birdBgEffect
import io.microshow.aisound.model.catBgEffect
import io.microshow.aisound.model.childrenBgEffect
import io.microshow.aisound.model.dogBgEffect
import io.microshow.aisound.model.doorBellBgEffect
import io.microshow.aisound.model.fartBgEffect
import io.microshow.aisound.model.fireWorkBgEffect
import io.microshow.aisound.model.heavyBgEffect
import io.microshow.aisound.model.noiseStreetBgEffect
import io.microshow.aisound.model.normalBgEffect
import io.microshow.aisound.model.policeBgEffect
import io.microshow.aisound.model.seaBgEffect
import io.microshow.aisound.model.snoringBgEffect
import io.microshow.aisound.model.strongWindBgEffect
import io.microshow.aisound.model.summerNightBgEffect
import io.microshow.aisound.model.telephoneBgEffect
import io.microshow.aisound.model.tigerBgEffect
import io.microshow.aisound.model.trainBgEffect
import io.microshow.aisound.model.wolfBgEffect

val listBgEffect = listOf(
    normalBgEffect(),
    seaBgEffect(),
    heavyBgEffect(),
    strongWindBgEffect(),
    summerNightBgEffect(),
    childrenBgEffect(),
    barNoiseBgEffect(),
    fireWorkBgEffect(),
    noiseStreetBgEffect(),
    birdBgEffect(),
    trainBgEffect(),
    alarmBgEffect(),
    dogBgEffect(),
    catBgEffect(),
    wolfBgEffect(),
    tigerBgEffect(),
    policeBgEffect(),
    doorBellBgEffect(),
    snoringBgEffect(),
    fartBgEffect(),
    telephoneBgEffect()
)


val listEffectItem = listOf(
    normalEffect(),
    girlEffect(),
    babyEffect(),
    charmingWomenEffect(),
    babyBoyEffect(),
    matureMenEffect(),
    oldMenEffect(),
    nervousEffect(),
    lionEffect(),
    giantEffect(),
    dizzyEffect(),
    dunkEffect(),
    chipmunkEffect(),
    musicEffect(),
    beeEffect(),
    sheepEffect(),
    robotEffect(),
    robot2Effect(),
    echoEffect(),
    alienEffect(),
    alien2Effect(),
    heliumEffect(),
    hexafluorideSfEffect(),
    zombieEffect(),
    monsterEffect(),
    ghostEffect(),
    deathEffect(),
    devilEffect(),
    darkEffect(),
    partyEffect(),
    caveEffect(),
    grandCanyonEffect(),
    hallEffect(),
    underwaterEffect(),
    distanceEffect(),
    fastForwardEffect(),
    slowEffect(),
    megaphoneEffect(),
    policeEffect(),
    oldRadioEffect(),
    cathedralEffect(),
    fanEffect(),
    tremoloEffect(),
    multipleEffect(),
    foreignerEffect(),
    cathdralEffect(),
    telephoneEffect(),
    phonographEffect(),
    bassBoosterEffect(),
    deepEffect(),
    karaokeEffect(),
    studioEffect(),
)

fun normalEffect() = EffectItem(
    dspInfoList = emptyList(),
    pathBgEffect = "",
    iconResId = R.drawable.a_normal,
    iconResIdSmall = 0,
    name = "None",
    i4 = 1,
    i5 = 1,
    isPro = false,
)

fun musicEffect() = EffectItem(
    dspInfoList = emptyList(),
    pathBgEffect = "",
    iconResId = R.drawable.a_music,
    iconResIdSmall = 0,
    name = "Music",
    i4 = 1,
    i5 = 1,
    isPro = false,
)

fun girlEffect(): EffectItem {
    val listDspEffectGirl = mutableListOf<DspEffect>()
    listDspEffectGirl.add(DspEffect("Level", "Level", 1.8f, 1.0f, 2.0f, true))
    listDspEffectGirl.add(
        DspEffect("Clarity", "Clarity", 1024.0f, 2048.0f, 0.0f, true, true)
    )
    listDspEffectGirl.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 2.0f))
    val listDspInfoGirl = mutableListOf<DspInfo>()
    listDspInfoGirl.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffectGirl
        )
    )
    return EffectItem(
        dspInfoList = listDspInfoGirl,
        pathBgEffect = "",
        iconResId = R.drawable.a_girl,
        iconResIdSmall = 0,
        name = "Girl",
        i4 = 2,
        i5 = 2,
        isPro = false,
    )
}

fun babyEffect(): EffectItem {
    //baby
    val listDspEffectBaby = mutableListOf<DspEffect>()
    listDspEffectBaby.add(
        DspEffect("Level", "Level", 1.9f, 1.8f, 2.0f, true)
    )
    listDspEffectBaby.add(
        DspEffect("Clarity", "Clarity", 1024.0f, 2048.0f, 256.0f, true, true)
    )
    listDspEffectBaby.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 2.0f))
    val listDspInfoBaby = mutableListOf<DspInfo>()
    listDspInfoBaby.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffectBaby
        )
    )
    return EffectItem(
        dspInfoList = listDspInfoBaby,
        pathBgEffect = "",
        iconResId = R.drawable.a_baby,
        iconResIdSmall = 0,
        name = "Baby",
        i4 = 41,
        i5 = 4,
        isPro = false,
    )
}

fun charmingWomenEffect(): EffectItem {
    //charming Women
    val listDspEffectCharMingWomen = mutableListOf<DspEffect>()
    listDspEffectCharMingWomen.add(
        DspEffect("Level", "Level", 1.5f, 1.0f, 1.6f, true)
    )
    listDspEffectCharMingWomen.add(
        DspEffect("Clarity", "Clarity", 1024.0f, 2048.0f, 0.0f, true, true)
    )
    listDspEffectCharMingWomen.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    val listDspInfoCharMingWomen = mutableListOf<DspInfo>()
    listDspInfoCharMingWomen.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffectCharMingWomen
        )
    )
    return EffectItem(
        dspInfoList = listDspInfoCharMingWomen,
        pathBgEffect = "",
        iconResId = R.drawable.a_charming_women,
        iconResIdSmall = 0,
        name = "Woman",
        i4 = 3,
        i5 = 4,
        isPro = false,
    )
}

fun babyBoyEffect(): EffectItem {
    //Baby boy
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(
        DspEffect("Level", "Level", 0.935f, 1.0f, 0.8f, true)
    )
    listDspEffect.add(
        DspEffect("Clarity", "Clarity", 1024.0f, 2048.0f, 0.0f, true, true)
    )
    listDspEffect.add(
        DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f)
    )
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_baby_boy,
        iconResIdSmall = 0,
        name = "Boy",
        i4 = 4,
        i5 = 3,
        isPro = false,
    )
}

fun matureMenEffect(): EffectItem {
    //Baby boy
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(
        DspEffect("Level", "Level", 0.8f, 1.0f, 0.5f, true)
    )
    listDspEffect.add(
        DspEffect("Clarity", "Clarity", 1024.0f, 2048.0f, 0.0f, true, true)
    )
    listDspEffect.add(
        DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f)
    )
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_mature_men,
        iconResIdSmall = 0,
        name = "Man",
        i4 = 5,
        i5 = 5,
        isPro = false,
    )
}

fun oldMenEffect(): EffectItem {
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(
        DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 0.8f)
    )
    listDspEffect.add(
        DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 1.0f)
    )
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_FREQUENCY(频率)", 8.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_DEPTH(深度)", 0.5f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_SHAPE(三角形和正弦之间的LFO形状变形)", 0.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_SKEW(LFO周期的时间偏斜)", 0.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_DUTY(LFO准时)", 0.5f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_SQUARE(LFO形状的平坦度)", 0.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_PHASE(瞬时LFO阶段)", 0.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_SPREAD(旋转/自动平移效果)", 0.0f))

    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_TREMOLO,
            dspEffects = listDspEffect2
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_oldman,
        iconResIdSmall = R.drawable.a_oldman,
        name = "OldMan",
        i4 = 42,
        i5 = 5,
        isPro = false,
    )
}

fun nervousEffect(): EffectItem {
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(
        DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 1.4f)
    )
    listDspEffect.add(
        DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 1.0f)
    )
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_PITCHSHIFT_PITCH(音调)", 0.8f))
    listDspEffect2.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 1024.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect2
        )
    )

    val listDspEffect3 = mutableListOf<DspEffect>()
    listDspEffect3.add(DspEffect("FMOD_DSP_FLANGE_MIX(合成声音量)", 24.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_FLANGE_DEPTH(深度)", 0.3f))
    listDspEffect3.add(DspEffect("FMOD_DSP_FLANGE_RATE(速度)", 3.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_FLANGE,
            dspEffects = listDspEffect3
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_nervours,
        iconResIdSmall = R.drawable.a_nervours,
        name = "Nervous",
        i4 = 6,
        i5 = 6,
        isPro = false,
    )
}

fun lionEffect(): EffectItem {
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(
        DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 0.8f)
    )
    listDspEffect.add(
        DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 1.0f)
    )
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_PITCHSHIFT_PITCH(音调)", 0.1f))
    listDspEffect2.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 1024.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect2
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_lion,
        iconResIdSmall = R.drawable.a_lion,
        name = "Lion",
        i4 = 35,
        i5 = 3,
        isPro = false,
    )
}

fun giantEffect(): EffectItem {
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(
        DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 0.8f)
    )
    listDspEffect.add(
        DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 1.0f)
    )
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_PITCHSHIFT_PITCH(音调)", 0.1f))
    listDspEffect2.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 1024.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect2
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_giant,
        iconResIdSmall = R.drawable.a_giant,
        name = "Giant",
        i4 = 37,
        i5 = 2,
        isPro = false,
    )
}

fun dizzyEffect(): EffectItem {
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 1.1f))
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 1.0f))
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_FLANGE_MIX(合成声音量)", 100.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_FLANGE_DEPTH(深度)", 1.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_FLANGE_RATE(速度)", 2.8f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_FLANGE,
            dspEffects = listDspEffect2
        )
    )


    val listDspEffect3 = mutableListOf<DspEffect>()
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_PITCH(音调)", 1.2f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 256.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect3
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_dizzy,
        iconResIdSmall = R.drawable.a_dizzy,
        name = "Dizzy",
        i4 = 36,
        i5 = 2,
        isPro = false,
    )
}

fun dunkEffect(): EffectItem {
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 0.75f))
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 1.2f))
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect3 = mutableListOf<DspEffect>()
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_PITCH(音调)", 1.28f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 1024.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect3
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "Drunk.mp3",
        volumeBgEffect = 1.0f,
        iconResId = R.drawable.a_drunk,
        iconResIdSmall = R.drawable.a_drunk,
        name = "Drunk",
        i4 = 7,
        i5 = 3,
        isPro = false,
    )
}

fun chipmunkEffect(): EffectItem {
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 1.9f))
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 1.0f))
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_chipmunk,
        iconResIdSmall = R.drawable.a_chipmunk,
        name = "Chipmunk",
        i4 = 20,
        i5 = 3,
        isPro = false,
    )
}

fun beeEffect(): EffectItem {
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 1.8f))
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 1.0f))
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect3 = mutableListOf<DspEffect>()
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_PITCH(音调)", 2.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 1024.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect3
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_sheep,
        iconResIdSmall = R.drawable.a_sheep,
        name = "Bee",
        i4 = 21,
        i5 = 6,
        isPro = false,
    )
}

fun sheepEffect(): EffectItem {
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(DspEffect("Age", "Age", 1.1f, 0.7f, 1.3f, true))
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 2.0f))
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect3 = mutableListOf<DspEffect>()
    listDspEffect3.add(DspEffect("FMOD_DSP_FLANGE_MIX(合成声音量)", 70.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_FLANGE_DEPTH(深度)", 0.25f))
    listDspEffect3.add(DspEffect("FMOD_DSP_FLANGE_RATE(速度)", 14.5f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_FLANGE,
            dspEffects = listDspEffect3
        )
    )


    val listDspEffect4 = mutableListOf<DspEffect>()
    listDspEffect4.add(DspEffect("FMOD_DSP_TREMOLO_FREQUENCY(频率)", 19.8f))
    listDspEffect4.add(DspEffect("FMOD_DSP_TREMOLO_DEPTH(深度)", 0.99f))
    listDspEffect4.add(DspEffect("FMOD_DSP_TREMOLO_SHAPE(三角形和正弦之间的LFO形状变形)", 0.55f))
    listDspEffect4.add(DspEffect("FMOD_DSP_TREMOLO_SKEW(LFO周期的时间偏斜)", 0.3f))
    listDspEffect4.add(DspEffect("FMOD_DSP_TREMOLO_DUTY(LFO准时)", 0.55f))
    listDspEffect4.add(DspEffect("FMOD_DSP_TREMOLO_SQUARE(LFO形状的平坦度)", 0.0f))
    listDspEffect4.add(DspEffect("FMOD_DSP_TREMOLO_PHASE(瞬时LFO阶段)", 0.0f))
    listDspEffect4.add(DspEffect("FMOD_DSP_TREMOLO_SPREAD(旋转/自动平移效果)", 0.73f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_TREMOLO,
            dspEffects = listDspEffect4
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_sheep,
        iconResIdSmall = R.drawable.a_sheep,
        name = "Sheep",
        i4 = 8,
        i5 = 5,
        isPro = false,
    )
}

fun robot2Effect(): EffectItem {
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(DspEffect("Tune", "Tune", 1.0f, 0.7f, 3.0f, true))
    listDspEffect.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 256.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect4 = mutableListOf<DspEffect>()
    listDspEffect4.add(DspEffect("FMOD_DSP_FLANGE_MIX(合成声音量)", 100.0f))
    listDspEffect4.add(DspEffect("FMOD_DSP_FLANGE_DEPTH(深度)", 0.1f))
    listDspEffect4.add(DspEffect("FMOD_DSP_FLANGE_RATE(速度)", 1.5f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_FLANGE,
            dspEffects = listDspEffect4
        )
    )


    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 1.0f))
    listDspEffect2.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 0.8f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect2
        )
    )

    val listDspEffect3 = mutableListOf<DspEffect>()
    listDspEffect3.add(DspEffect("FMOD_DSP_ECHO_DELAY(延迟)", 10.0f))
    listDspEffect3.add(DspEffect("Robotic", "Robotic", 90.0f, 75.0f, 95.0f, true, true))
    listDspEffect3.add(DspEffect("FMOD_DSP_ECHO_DRYLEVEL(原声)", -80.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_ECHO_WETLEVEL(回声)", 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_ECHO,
            dspEffects = listDspEffect3
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "Robot2.wav",
        volumeBgEffect = 0.2f,
        iconResId = R.drawable.a_robot2,
        iconResIdSmall = R.drawable.a_robot2,
        name = "Robot2",
        i4 = 28,
        i5 = 3,
        isPro = false,
    )
}

fun echoEffect(): EffectItem {
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(DspEffect("Echo", "Echo", 300.0f, 50.0f, 1000.0f, true))
    listDspEffect.add(DspEffect("Level", "Level", 5.0f, 0.0f, 50.0f, true, true))
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_DRYLEVEL(原声)", 0.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_WETLEVEL(回声)", 0.0f))
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_ECHO,
            dspEffects = listDspEffect
        )
    )


    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_echo,
        iconResIdSmall = R.drawable.a_echo,
        name = "Echo",
        i4 = 52,
        i5 = 2,
        isPro = false,
    )
}

fun robotEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(DspEffect("Tune", "Tune", 1.0f, 0.6f, 2.0f, true))
    listDspEffect.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 256.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 1.0f))
    listDspEffect2.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 0.8f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect2
        )
    )

    val listDspEffect4 = mutableListOf<DspEffect>()
    listDspEffect4.add(DspEffect("FMOD_DSP_ECHO_DELAY(延迟)", 10.0f))
    listDspEffect4.add(DspEffect("Robotic", "Robotic", 90.0f, 75.0f, 95.0f, true))
    listDspEffect4.add(DspEffect("FMOD_DSP_ECHO_DRYLEVEL(原声)", -80.0f))
    listDspEffect4.add(DspEffect("FMOD_DSP_ECHO_WETLEVEL(回声)", 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_ECHO,
            dspEffects = listDspEffect4
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "Robot.mp3",
        iconResId = R.drawable.a_robot,
        iconResIdSmall = R.drawable.a_robot,
        name = "Robot",
        i4 = 9,
        i5 = 5,
        isPro = false,
    )
}

fun alienEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(DspEffect("Level", "Level", 90.0f, 30.0f, 100.0f, true, true))
    listDspEffect.add(DspEffect("Planet α", "Planet α", 0.3f, 0.1f, 1.0f, true))
    listDspEffect.add(DspEffect("Planet β", "Planet β", 11.5f, 0.1f, 20.0f, true))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_FLANGE,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect3 = mutableListOf<DspEffect>()
    listDspEffect3.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 0.9f))
    listDspEffect3.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 1.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect3
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "Alien1.wav",
        volumeBgEffect = 0.2f,
        iconResId = R.drawable.a_alien,
        iconResIdSmall = R.drawable.a_alien,
        name = "Alien",
        i4 = 29,
        i5 = 5,
        isPro = false,
    )
}

fun alien2Effect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DECAYTIME(Decay Time)", 1500.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_EARLYDELAY(Early Delay)", 20.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_LATEDELAY(Reverb Delay)", 40.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_HFREFERENCE(HF Reference)", 5000.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_HFDECAYRATIO(Decay HF Ratio)", 50.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DIFFUSION(Diffusion)", 100.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DENSITY(Density)", 100.0f))
    listDspEffect.add(
        DspEffect(
            "FMOD_DSP_SFXREVERB_LOWSHELFFREQUENCY(Low Shelf Frequency)",
            250.0f
        )
    )
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_LOWSHELFGAIN(Low Shelf Gain)", 0.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_HIGHCUT(High Cut)", 20000.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_EARLYLATEMIX(Early/Late Mix)", 50.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_WETLEVEL(Wet Level)", 2.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DRYLEVEL(Dry Level)", -80.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_SFXREVERB,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("Level", "Level", 50.0f, 30.0f, 100.0f, true))
    listDspEffect2.add(DspEffect("Planet α", "Planet α", 1.0f, 0.1f, 1.0f, true))
    listDspEffect2.add(DspEffect("Planet β", "Planet β", 0.1f, 0.1f, 20.0f, true))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_FLANGE,
            dspEffects = listDspEffect2
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "Alien2.wav",
        volumeBgEffect = 0.2f,
        iconResId = R.drawable.a_alien2,
        iconResIdSmall = R.drawable.a_alien2,
        name = "Alien2",
        i4 = 30,
        i5 = 4,
        isPro = false,
    )
}

fun heliumEffect(): EffectItem {
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(DspEffect("FMOD_DSP_PITCHSHIFT_PITCH(音调)", 2.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 1024.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_helium,
        iconResIdSmall = R.drawable.a_helium,
        name = "Helium",
        i4 = 10,
        i5 = 4,
        isPro = false,
    )
}

fun hexafluorideSfEffect(): EffectItem {
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(DspEffect("FMOD_DSP_PITCHSHIFT_PITCH(音调)", 0.6f))
    listDspEffect.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 1024.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    val listDspInfo = mutableListOf<DspInfo>()
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_hexafluoride_sf,
        iconResIdSmall = R.drawable.a_hexafluoride_sf,
        name = "Hexafluoride",
        i4 = 11,
        i5 = 4,
        isPro = false,
    )
}

fun zombieEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("FMOD_DSP_FLANGE_MIX(合成声音量)", 85.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_FLANGE_DEPTH(深度)", 0.5f))
    listDspEffect.add(DspEffect("FMOD_DSP_FLANGE_RATE(速度)", 3.5f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_FLANGE,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_PITCHSHIFT_PITCH(音调)", 0.85f))
    listDspEffect2.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 1024.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect2
        )
    )


    val listDspEffect3 = mutableListOf<DspEffect>()
    listDspEffect3.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 0.85f))
    listDspEffect3.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 1.2f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect3
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "Zombie.wav",
        volumeBgEffect = 0.5f,
        iconResId = R.drawable.a_zombie,
        iconResIdSmall = R.drawable.a_zombie,
        name = "Zombie",
        i4 = 31,
        i5 = 5,
        isPro = false,
    )
}

fun monsterEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("FMOD_DSP_FLANGE_MIX(合成声音量)", 100.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_FLANGE_DEPTH(深度)", 0.3f))
    listDspEffect.add(DspEffect("FMOD_DSP_FLANGE_RATE(速度)", 20.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_FLANGE,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_CHORUS_MIX(音量)", 100.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_CHORUS_RATE(频率)", 12.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_CHORUS_DEPTH(深度)", 30.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHORUS,
            dspEffects = listDspEffect2
        )
    )


    val listDspEffect3 = mutableListOf<DspEffect>()
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_PITCH(音调)", 1.4f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 1024.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect3
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_monster,
        iconResIdSmall = R.drawable.a_monster,
        name = "Monster",
        i4 = 12,
        i5 = 2,
        isPro = false,
    )
}

fun ghostEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 0.7f))
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 1.2f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_CHORUS_MIX(音量)", 75.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_CHORUS_RATE(频率)", 7.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_CHORUS_DEPTH(深度)", 25.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHORUS,
            dspEffects = listDspEffect2
        )
    )


    val listDspEffect3 = mutableListOf<DspEffect>()
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_PITCH(音调)", 0.8f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 1024.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect3
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "Ghost.mp3",
        volumeBgEffect = 1.0f,
        iconResId = R.drawable.a_ghost,
        iconResIdSmall = R.drawable.a_ghost,
        name = "Ghost",
        i4 = 13,
        i5 = 5,
        isPro = false,
    )
}

fun deathEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 0.5f))
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 0.7f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("Echo", "Echo", 250.0f, 150.0f, 500.0f, true))
    listDspEffect2.add(DspEffect("FMOD_DSP_ECHO_FEEDBACK(回声每次延迟衰减)", 70.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_ECHO_DRYLEVEL(原声)", 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_ECHO_WETLEVEL(回声)", 1.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_ECHO,
            dspEffects = listDspEffect2
        )
    )


    val listDspEffect3 = mutableListOf<DspEffect>()
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_PITCH(音调)", 1.6f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 1024.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect3
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "Death.mp3",
        volumeBgEffect = 1.5f,
        iconResId = R.drawable.a_death,
        iconResIdSmall = R.drawable.a_death,
        name = "Death",
        i4 = 32,
        i5 = 3,
        isPro = false,
    )
}

fun devilEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 0.9f))
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 0.7f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("Echo", "Echo", 250.0f, 150.0f, 500.0f, true))
    listDspEffect2.add(DspEffect("FMOD_DSP_ECHO_FEEDBACK(回声每次延迟衰减)", 70.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_ECHO_DRYLEVEL(原声)", 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_ECHO_WETLEVEL(回声)", 1.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_ECHO,
            dspEffects = listDspEffect2
        )
    )


    val listDspEffect3 = mutableListOf<DspEffect>()
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_PITCH(音调)", 0.9f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 1024.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect3
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_devil,
        iconResIdSmall = R.drawable.a_devil,
        name = "Devil",
        i4 = 45,
        i5 = 3,
        isPro = false,
    )
}

fun darkEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_DELAY(延迟)", 10.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_FEEDBACK(回声每次延迟衰减)", 70.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_DRYLEVEL(原声)", 0.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_WETLEVEL(回声)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_ECHO,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_CHORUS_MIX(音量)", 100.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_CHORUS_RATE(频率)", 5.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_CHORUS_DEPTH(深度)", 20.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHORUS,
            dspEffects = listDspEffect2
        )
    )


    val listDspEffect3 = mutableListOf<DspEffect>()
    listDspEffect3.add(DspEffect("Tune", "Tune", 0.9f, 0.6f, 1.0f, true))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 1024.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect3
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_dark,
        iconResIdSmall = R.drawable.a_dark,
        name = "Dark",
        i4 = 47,
        i5 = 3,
        isPro = false,
    )
}

fun partyEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_DELAY(延迟)", 10.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_FEEDBACK(回声每次延迟衰减)", 50.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_DRYLEVEL(原声)", 0.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_WETLEVEL(回声)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_ECHO,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_CHORUS_MIX(音量)", 60.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_CHORUS_RATE(频率)", 3.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_CHORUS_DEPTH(深度)", 20.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHORUS,
            dspEffects = listDspEffect2
        )
    )


    val listDspEffect3 = mutableListOf<DspEffect>()
    listDspEffect3.add(DspEffect("FMOD_DSP_DISTORTION_LEVEL(失真等级)", 0.5f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_DISTORTION,
            dspEffects = listDspEffect3
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "bar.mp3",
        volumeBgEffect = 1.5f,
        iconResId = R.drawable.a_party,
        iconResIdSmall = R.drawable.a_party,
        name = "Party",
        i4 = 48,
        i5 = 4,
        isPro = false,
    )
}

fun caveEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_DELAY(延迟)", 70.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_FEEDBACK(回声每次延迟衰减)", 70.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_DRYLEVEL(原声)", 0.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_WETLEVEL(回声)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_ECHO,
            dspEffects = listDspEffect
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "Cave.mp3",
        volumeBgEffect = 1.0f,
        iconResId = R.drawable.a_cave,
        iconResIdSmall = R.drawable.a_cave,
        name = "Cave",
        i4 = 14,
        i5 = 3,
        isPro = false,
    )
}

fun grandCanyonEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("Echo", "Echo", 650.0f, 200.0f, 800.0f, true))
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_FEEDBACK(回声每次延迟衰减)", 30.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_DRYLEVEL(原声)", 3.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_ECHO_WETLEVEL(回声)", -3.5f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_ECHO,
            dspEffects = listDspEffect
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_grand_canyon,
        iconResIdSmall = R.drawable.a_grand_canyon,
        name = "GrandCanyon",
        i4 = 22,
        i5 = 3,
        isPro = false,
    )
}

fun hallEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("Echo", "Echo", 12000.0f, 2000.0f, 20000.0f, true))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_EARLYDELAY(Early Delay)", 20.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_LATEDELAY(Reverb Delay)", 40.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_HFREFERENCE(HF Reference)", 5000.0f))
    listDspEffect.add(DspEffect("Reverberation", "Reverberation", 80.0f, 30.0f, 100.0f, true, true))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DIFFUSION(Diffusion)", 100.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DENSITY(Density)", 100.0f))
    listDspEffect.add(
        DspEffect(
            "FMOD_DSP_SFXREVERB_LOWSHELFFREQUENCY(Low Shelf Frequency)",
            250.0f
        )
    )
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_LOWSHELFGAIN(Low Shelf Gain)", 0.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_HIGHCUT(High Cut)", 20000.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_EARLYLATEMIX(Early/Late Mix)", 50.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_WETLEVEL(Wet Level)", -4.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DRYLEVEL(Dry Level)", 0.0f))

    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_SFXREVERB,
            dspEffects = listDspEffect
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_church,
        iconResIdSmall = R.drawable.a_church,
        name = "Hall",
        i4 = 23,
        i5 = 5,
        isPro = false,
    )
}

fun underwaterEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DECAYTIME(Decay Time)", 1500.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_EARLYDELAY(Early Delay)", 20.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_LATEDELAY(Reverb Delay)", 40.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_HFREFERENCE(HF Reference)", 5000.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_HFDECAYRATIO(Decay HF Ratio)", 50.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DIFFUSION(Diffusion)", 100.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DENSITY(Density)", 100.0f))
    listDspEffect.add(
        DspEffect(
            "FMOD_DSP_SFXREVERB_LOWSHELFFREQUENCY(Low Shelf Frequency)",
            250.0f
        )
    )
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_LOWSHELFGAIN(Low Shelf Gain)", 0.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_HIGHCUT(High Cut)", 1500.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_EARLYLATEMIX(Early/Late Mix)", 50.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_WETLEVEL(Wet Level)", 1.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DRYLEVEL(Dry Level)", -30.0f))


    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_SFXREVERB,
            dspEffects = listDspEffect
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "Underwater.wav",
        volumeBgEffect = 1.0f,
        iconResId = R.drawable.a_underwater,
        iconResIdSmall = R.drawable.a_underwater,
        name = "Underwater",
        i4 = 24,
        i5 = 3,
        isPro = false,
    )
}

fun distanceEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DECAYTIME(Decay Time)", 1500.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_EARLYDELAY(Early Delay)", 20.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_LATEDELAY(Reverb Delay)", 40.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_HFREFERENCE(HF Reference)", 5000.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_HFDECAYRATIO(Decay HF Ratio)", 50.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DIFFUSION(Diffusion)", 100.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DENSITY(Density)", 100.0f))
    listDspEffect.add(
        DspEffect(
            "FMOD_DSP_SFXREVERB_LOWSHELFFREQUENCY(Low Shelf Frequency)",
            250.0f
        )
    )
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_LOWSHELFGAIN(Low Shelf Gain)", 0.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_HIGHCUT(High Cut)", 20000.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_EARLYLATEMIX(Early/Late Mix)", 50.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_WETLEVEL(Wet Level)", 1.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DRYLEVEL(Dry Level)", -30.0f))


    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_SFXREVERB,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()

    listDspEffect2.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 1.0f))
    listDspEffect2.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 0.5f))

    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect2
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_distance,
        iconResIdSmall = R.drawable.a_distance,
        name = "distance",
        i4 = 34,
        i5 = 3,
        isPro = false,
    )
}

fun fastForwardEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("Fast", "Fast", 1.4f, 1.0f, 2.5f, true))
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 1.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_fastforward,
        iconResIdSmall = R.drawable.a_fastforward,
        name = "SpeedUp",
        i4 = 26,
        i5 = 5,
        isPro = false,
    )
}

fun slowEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("Slow", "Slow", 0.8f, 0.6f, 1.0f, true))
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 1.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_slowdown,
        iconResIdSmall = R.drawable.a_slowdown,
        name = "Slow",
        i4 = 27,
        i5 = 2,
        isPro = false,
    )
}

fun megaphoneEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("FMOD_DSP_DISTORTION_LEVEL(失真等级)", 0.9f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_DISTORTION,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()

    listDspEffect2.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 1.0f))
    listDspEffect2.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 0.3f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect2
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_megaphone,
        iconResIdSmall = R.drawable.a_megaphone,
        name = "Megaphone",
        i4 = 15,
        i5 = 4,
        isPro = false,
    )
}

fun policeEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("FMOD_DSP_DISTORTION_LEVEL(失真等级)", 0.9f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_DISTORTION,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 1.0f))
    listDspEffect2.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 0.25f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect2
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "police_siren.mp3",
        volumeBgEffect = 0.5f,
        iconResId = R.drawable.a_police_siren,
        iconResIdSmall = R.drawable.a_police_siren,
        name = "Police",
        i4 = 44,
        i5 = 3,
        isPro = false,
    )
}

fun oldRadioEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DECAYTIME(Decay Time)", 1500.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_EARLYDELAY(Early Delay)", 20.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_LATEDELAY(Reverb Delay)", 40.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_HFREFERENCE(HF Reference)", 5000.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_HFDECAYRATIO(Decay HF Ratio)", 50.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DIFFUSION(Diffusion)", 100.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DENSITY(Density)", 100.0f))
    listDspEffect.add(
        DspEffect(
            "FMOD_DSP_SFXREVERB_LOWSHELFFREQUENCY(Low Shelf Frequency)",
            250.0f
        )
    )
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_LOWSHELFGAIN(Low Shelf Gain)", 0.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_HIGHCUT(High Cut)", 20000.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_EARLYLATEMIX(Early/Late Mix)", 50.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_WETLEVEL(Wet Level)", 15.0f))
    listDspEffect.add(DspEffect("FMOD_DSP_SFXREVERB_DRYLEVEL(Dry Level)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_SFXREVERB,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 1.0f))
    listDspEffect2.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 0.3f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect2
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_oldradio,
        iconResIdSmall = R.drawable.a_oldradio,
        name = "Old Radio",
        i4 = 33,
        i5 = 4,
        isPro = false,
    )
}

fun cathedralEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("FMOD_DSP_DISTORTION_LEVEL(失真等级)", 0.6f, 0.0f, 1.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_DISTORTION,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect2 = mutableListOf<DspEffect>()

    listDspEffect2.add(DspEffect("FMOD_DSP_ECHO_DELAY(延迟)", 75.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_ECHO_FEEDBACK(回声每次延迟衰减)", 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_ECHO_DRYLEVEL(原声)", 0.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_ECHO_WETLEVEL(回声)", -10.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_ECHO,
            dspEffects = listDspEffect2
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_cathdral,
        iconResIdSmall = R.drawable.a_cathdral,
        name = "Cathedral",
        i4 = 16,
        i5 = 5,
        isPro = false,
    )
}

fun fanEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_FREQUENCY(频率)", 5.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_DEPTH(深度)", 1.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_SHAPE(三角形和正弦之间的LFO形状变形)", 0.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_SKEW(LFO周期的时间偏斜)", 0.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_DUTY(LFO准时)", 0.5f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_SQUARE(LFO形状的平坦度)", 0.5f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_PHASE(瞬时LFO阶段)", 0.5f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_SPREAD(旋转/自动平移效果)", 0.5f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_TREMOLO,
            dspEffects = listDspEffect2
        )
    )

    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 1.0f))
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_fan,
        iconResIdSmall = R.drawable.a_fan,
        name = "FAN",
        i4 = 17,
        i5 = 2,
        isPro = false,
    )
}

fun tremoloEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("frequency", "frequency", 10.0f, 2.0f, 15.0f, true))
    listDspEffect2.add(DspEffect("Level", "Level", 0.7f, 0.5f, 1.0f, true))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_SHAPE(三角形和正弦之间的LFO形状变形)", 0.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_SKEW(LFO周期的时间偏斜)", 0.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_DUTY(LFO准时)", 0.5f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_SQUARE(LFO形状的平坦度)", 0.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_PHASE(瞬时LFO阶段)", 0.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_TREMOLO_SPREAD(旋转/自动平移效果)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_TREMOLO,
            dspEffects = listDspEffect2
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_tremolo,
        iconResIdSmall = R.drawable.a_tremolo,
        name = "Tremolo",
        i4 = 53,
        i5 = 5,
        isPro = false,
    )
}

fun multipleEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_CHORUS_MIX(音量)", 100.0f))
    listDspEffect2.add(DspEffect("Clone", "Clone", 1.0f, 0.2f, 5.0f, true))
    listDspEffect2.add(DspEffect("People", "People", 50.0f, 20.0f, 100.0f, true))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHORUS,
            dspEffects = listDspEffect2
        )
    )

    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 1.0f))
    listDspEffect.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 0.8f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect
        )
    )

    val listDspEffect3 = mutableListOf<DspEffect>()

    listDspEffect3.add(DspEffect("FMOD_DSP_ECHO_DELAY(延迟)", 60.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_ECHO_FEEDBACK(回声每次延迟衰减)", 50.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_ECHO_DRYLEVEL(原声)", 0.0f))
    listDspEffect3.add(DspEffect("FMOD_DSP_ECHO_WETLEVEL(回声)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_ECHO,
            dspEffects = listDspEffect3
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_multiple,
        iconResIdSmall = R.drawable.a_multiple,
        name = "Multiple",
        i4 = 18,
        i5 = 4,
        isPro = false,
    )
}

fun foreignerEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("Tune", "Tune", 1.0f, 0.6f, 2.0f, true))
    listDspEffect2.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 256.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect2
        )
    )

    val listDspEffect = mutableListOf<DspEffect>()

    listDspEffect.add(DspEffect("FMOD_DSP_FLANGE_MIX(合成声音量)", 100.0f))
    listDspEffect.add(DspEffect("Worse", "Worse", 0.65f, 0.6f, 1.0f, true))
    listDspEffect.add(DspEffect("FMOD_DSP_FLANGE_RATE(速度)", 3.5f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_FLANGE,
            dspEffects = listDspEffect
        )
    )


    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_foreigner,
        iconResIdSmall = R.drawable.a_foreigner,
        name = "Foreigner",
        i4 = 19,
        i5 = 4,
        isPro = false,
    )
}

fun telephoneEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_LOWGAIN(低音增益)", 0.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_MIDGAIN(中音增益)", 10.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_HIGHGAIN(高音增益)", -30.0f, -80.0f, 10.0f))
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_LOWCROSSOVER(中低交叉频率)",
            500.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_HIGHCROSSOVER(高中交叉频率)",
            2000.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_CROSSOVERSLOPE(交叉斜率)", 1.0f, 0.0f, 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_THREE_EQ,
            dspEffects = listDspEffect2
        )
    )

    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_telephone,
        iconResIdSmall = R.drawable.a_telephone,
        name = "Telephone",
        i4 = 38,
        i5 = 4,
        isPro = false,
    )
}

fun cathdralEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_FREQUENCY(频率)", 1.0f))
    listDspEffect2.add(DspEffect("TYPE_FMOD_DSP_TYPE_CHANNEL_VOLUME(音量)", 0.6f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_CHANNEL,
            dspEffects = listDspEffect2
        )
    )
    val listDspEffect1 = mutableListOf<DspEffect>()
    listDspEffect1.add(DspEffect("FMOD_DSP_ECHO_DELAY(延迟)", 75.0f))
    listDspEffect1.add(DspEffect("FMOD_DSP_ECHO_FEEDBACK(回声每次延迟衰减)", 10.0f))
    listDspEffect1.add(DspEffect("FMOD_DSP_ECHO_DRYLEVEL(原声)", 0.0f))
    listDspEffect1.add(DspEffect("FMOD_DSP_ECHO_WETLEVEL(回声)", 10.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_ECHO,
            dspEffects = listDspEffect1
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_cathdral,
        iconResIdSmall = R.drawable.a_cathdral,
        name = "Cathdral",
        i4 = 40,
        i5 = 3,
        isPro = false,
    )
}

fun phonographEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_LOWGAIN(低音增益)", 0.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_MIDGAIN(中音增益)", 10.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_HIGHGAIN(高音增益)", -50.0f, -80.0f, 10.0f))
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_LOWCROSSOVER(中低交叉频率)",
            1500.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_HIGHCROSSOVER(高中交叉频率)",
            5000.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_CROSSOVERSLOPE(交叉斜率)", 1.0f, 0.0f, 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_THREE_EQ,
            dspEffects = listDspEffect2
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_phonograph,
        iconResIdSmall = R.drawable.a_phonograph,
        name = "Phonograph",
        i4 = 43,
        i5 = 2,
        isPro = false,
    )
}

fun bassBoosterEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_LOWGAIN(低音增益)", 10.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_MIDGAIN(中音增益)", 10.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_HIGHGAIN(高音增益)", 0.0f, -80.0f, 10.0f))
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_LOWCROSSOVER(中低交叉频率)",
            500.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_HIGHCROSSOVER(高中交叉频率)",
            4000.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_CROSSOVERSLOPE(交叉斜率)", 1.0f, 0.0f, 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_THREE_EQ,
            dspEffects = listDspEffect2
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_bassbooster,
        iconResIdSmall = R.drawable.a_bassbooster,
        name = "Bass booster",
        i4 = 49,
        i5 = 3,
        isPro = false,
    )
}

fun deepEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_LOWGAIN(低音增益)", 2.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_MIDGAIN(中音增益)", 10.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_HIGHGAIN(高音增益)", -50.0f, -80.0f, 10.0f))
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_LOWCROSSOVER(中低交叉频率)",
            1500.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_HIGHCROSSOVER(高中交叉频率)",
            10000.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_CROSSOVERSLOPE(交叉斜率)", 1.0f, 0.0f, 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_THREE_EQ,
            dspEffects = listDspEffect2
        )
    )

    val listDspEffect1 = mutableListOf<DspEffect>()
    listDspEffect1.add(DspEffect("Tune", "Tune", 0.6f, 0.1f, 0.8f, true))
    listDspEffect1.add(DspEffect("FMOD_DSP_PITCHSHIFT_FFTSIZE(比特率)", 256.0f))
    listDspEffect1.add(DspEffect("FMOD_DSP_PITCHSHIFT_MAXCHANNELS(声道)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_NORMAL,
            dspEffects = listDspEffect1
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_deep,
        iconResIdSmall = R.drawable.a_deep,
        name = "Deep",
        i4 = 46,
        i5 = 5,
        isPro = false,
    )
}

fun musicNormalEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_LOWGAIN(低音增益)", 0.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_MIDGAIN(中音增益)", 0.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_HIGHGAIN(高音增益)", 0.0f, -80.0f, 10.0f))
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_LOWCROSSOVER(中低交叉频率)",
            400.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_HIGHCROSSOVER(高中交叉频率)",
            4000.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_CROSSOVERSLOPE(交叉斜率)", 1.0f, 0.0f, 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_THREE_EQ,
            dspEffects = listDspEffect2
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_music,
        iconResIdSmall = R.drawable.a_music,
        name = "Normal",
        i4 = 39,
        i5 = 5,
        isPro = false,
    )
}

fun musicRockEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_LOWGAIN(低音增益)", 10.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_MIDGAIN(中音增益)", -3.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_HIGHGAIN(高音增益)", 9.0f, -80.0f, 10.0f))
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_LOWCROSSOVER(中低交叉频率)",
            80.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_HIGHCROSSOVER(高中交叉频率)",
            8000.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_CROSSOVERSLOPE(交叉斜率)", 1.0f, 0.0f, 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_THREE_EQ,
            dspEffects = listDspEffect2
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_music,
        iconResIdSmall = R.drawable.a_music,
        name = "Rock",
        i4 = 39,
        i5 = 5,
        isPro = false,
    )
}

fun musicPopEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_LOWGAIN(低音增益)", 6.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_MIDGAIN(中音增益)", 0.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_HIGHGAIN(高音增益)", 10.0f, -80.0f, 10.0f))
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_LOWCROSSOVER(中低交叉频率)",
            150.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_HIGHCROSSOVER(高中交叉频率)",
            7000.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_CROSSOVERSLOPE(交叉斜率)", 1.0f, 0.0f, 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_THREE_EQ,
            dspEffects = listDspEffect2
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_music,
        iconResIdSmall = R.drawable.a_music,
        name = "Pop",
        i4 = 39,
        i5 = 5,
        isPro = false,
    )
}

fun musicJazzEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_LOWGAIN(低音增益)", 5.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_MIDGAIN(中音增益)", 5.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_HIGHGAIN(高音增益)", 0.0f, -80.0f, 10.0f))
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_LOWCROSSOVER(中低交叉频率)",
            3000.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_HIGHCROSSOVER(高中交叉频率)",
            4000.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_CROSSOVERSLOPE(交叉斜率)", 1.0f, 0.0f, 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_THREE_EQ,
            dspEffects = listDspEffect2
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_music,
        iconResIdSmall = R.drawable.a_music,
        name = "Jazz",
        i4 = 39,
        i5 = 5,
        isPro = false,
    )
}

fun musicClassicEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_LOWGAIN(低音增益)", 4.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_MIDGAIN(中音增益)", 0.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_HIGHGAIN(高音增益)", 4.0f, -80.0f, 10.0f))
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_LOWCROSSOVER(中低交叉频率)",
            200.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_HIGHCROSSOVER(高中交叉频率)",
            7000.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_CROSSOVERSLOPE(交叉斜率)", 1.0f, 0.0f, 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_THREE_EQ,
            dspEffects = listDspEffect2
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_music,
        iconResIdSmall = R.drawable.a_music,
        name = "Classic",
        i4 = 39,
        i5 = 5,
        isPro = false,
    )
}

fun musicVocalEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_LOWGAIN(低音增益)", 5.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_MIDGAIN(中音增益)", 4.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_HIGHGAIN(高音增益)", 0.0f, -80.0f, 10.0f))
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_LOWCROSSOVER(中低交叉频率)",
            1000.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_HIGHCROSSOVER(高中交叉频率)",
            4000.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_CROSSOVERSLOPE(交叉斜率)", 1.0f, 0.0f, 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_THREE_EQ,
            dspEffects = listDspEffect2
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_music,
        iconResIdSmall = R.drawable.a_music,
        name = "Vocal",
        i4 = 39,
        i5 = 5,
        isPro = false,
    )
}

fun karaokeEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_LOWGAIN(低音增益)", 0.0f, -3.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_MIDGAIN(中音增益)", 0.0f, -80.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_HIGHGAIN(高音增益)", 0.0f, 6.0f, 10.0f))
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_LOWCROSSOVER(中低交叉频率)",
            100.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_HIGHCROSSOVER(高中交叉频率)",
            4000.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_CROSSOVERSLOPE(交叉斜率)", 1.0f, 0.0f, 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_THREE_EQ,
            dspEffects = listDspEffect2
        )
    )

    val listDspEffect1 = mutableListOf<DspEffect>()
    listDspEffect1.add(DspEffect("FMOD_DSP_SFXREVERB_DECAYTIME(Decay Time)", 4000.0f))
    listDspEffect1.add(DspEffect("FMOD_DSP_SFXREVERB_EARLYDELAY(Early Delay)", 20.0f))
    listDspEffect1.add(DspEffect("FMOD_DSP_SFXREVERB_LATEDELAY(Reverb Delay)", 40.0f))
    listDspEffect1.add(DspEffect("FMOD_DSP_SFXREVERB_HFREFERENCE(HF Reference)", 5000.0f))
    listDspEffect1.add(DspEffect("FMOD_DSP_SFXREVERB_HFDECAYRATIO(Decay HF Ratio)", 50.0f))
    listDspEffect1.add(DspEffect("FMOD_DSP_SFXREVERB_DIFFUSION(Diffusion)", 100.0f))
    listDspEffect1.add(DspEffect("FMOD_DSP_SFXREVERB_DENSITY(Density)", 100.0f))
    listDspEffect1.add(
        DspEffect(
            "FMOD_DSP_SFXREVERB_LOWSHELFFREQUENCY(Low Shelf Frequency)",
            250.0f
        )
    )
    listDspEffect1.add(DspEffect("FMOD_DSP_SFXREVERB_LOWSHELFGAIN(Low Shelf Gain)", 0.0f))
    listDspEffect1.add(DspEffect("FMOD_DSP_SFXREVERB_HIGHCUT(High Cut)", 20000.0f))
    listDspEffect1.add(DspEffect("FMOD_DSP_SFXREVERB_EARLYLATEMIX(Early/Late Mix)", 50.0f))
    listDspEffect1.add(DspEffect("FMOD_DSP_SFXREVERB_WETLEVEL(Wet Level)", -6.0f))
    listDspEffect1.add(DspEffect("FMOD_DSP_SFXREVERB_DRYLEVEL(Dry Level)", 0.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_SFXREVERB,
            dspEffects = listDspEffect1
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_karaoke,
        iconResIdSmall = R.drawable.a_karaoke,
        name = "Karaoke",
        i4 = 50,
        i5 = 4,
        isPro = false,
    )
}

fun studioEffect(): EffectItem {
    val listDspInfo = mutableListOf<DspInfo>()
    val listDspEffect2 = mutableListOf<DspEffect>()
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_LOWGAIN(低音增益)", 0.0f, -5.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_MIDGAIN(中音增益)", 0.0f, 3.0f, 10.0f))
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_HIGHGAIN(高音增益)", 0.0f, -1.0f, 10.0f))
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_LOWCROSSOVER(中低交叉频率)",
            500.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(
        DspEffect(
            "FMOD_DSP_THREE_EQ_HIGHCROSSOVER(高中交叉频率)",
            5000.0f,
            10.0f,
            22000.0f
        )
    )
    listDspEffect2.add(DspEffect("FMOD_DSP_THREE_EQ_CROSSOVERSLOPE(交叉斜率)", 1.0f, 0.0f, 2.0f))
    listDspInfo.add(
        DspInfo(
            aiSoundType = AiSound.TYPE_FMOD_DSP_TYPE_THREE_EQ,
            dspEffects = listDspEffect2
        )
    )
    return EffectItem(
        dspInfoList = listDspInfo,
        pathBgEffect = "",
        iconResId = R.drawable.a_studio,
        iconResIdSmall = R.drawable.a_studio,
        name = "Studio",
        i4 = 51,
        i5 = 4,
        isPro = false,
    )
}