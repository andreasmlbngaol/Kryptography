package com.andreasmlbngaol.kryptography.core.presentation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowBack

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BackAppBar(
    title: String,
    onBack: () -> Boolean,
    modifier: Modifier = Modifier,
    actions: @Composable (RowScope.() -> Unit) = {},
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(
                onClick = { onBack() },
                shapes = IconButtonDefaults.shapes()
            ) {
                Icon(
                    imageVector = TablerIcons.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        modifier = modifier,
        actions = actions,
        scrollBehavior = scrollBehavior
    )
}