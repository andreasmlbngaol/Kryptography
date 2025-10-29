package com.andreasmlbngaol.kryptography.core.di

import com.andreasmlbngaol.kryptography.features.caesar.presentation.CaesarViewModel
import com.andreasmlbngaol.kryptography.features.home.presentation.HomeViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::CaesarViewModel)
}