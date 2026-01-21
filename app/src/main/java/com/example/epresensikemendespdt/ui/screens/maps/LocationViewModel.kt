package com.example.epresensikemendespdt.ui.screens.maps

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LocationViewModel : ViewModel() {
    private val _distance = MutableStateFlow<Double?>(null)
    val distance : StateFlow<Double?> = _distance

    fun updateDistance(value: Double) {
        Log.d("cekDistance", value.toString())
        _distance.value = value
    }
}