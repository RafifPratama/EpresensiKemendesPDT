package com.example.epresensikemendespdt.ui.screens.presensi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.epresensikemendespdt.data.local.DateData
import com.example.epresensikemendespdt.ui.screens.home.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class PresensiViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow<PresensiUiStete>(PresensiUiStete.Loading)
    val uiState: StateFlow<PresensiUiStete> = _uiState.asStateFlow()

    private val _presensiUiState = MutableStateFlow<UiState>(UiState.Loading)
    val presensiUiState: StateFlow<UiState> = _presensiUiState.asStateFlow()

    init {
        getJakartaCurrentDate()
    }

    private fun getJakartaCurrentDate() {
        viewModelScope.launch {
            val jakartaZone = ZoneId.of("Asia/Jakarta")
            val indonesianLocale = Locale("id", "ID")

            val dateFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy", indonesianLocale)
            val dayFormatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy", indonesianLocale)
            val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss", indonesianLocale)

            while (true) {
                val currentDateInJakarta = ZonedDateTime.now(jakartaZone)
                val dateData = DateData(
                    currentDay = currentDateInJakarta.format(dayFormatter),
                    currentDate = currentDateInJakarta.format(dateFormatter),
                    currentTime = currentDateInJakarta.format(timeFormatter)
                )
                _uiState.value = PresensiUiStete.Success(dateData)
                delay(1000)
            }
        }
    }
}