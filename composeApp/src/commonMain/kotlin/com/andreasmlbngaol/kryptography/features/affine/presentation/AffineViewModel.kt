package com.andreasmlbngaol.kryptography.features.affine.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreasmlbngaol.kryptography.core.data.isAlphabet
import com.andreasmlbngaol.kryptography.core.data.modInverse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AffineViewModel: ViewModel() {
    private val _state = MutableStateFlow(AffineState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.collect { current ->
                _state.value = current.copy(
                    cipherAIsError = (current.cipherA == null) xor (current.cipherAAsString.isEmpty()),
                    cipherBIsError = (current.cipherB == null) xor (current.cipherBAsString.isEmpty()),
                    cipherAInverse = current.cipherA?.modInverse(26)
                )

                val shouldEnable = current.cipherText.isNotEmpty()
                        && !current.cipherAIsError
                        && current.cipherA != null
                        && !current.cipherBIsError
                        && current.cipherB != null

                if(current.decryptButtonEnabled != shouldEnable) {
                    _state.value = current.copy(decryptButtonEnabled = shouldEnable)
                }
            }
        }
    }

    fun selectMenu(index: Int) {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                selectedMenuIndex = index
            )
        }
    }

    fun changeCipherText(text: String) {
        if(text.isEmpty() or text.isAlphabet()) {
            _state.value = _state.value.copy(
                cipherText = text.uppercase()
            )
        }
    }

    fun changeCipherA(text: String) {
        _state.value = _state.value.copy(
            cipherAAsString = text.trim(),
            cipherA = text.toIntOrNull()
        )
    }

    fun changeCipherB(text: String) {
        _state.value = _state.value.copy(
            cipherBAsString = text.trim(),
            cipherB = text.toIntOrNull()
        )
    }

    fun decryptText() {

    }

}