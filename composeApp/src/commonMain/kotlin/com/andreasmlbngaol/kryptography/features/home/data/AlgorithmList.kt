package com.andreasmlbngaol.kryptography.features.home.data

import com.andreasmlbngaol.kryptography.core.data.CaesarNavKey
import com.andreasmlbngaol.kryptography.features.home.domain.Algorithm

val algorithms = listOf(
    Algorithm(
        name = "Caesar Cipher",
        navKey = CaesarNavKey
    )
)