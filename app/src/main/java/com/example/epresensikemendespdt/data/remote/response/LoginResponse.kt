package com.example.epresensikemendespdt.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class LoginResponse(
    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("data")
    val data: UserData
)

@Parcelize
data class UserData(
    @field:SerializedName("user_id")
    val user_id: Int,

    @field:SerializedName("nama")
    val nama: String,

    @field:SerializedName("enroll_number")
    val enroll_number: String,

    @field:SerializedName("foto")
    val foto: String,

    @field:SerializedName("token")
    val token: String
) : Parcelable

