package com.andreasmlbngaol.kryptography.features.home.domain

import com.andreasmlbngaol.kryptography.core.domain.NavKey
import org.jetbrains.compose.resources.DrawableResource

data class Algorithm(
    val name: String,
    val imageRes: DrawableResource? = null,
    val navKey: NavKey
)