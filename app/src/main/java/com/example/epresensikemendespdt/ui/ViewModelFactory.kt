package com.example.epresensikemendespdt.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.epresensikemendespdt.data.local.token.TokenPreferences
import com.example.epresensikemendespdt.data.local.token.TokenViewModel
import com.example.epresensikemendespdt.ui.screens.profile.ProfileViewModel

class ViewModelFactory(private val pref: TokenPreferences) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(pref) as T
        } else if (modelClass.isAssignableFrom(TokenViewModel::class.java)) {
            return TokenViewModel(pref) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}