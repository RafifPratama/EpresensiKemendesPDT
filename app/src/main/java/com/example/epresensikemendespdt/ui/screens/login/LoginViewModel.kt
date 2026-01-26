package com.example.epresensikemendespdt.ui.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.epresensikemendespdt.data.local.token.TokenPreferences
import com.example.epresensikemendespdt.data.remote.request.LoginRequest
import com.example.epresensikemendespdt.data.remote.response.LoginResponse
import com.example.epresensikemendespdt.data.remote.retrofit.ApiConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

sealed class LoginUiState {
    object Idle : LoginUiState()
    object Loading : LoginUiState()
    data class Success(val data: LoginResponse) : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}

class LoginViewModel(private val pref: TokenPreferences) : ViewModel(){
    private val _loginResponse = MutableLiveData<LoginResponse?>()
    val loginResponse: LiveData<LoginResponse?> = _loginResponse
//    private val _loginResponse = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
//    val loginResponse: StateFlow<LoginUiState> = _loginResponse

    private val _isLoading = MutableLiveData(false)
    val isLoading : LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    companion object{
        private const val TAG = "LoginViewModel"
    }

    fun postLogin(username: String, password: String) {
        Log.e(TAG, username.toString())
        Log.e(TAG, password.toString())
        _isLoading.value = true
        val client = ApiConfig.getApiService().login(LoginRequest(username, password))
        client.enqueue(object : retrofit2.Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    _loginResponse.value = response.body()
                    _isLoading.value = false
//                    _loginResponse.value = LoginUiState.Success(response.body())
                    Log.e(TAG, _loginResponse.value.toString())
                }else{
                    _errorMessage.value = response.body().toString()
                    Log.e(TAG, "onFailure3: ${response.toString()}")
                    _isLoading.value = false
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e(TAG, "onFailure3: ${t.message.toString()}")
            }
        })
    }

    fun getToken() : LiveData<String> {
        return pref.getToken().asLiveData()
    }

    fun saveToken(token: String, user_id: String) {
        viewModelScope.launch {
            pref.saveSession(token, user_id)
        }
    }
}