import android.content.Context
import android.text.TextUtils
import android.util.Log
import com.inshot.videotomp3.b
import com.inshot.videotomp3.c
import com.inshot.videotomp3.checkValue
import com.inshot.videotomp3.d
import com.inshot.videotomp3.fq1
import java.io.File

object s62 {
    fun a(var0: Int, var1: Int, var2: Int, var3: Int): fq1 {
        val var6 = var1.toFloat()
        val var4 = var2.toFloat()
        val var5 = var0.toFloat()
        var var7: Int = checkValue(d(var6, var4 * 1.0f / var5))
        val var8: Int
        if (var7 > var3) {
            var8 = checkValue(d(var5, var3.toFloat() * 1.0f / var6))
            var7 = var3
        } else {
            var8 = var2
        }
        val var11: Byte = 0
        val var9: Int = if (var8 == var2 && var7 < var3) {
            (var3 - var7) / 2
        } else {
            0
        }
        var var10 = var11.toInt()
        if (var7 == var3) {
            var10 = var11.toInt()
            if (var8 < var2) {
                var10 = (var2 - var8) / 2
            }
        }
        val var12 = StringBuilder()
        var12.append("util input w*h=")
        var12.append(var0)
        var12.append("*")
        var12.append(var1)
        var12.append(", output w*h=")
        var12.append(var2)
        var12.append("*")
        var12.append(var3)
        var12.append(", result w*h=")
        var12.append(var8)
        var12.append("*")
        var12.append(var7)
        var12.append(", offsetX=")
        var12.append(var10)
        var12.append(", offsetY=")
        var12.append(var9)
        Log.i("VideoMerge", var12.toString())
        return fq1(var8, var7, var10, var9)
    }

    fun b1(var0: String?, var1: Int, var2: String): String {
        return if (TextUtils.isEmpty(var0)) {
            val var3 = StringBuilder()
            var3.append("[")
            var3.append(var1)
            var3.append("]")
            var3.toString()
        } else {
            var2
        }
    }

    fun c1(var0: Int): String {
        return if (var0 == 1) {
            "Sequence"
        } else if (var0 == 2) {
            "LeftAndRight"
        } else {
            if (var0 == 3) "UpAndDown" else ""
        }
    }

    fun d1(var0: Int, var1: Int, var2: Int, var3: Int, var4: Int, var5: Int): List<fq1> {
        var var4 = var4
        var var5 = var5
        val var11 = var4.toFloat()
        var var7 = var0.toFloat()
        var var9 = var1.toFloat()
        var var10 = var7 * 1.0f / var9
        var var6 = var2.toFloat()
        var var8 = var3.toFloat()
        var var12: Int = checkValue(b(var11, var10 + var6 * 1.0f / var8))
        var var17 = StringBuilder()
        var17.append("util calculate height=")
        var17.append(var12)
        Log.i("VideoMerge", var17.toString())
        var var13 = var12
        if (var12 >= var5) {
            var13 = var5
        }
        var10 = var13.toFloat() * 1.0f
        var9 = var10 / var9
        var var15: Int = checkValue(d(var9, var7))
        var8 = var10 / var8
        var var16: Int = checkValue(d(var8, var6))
        var12 = var15
        var var14 = var16
        if (var13 < var5) {
            var12 = var15
            var14 = var16
            if (var15 + var16 != var4) {
                var7 = c(var9, var7)
                var6 = c(var8, var6)
                var17 = StringBuilder()
                var17.append("mulInt w1=")
                var17.append(var15)
                var17.append(", w2=")
                var17.append(var16)
                Log.i("VideoMerge", var17.toString())
                var17 = StringBuilder()
                var17.append("mulFloat w1=")
                var17.append(var7)
                var17.append(", w2=")
                var17.append(var6)
                Log.i("VideoMerge", var17.toString())
                if (var7 - var7.toInt().toFloat() <= var6 - var6.toInt().toFloat()) {
                    var14 = var4 - var15
                    var12 = var15
                } else {
                    var12 = var4 - var16
                    var14 = var16
                }
            }
        }
        if (var13 == var5) {
            var5 = (var4 - var12 - var14) / 2
            var4 = var5 + var12
            var16 = 0
            var15 = 0
        } else {
            var16 = (var5 - var13) / 2
            var15 = var16
            var4 = var12
            var5 = 0
        }
        var17 = StringBuilder()
        var17.append("util result, input1 w*h=")
        var17.append(var0)
        var17.append("*")
        var17.append(var1)
        var17.append(", ratio=")
        var17.append(h(var0, var1))
        var17.append(", output w*h=")
        var17.append(var12)
        var17.append("*")
        var17.append(var13)
        var17.append(", ratio=")
        var17.append(h(var12, var13))
        var17.append(", offsetX=")
        var17.append(var5)
        var17.append(", offsetY=")
        var17.append(var16)
        Log.i("VideoMerge", var17.toString())
        var17 = StringBuilder()
        var17.append("util result, input2 w*h=")
        var17.append(var2)
        var17.append("*")
        var17.append(var3)
        var17.append(", ratio=")
        var17.append(h(var2, var3))
        var17.append(", output w*h=")
        var17.append(var14)
        var17.append("*")
        var17.append(var13)
        var17.append(", ratio=")
        var17.append(h(var14, var13))
        var17.append(", offsetX=")
        var17.append(var4)
        var17.append(", offsetY=")
        var17.append(var15)
        Log.i("VideoMerge", var17.toString())
        return listOf(fq1(var12, var13, var5, var16), fq1(var14, var13, var4, var15))
    }

