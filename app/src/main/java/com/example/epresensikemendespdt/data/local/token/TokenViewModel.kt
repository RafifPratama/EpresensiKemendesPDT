package com.example.epresensikemendespdt.data.local.token

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")

class TokenViewModel (private val pref: TokenPreferences) : ViewModel() {

    fun getToken() : LiveData<String> {
        return pref.getToken().asLiveData()
    }

    fun getUserid() : LiveData<String> {
        return pref.getUserId().asLiveData()
    }

    fun saveSession(token: String, user_id: String) {
        viewModelScope.launch {
            pref.saveSession(token, user_id)
        }
    }
}