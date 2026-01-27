package com.example.epresensikemendespdt.ui.screens.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.epresensikemendespdt.data.local.token.TokenPreferences
import com.example.epresensikemendespdt.data.remote.response.ProfileResponse
import com.example.epresensikemendespdt.data.remote.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Response

class ProfileViewModel(private val pref: TokenPreferences) : ViewModel(){

    private val _profileResponse = MutableLiveData<ProfileResponse?>()
    val profileResponse : LiveData<ProfileResponse?> = _profileResponse

    private val _isLoading = MutableLiveData(false)
    val isLoading : LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    companion object {
        private const val TAG = "ProfilViewModel"
    }

    fun getProfile(userId: String, token: String) {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getDetailUser("Bearer $token", userId)
        client.enqueue(object : retrofit2.Callback<ProfileResponse> {
            override fun onResponse(
                call: Call<ProfileResponse?>,
                response: Response<ProfileResponse?>
            ) {
                if (response.isSuccessful) {
                    _profileResponse.value = response.body()
                    _isLoading.value = false
                } else {
                    _errorMessage.value = response.body().toString()
                    Log.e(TAG, "onFailure3: ${response.toString()}")
                    _isLoading.value = false
                }
            }

            override fun onFailure(call: Call<ProfileResponse?>, t: Throwable) {
                _errorMessage.value = t.message.toString()
                Log.e(TAG, "onFailure3: ${t.message.toString()}")
            }
        })
        _isLoading.value = false
    }
}