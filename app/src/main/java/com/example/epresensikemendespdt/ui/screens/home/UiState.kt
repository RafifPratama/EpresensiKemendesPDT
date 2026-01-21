package com.example.epresensikemendespdt.ui.screens.home

import com.example.epresensikemendespdt.data.local.DateData

sealed interface UiState {
    object Loading: UiState
    data class Success(val data: DateData) : UiState
    data class Error(val errorMessage: String) : UiState
}