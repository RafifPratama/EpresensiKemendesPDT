package com.example.epresensikemendespdt.data.remote.retrofit

import com.example.epresensikemendespdt.data.remote.request.LoginRequest
import com.example.epresensikemendespdt.data.remote.response.LoginResponse
import retrofit2.Call
import retrofit2.Response

import retrofit2.http.*

interface ApiService {
//    @FormUrlEncoded
    @POST("auth/login")
    fun login(
        @Body request: LoginRequest
//        @Field("username") username: String,
//        @Field("password") password: String
    ): Call<LoginResponse>
}