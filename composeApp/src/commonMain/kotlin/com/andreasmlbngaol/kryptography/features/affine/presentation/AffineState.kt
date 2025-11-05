package com.andreasmlbngaol.kryptography.features.affine.presentation

data class AffineState(
    val selectedMenuIndex: Int = 0,

    val plainText: String = "",
    val plainA: String = "",
    val plainB: String = "",
    val encryptedText: String = "",

    val cipherText: String = "",
    val cipherAAsString: String = "",
    val cipherA: Int? = null,
    val cipherAIsError: Boolean = false,
    val cipherAInverse: Int? = null,
    val cipherBAsString: String = "",
    val cipherB: Int? = null,
    val cipherBIsError: Boolean = false,
    val decryptButtonEnabled: Boolean = false,
    val decryptedText: String = "",
)