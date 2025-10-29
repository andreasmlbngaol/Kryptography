package com.andreasmlbngaol.kryptography.features.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import compose.icons.TablerIcons
import compose.icons.tablericons.Key
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AlgorithmCard(
    name: String,
    imageRes: DrawableResource?,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            if (imageRes != null) {
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = name,
                    modifier = Modifier
                        .sizeIn(minHeight = 120.dp)
                        .fillMaxWidth()
                )
            } else {
                Icon(
                    imageVector = TablerIcons.Key,
                    contentDescription = name,
                    modifier = Modifier
                        .sizeIn(minHeight = 120.dp)
                        .fillMaxWidth()
                )
            }

            Text(
                text = name,
                textAlign = TextAlign.Center
            )
        }
    }
}