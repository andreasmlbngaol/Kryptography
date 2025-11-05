package com.andreasmlbngaol.kryptography.features.affine.presentation.components.compact

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.andreasmlbngaol.kryptography.core.domain.EncodingTable
import com.andreasmlbngaol.kryptography.core.presentation.RoundedOutlinedTextField
import com.andreasmlbngaol.kryptography.features.affine.presentation.AffineState
import com.andreasmlbngaol.kryptography.resources.Res
import com.andreasmlbngaol.kryptography.resources.affine_a_error_message
import com.andreasmlbngaol.kryptography.resources.affine_a_title
import com.andreasmlbngaol.kryptography.resources.affine_b_error_message
import com.andreasmlbngaol.kryptography.resources.affine_b_title
import com.andreasmlbngaol.kryptography.resources.cipher_text_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun AffineCompactDecrypt(
    state: AffineState,
    onChangeCipherText: (String) -> Unit,
    onChangeCipherA: (String) -> Unit,
    onChangeCipherB: (String) -> Unit,
    onDecryptText: () -> Unit
) {
    val encodingTable = EncodingTable()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RoundedOutlinedTextField(
            value = state.cipherText,
            onValueChange = onChangeCipherText,
            label = {
                Text(stringResource(Res.string.cipher_text_title))
            },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            RoundedOutlinedTextField(
                value = state.cipherAAsString,
                onValueChange = onChangeCipherA,
                label = {
                    Text(stringResource(Res.string.affine_a_title))
                },
                isError = state.cipherAIsError,
                supportingText = {
                    if(state.cipherAIsError) Text(stringResource(Res.string.affine_a_error_message))
                },
                modifier = Modifier.weight(1f)
            )

            RoundedOutlinedTextField(
                value = state.cipherBAsString,
                onValueChange = onChangeCipherB,
                label = {
                    Text(stringResource(Res.string.affine_b_title))
                },
                isError = state.cipherBIsError,
                supportingText = {
                    if(state.cipherBIsError) Text(stringResource(Res.string.affine_b_error_message))
                },
                modifier = Modifier.weight(1f)
            )
        }

//        Button(
//            enabled = state.decryptButtonEnabled,
//            onClick = onDecryptText,
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text(
//                text = stringResource(Res.string.decrypt_button_text)
//            )
//        }

        AnimatedVisibility(
            !state.cipherAIsError
                    && state.cipherA != null
                    && !state.cipherBIsError
                    && state.cipherB != null
                    && state.cipherText.isNotEmpty()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Start),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "(${state.cipherA})^-1 = ${state.cipherAInverse.toString()}",
                    style = MaterialTheme.typography.titleLarge
                )
                val decrypted = state.cipherText.map { char ->
                    val charIndex = encodingTable.data.indexOf(char)
                    var tempRes: Int? = null
                    var res: Int? = null
                    if (state.cipherAInverse != null && state.cipherB != null) {
                        tempRes = (state.cipherAInverse * (charIndex - state.cipherB))
                        res = tempRes % 26
                        if (res < 0) {
                            res += 26
                        }
                    }

                    Text(
                        text = "$char: ${state.cipherAInverse} x ($charIndex - ${state.cipherB}) mod 26 = $tempRes mod 26 = $res (${
                            encodingTable.data.getOrNull(
                                res ?: -1
                            )
                        })"
                    )
                    encodingTable.data.getOrNull(
                        res ?: -1
                    )
                }.joinToString("")
                Text(
                    text = decrypted,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}