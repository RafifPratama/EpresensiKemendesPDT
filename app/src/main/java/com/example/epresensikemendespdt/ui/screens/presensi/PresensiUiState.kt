package com.example.epresensikemendespdt.ui.screens.presensi

import com.example.epresensikemendespdt.data.local.DateData

sealed interface PresensiUiStete {
    object Loading : PresensiUiStete
    data class Success(val data: DateData) : PresensiUiStete
    data class Error(val errorMessage: String)
}