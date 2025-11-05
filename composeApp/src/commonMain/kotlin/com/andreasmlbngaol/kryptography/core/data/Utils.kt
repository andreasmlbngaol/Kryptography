package com.andreasmlbngaol.kryptography.core.data

fun String.isAlphabetWithSpace(): Boolean = this.all { char -> char.isLetter() || char.isWhitespace()}
fun String.isAlphabet(): Boolean = this.all { char -> char.isLetter()}
fun String.isNumeric(): Boolean = this.all { char -> char.isDigit()}

fun Int.modInverse(m: Int): Int? {
    fun gcd(x: Int, y: Int): Int {
        return if (y == 0) x else gcd(y, x % y)
    }

    if (gcd(this, m) != 1) {
        return null // gada inverse, langsung batal
    }

    var m0 = m
    var x0 = 0
    var x1 = 1
    var aVar = this

    while (aVar > 1) {
        val q = aVar / m0
        var t = m0

        m0 = aVar % m0
        aVar = t
        t = x0

        x0 = x1 - q * x0
        x1 = t
    }

    if (x1 < 0) x1 += m
    return x1
}
