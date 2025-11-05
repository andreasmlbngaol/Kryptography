package com.andreasmlbngaol.kryptography.features.affine.presentation

import androidx.compose.runtime.Composable
import com.andreasmlbngaol.kryptography.core.presentation.rememberWindowType
import com.andreasmlbngaol.kryptography.features.affine.presentation.components.compact.AffineCompactScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AffineScreen(
    onBack: () -> Boolean,
    viewModel: AffineViewModel = koinViewModel()
) {
    val windowType = rememberWindowType()

    when(windowType) {
        else -> AffineCompactScreen(
            onBack = onBack,
            viewModel = viewModel
        )
    }

}