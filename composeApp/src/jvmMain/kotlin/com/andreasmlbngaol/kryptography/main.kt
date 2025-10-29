package com.andreasmlbngaol.kryptography

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.andreasmlbngaol.kryptography.core.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Kryptography",
        ) {
            App()
        }
    }
}