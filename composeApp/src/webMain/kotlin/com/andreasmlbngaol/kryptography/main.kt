package com.andreasmlbngaol.kryptography

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.andreasmlbngaol.kryptography.core.di.initKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin()
    ComposeViewport {
        App()
    }
}