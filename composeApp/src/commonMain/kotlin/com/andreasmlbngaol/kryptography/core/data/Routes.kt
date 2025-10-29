package com.andreasmlbngaol.kryptography.core.data

import com.andreasmlbngaol.kryptography.core.domain.NavKey
import kotlinx.serialization.Serializable


@Serializable
data object HomeNavKey : NavKey

@Serializable
data object CaesarNavKey: NavKey