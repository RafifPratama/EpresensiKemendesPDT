package com.example.epresensikemendespdt.data.local

data class AttendanceRecord(
    val date: String,
    val status: AttendanceStatus,
    val masuk: String = "",
    val keluar: String = ""
)

enum class AttendanceStatus {
    HADIR, ALPA
}