    fun e(var0: Int, var1: Int, var2: Int, var3: Int, var4: Int, var5: Int): List<fq1> {
        var var4 = var4
        var var5 = var5
        var var10 = var5.toFloat()
        var var7 = var1.toFloat()
        var var9 = var0.toFloat()
        val var11 = var7 * 1.0f / var9
        var var6 = var3.toFloat()
        var var8 = var2.toFloat()
        var var12: Int = checkValue(b(var10, var11 + var6 * 1.0f / var8))
        var var13 = var12
        if (var12 >= var4) {
            var13 = var4
        }
        var10 = var13.toFloat() * 1.0f
        var9 = var10 / var9
        var var15: Int = checkValue(d(var9, var7))
        var8 = var10 / var8
        var var16: Int = checkValue(d(var8, var6))
        var12 = var15
        var var14 = var16
        var var17: StringBuilder
        if (var13 < var4) {
            var12 = var15
            var14 = var16
            if (var15 + var16 != var5) {
                var7 = c(var9, var7)
                var6 = c(var8, var6)
                var17 = StringBuilder()
                var17.append("mulInt h1=")
                var17.append(var15)
                var17.append(", h2=")
                var17.append(var16)
                Log.i("VideoMerge", var17.toString())
                var17 = StringBuilder()
                var17.append("mulFloat h1=")
                var17.append(var7)
                var17.append(", h2=")
                var17.append(var6)
                Log.i("VideoMerge", var17.toString())
                if (var7 - var7.toInt().toFloat() <= var6 - var6.toInt().toFloat()) {
                    var14 = var5 - var15
                    var12 = var15
                } else {
                    var12 = var5 - var16
                    var14 = var16
                }
            }
        }
        if (var13 == var4) {
            var4 = (var5 - var12 - var14) / 2
            var16 = var4 + var12
            var5 = 0
            var15 = 0
        } else {
            var15 = (var4 - var13) / 2
            var5 = var15
            var16 = var12
            var4 = 0
        }
        var17 = StringBuilder()
        var17.append("util result, input1 w*h=")
        var17.append(var0)
        var17.append("*")
        var17.append(var1)
        var17.append(", ratio=")
        var17.append(h(var0, var1))
        var17.append(", output w*h=")
        var17.append(var13)
        var17.append("*")
        var17.append(var12)
        var17.append(", ratio=")
        var17.append(h(var13, var12))
        var17.append(", offsetX=")
        var17.append(var15)
        var17.append(", offsetY=")
        var17.append(var4)
        Log.i("VideoMerge", var17.toString())
        var17 = StringBuilder()
        var17.append("util result, input2 w*h=")
        var17.append(var2)
        var17.append("*")
        var17.append(var3)
        var17.append(", ratio=")
        var17.append(h(var2, var3))
        var17.append(", output w*h=")
        var17.append(var13)
        var17.append("*")
        var17.append(var14)
        var17.append(", ratio=")
        var17.append(h(var13, var14))
        var17.append(", offsetX=")
        var17.append(var5)
        var17.append(", offsetY=")
        var17.append(var16)
        Log.i("VideoMerge", var17.toString())
        return listOf(fq1(var13, var12, var15, var4), fq1(var13, var14, var5, var16))
    }


    fun g(var0: Int): String {
        return if (var0 == 5) "PlayOneAfterAnother" else "PlayTogether"
    }

    private fun h(var0: Int, var1: Int): Float {
        return if (var1 == 0) 0.0f else checkValue(var0.toFloat() * 1.0f, var1.toFloat() * 1.0f, 4)
    }

    fun f(context: Context): File {
        return File(context.filesDir, "mute.mp3")
    }
}