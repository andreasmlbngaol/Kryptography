package com.andreasmlbngaol.kryptography.core.config

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreasmlbngaol.kryptography.core.data.CaesarNavKey
import com.andreasmlbngaol.kryptography.core.data.HomeNavKey
import com.andreasmlbngaol.kryptography.features.caesar.presentation.CaesarScreen
import com.andreasmlbngaol.kryptography.features.home.presentation.HomeScreen

@Composable
fun Router() {
    val navController = rememberNavController()

    val onBack = { navController.navigateUp() }

    NavHost(
        navController = navController,
        startDestination = HomeNavKey,
        enterTransition = {
            scaleIn(animationSpec = tween(400), initialScale = 0.9f) + fadeIn(animationSpec = tween(400))
        },
        exitTransition = {
            fadeOut(animationSpec = tween(200))
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(400))
        },
        popExitTransition = {
            scaleOut(animationSpec = tween(400), targetScale = 0.9f) + fadeOut(animationSpec = tween(400))
        }
    ) {
        composable<HomeNavKey> {
            HomeScreen(
                onNavigateToAlgorithm = { algorithmKey ->
                    navController.navigate(algorithmKey)
                }
            )
        }

        composable<CaesarNavKey> {
            CaesarScreen(
                onBack = onBack
            )
        }
    }
}
