package com.example.epresensikemendespdt.data.remote.retrofit

import com.example.epresensikemendespdt.data.remote.request.LoginRequest
import com.example.epresensikemendespdt.data.remote.response.LoginResponse
import com.example.epresensikemendespdt.data.remote.response.ProfileResponse
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

    @GET("pegawai/{id}")
    fun getDetailUser(
        @Header("Authorization") token: String,
        @Path("id")id : String
    ): Call<ProfileResponse>
}