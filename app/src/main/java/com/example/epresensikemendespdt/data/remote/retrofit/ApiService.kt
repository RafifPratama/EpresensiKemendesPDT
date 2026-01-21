package com.example.epresensikemendespdt.data.remote.retrofit

import com.example.epresensikemendespdt.data.remote.response.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("auth/login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ) : Call<LoginResponse>
}