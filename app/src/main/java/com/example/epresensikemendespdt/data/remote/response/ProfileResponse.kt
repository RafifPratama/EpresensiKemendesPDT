package com.example.epresensikemendespdt.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ProfileResponse(
    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("data")
    val data: UserDetail
)

data class UserDetail(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("enroll_number")
    val enroll_number: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("foto")
    val foto: String,

    @field:SerializedName("jabatan")
    val jabatan: String,

    @field:SerializedName("golongan")
    val golongan: String,

    @field:SerializedName("unit_kerja")
    val unitKerja: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("nomor_hp")
    val nomorHp: String,

    @field:SerializedName("employee_status")
    val employeeStatus: String,

    @field:SerializedName("biodata")
    val biodata: Biodata,

    @field:SerializedName("allow_presensi")
    val allowPresensi: AllowPresensi
)

data class Biodata(
    @field:SerializedName("gneder")
    val gender: String,

    @field:SerializedName("agama")
    val agama: String,

    @field:SerializedName("birthday")
    val birthday: String,

    @field:SerializedName("tempat_lahir")
    val tempatLahir: String
)

data class AllowPresensi(
    @field:SerializedName("wfo")
    val isWfo: Boolean,

    @field:SerializedName("wfh")
    val isWfh: Boolean,

    @field:SerializedName("izin")
    val isIzin: Boolean,

    @field:SerializedName("dinas")
    val isDinas: Boolean
)