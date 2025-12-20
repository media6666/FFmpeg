package io.microshow.aisound.model


// cái này là Adj
data class DspEffect(
    val textId: String, // cái này giống như Id. cố định là tiếng anh
    val name: String, // cái này là text lấy từ file string. để muốn làm đa ngôn ngữ thì làm
    var valueCustom: Float, //f10 - cái này cho custom
    val value1: Float, //f10 //value1,2,3 là các pitch, rate, quality nhưng k rõ cái nào là cái nào. :))
    val value2: Float, //f11
    val value3: Float, //f12
    val isCustom: Boolean,
    val isPro: Boolean, //isPRO
) {
    constructor(
        textId: String,
        value1: Float,
        value2: Float,
        value3: Float,
    ) : this(
        textId = textId,
        name = "",
        value1 = value1,
        valueCustom = value1,
        value2 = value2,
        value3 = value3,
        isCustom = false,
        isPro = false
    )

    constructor(textId: String, value11: Float) : this(
        textId = textId,
        valueCustom = value11,
        name = "",
        value1 = 1f,
        value2 = 1f,
        value3 = 1f,
        isCustom = false,
        isPro = false
    )

    constructor(
        textId: String,
        name: String,
        value1: Float,
        value2: Float,
        value3: Float,
        isCustom: Boolean
    ) : this(
        textId = textId,
        name = name,
        value1 = value1,
        valueCustom = value1,
        value2 = value2,
        value3 = value3,
        isCustom = isCustom,
        isPro = false
    )

    constructor(
        textId: String,
        name: String,
        value1: Float, //f10
        value2: Float, //f11
        value3: Float, //f12
        isCustom: Boolean,
        isPro: Boolean
    ) : this(
        textId = textId,
        name = name,
        value1 = value1,
        valueCustom = value1,
        value2 = value2,
        value3 = value3,
        isCustom = isCustom,
        isPro = isPro
    )

    fun getValueApplyEffect(): Float {
        return valueCustom
    }
}