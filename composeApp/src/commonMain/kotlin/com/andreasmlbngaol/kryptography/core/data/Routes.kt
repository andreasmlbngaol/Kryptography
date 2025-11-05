package com.andreasmlbngaol.kryptography.core.data

import com.andreasmlbngaol.kryptography.core.domain.NavKey
import kotlinx.serialization.Serializable


@Serializable
data object HomeNavKey : NavKey

@Serializable
data object CaesarNavKey: NavKey

@Serializable
data object SpiralNavKey: NavKey

@Serializable
data object DiagonalNavKey: NavKey

@Serializable
data object AffineNavKey: NavKey

@Serializable
data object VigenereNavKey: NavKey

@Serializable
data object HomophonicNavKey: NavKey

@Serializable
data object PlayfairNavKey: NavKey