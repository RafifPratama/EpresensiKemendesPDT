package com.example.epresensikemendespdt.data.local

object AttendanceData {

    /**
     * January 2025 - New Year period with some absences
     */
    val januaryRecords = listOf(
        AttendanceRecord("1 Januari 2025", AttendanceStatus.ALPA), // New Year holiday
        AttendanceRecord("2 Januari 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("3 Januari 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("6 Januari 2025", AttendanceStatus.HADIR, "08:05", "17:05"),
        AttendanceRecord("7 Januari 2025", AttendanceStatus.HADIR, "08:20", "17:15"),
        AttendanceRecord("8 Januari 2025", AttendanceStatus.ALPA),
        AttendanceRecord("9 Januari 2025", AttendanceStatus.HADIR, "08:10", "17:00"),
        AttendanceRecord("10 Januari 2025", AttendanceStatus.HADIR, "08:00", "17:20"),
        AttendanceRecord("13 Januari 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord("14 Januari 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("15 Januari 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("16 Januari 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
        AttendanceRecord("17 Januari 2025", AttendanceStatus.HADIR, "08:20", "17:15"),
        AttendanceRecord("20 Januari 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("21 Januari 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("22 Januari 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord("23 Januari 2025", AttendanceStatus.ALPA),
        AttendanceRecord("24 Januari 2025", AttendanceStatus.HADIR, "08:10", "17:00"),
        AttendanceRecord("27 Januari 2025", AttendanceStatus.HADIR, "08:00", "17:05"),
        AttendanceRecord("28 Januari 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("29 Januari 2025", AttendanceStatus.HADIR, "08:20", "17:15"),
        AttendanceRecord("30 Januari 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("31 Januari 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
    )

    /**
     * February 2025 - Perfect attendance month
     */
    val februaryRecords = listOf(
        AttendanceRecord("3 Februari 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("4 Februari 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
        AttendanceRecord("5 Februari 2025", AttendanceStatus.HADIR, "08:05", "17:10"),
        AttendanceRecord("6 Februari 2025", AttendanceStatus.HADIR, "08:15", "17:00"),
        AttendanceRecord("7 Februari 2025", AttendanceStatus.HADIR, "08:00", "17:15"),
        AttendanceRecord("10 Februari 2025", AttendanceStatus.HADIR, "08:10", "17:00"),
        AttendanceRecord("11 Februari 2025", AttendanceStatus.HADIR, "08:00", "17:05"),
        AttendanceRecord("12 Februari 2025", AttendanceStatus.HADIR, "08:20", "17:10"),
        AttendanceRecord("13 Februari 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord(
            "14 Februari 2025",
            AttendanceStatus.HADIR,
            "08:15",
            "17:20"
        ), // Valentine's Day
        AttendanceRecord("17 Februari 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("18 Februari 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
        AttendanceRecord("19 Februari 2025", AttendanceStatus.HADIR, "08:05", "17:10"),
        AttendanceRecord("20 Februari 2025", AttendanceStatus.HADIR, "08:15", "17:00"),
        AttendanceRecord("21 Februari 2025", AttendanceStatus.HADIR, "08:00", "17:15"),
        AttendanceRecord("24 Februari 2025", AttendanceStatus.HADIR, "08:10", "17:00"),
        AttendanceRecord("25 Februari 2025", AttendanceStatus.HADIR, "08:00", "17:05"),
        AttendanceRecord("26 Februari 2025", AttendanceStatus.HADIR, "08:20", "17:10"),
        AttendanceRecord("27 Februari 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord("28 Februari 2025", AttendanceStatus.HADIR, "08:15", "17:05"),
    )

    /**
     * March 2025 - Some late arrivals
     */
    val marchRecords = listOf(
        AttendanceRecord("3 Maret 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("4 Maret 2025", AttendanceStatus.HADIR, "08:30", "17:30"), // Late in
        AttendanceRecord("5 Maret 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("6 Maret 2025", AttendanceStatus.HADIR, "08:45", "17:45"), // Late in
        AttendanceRecord("7 Maret 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("10 Maret 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
        AttendanceRecord("11 Maret 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("12 Maret 2025", AttendanceStatus.HADIR, "08:25", "17:20"),
        AttendanceRecord("13 Maret 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord("14 Maret 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("17 Maret 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("18 Maret 2025", AttendanceStatus.HADIR, "08:35", "17:30"), // Late in
        AttendanceRecord("19 Maret 2025", AttendanceStatus.HADIR, "08:05", "17:05"),
        AttendanceRecord("20 Maret 2025", AttendanceStatus.HADIR, "08:10", "17:00"),
        AttendanceRecord("21 Maret 2025", AttendanceStatus.HADIR, "08:00", "17:15"),
        AttendanceRecord("24 Maret 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("25 Maret 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("26 Maret 2025", AttendanceStatus.HADIR, "08:20", "17:20"),
        AttendanceRecord("27 Maret 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord("28 Maret 2025", AttendanceStatus.ALPA),
        AttendanceRecord("31 Maret 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
    )

    /**
     * April 2025 - Mix of present and absent days
     */
    val aprilRecords = listOf(
        AttendanceRecord("1 April 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("2 April 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("3 April 2025", AttendanceStatus.ALPA), // Sick leave
        AttendanceRecord("4 April 2025", AttendanceStatus.ALPA), // Sick leave
        AttendanceRecord("7 April 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
        AttendanceRecord("8 April 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("9 April 2025", AttendanceStatus.HADIR, "08:20", "17:15"),
        AttendanceRecord("10 April 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord("11 April 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("14 April 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("15 April 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
        AttendanceRecord("16 April 2025", AttendanceStatus.ALPA),
        AttendanceRecord("17 April 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord("18 April 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("21 April 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("22 April 2025", AttendanceStatus.HADIR, "08:20", "17:15"),
        AttendanceRecord("23 April 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord("24 April 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
        AttendanceRecord("25 April 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("28 April 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("29 April 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("30 April 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
    )

    /**
     * May 2025 - Holiday season with multiple absences
     */
    val mayRecords = listOf(
        AttendanceRecord("1 Mei 2025", AttendanceStatus.ALPA), // Labor Day
        AttendanceRecord("2 Mei 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("5 Mei 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("6 Mei 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
        AttendanceRecord("7 Mei 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("8 Mei 2025", AttendanceStatus.HADIR, "08:20", "17:15"),
        AttendanceRecord("9 Mei 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord("12 Mei 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("13 Mei 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("14 Mei 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
        AttendanceRecord("15 Mei 2025", AttendanceStatus.ALPA), // Personal leave
        AttendanceRecord("16 Mei 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("19 Mei 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("20 Mei 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord("21 Mei 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
        AttendanceRecord("22 Mei 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("23 Mei 2025", AttendanceStatus.HADIR, "08:20", "17:15"),
        AttendanceRecord("26 Mei 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("27 Mei 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("28 Mei 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord("29 Mei 2025", AttendanceStatus.ALPA), // Ascension Day
        AttendanceRecord("30 Mei 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
    )

    /**
     * December 2025 - Current month (as shown in original image)
     */
    val decemberRecords = listOf(
        AttendanceRecord("1 Desember 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("2 Desember 2025", AttendanceStatus.HADIR, "08:15", "17:05"),
        AttendanceRecord("3 Desember 2025", AttendanceStatus.ALPA),
        AttendanceRecord("4 Desember 2025", AttendanceStatus.HADIR, "08:10", "17:15"),
        AttendanceRecord("5 Desember 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord("8 Desember 2025", AttendanceStatus.HADIR, "08:00", "17:10"),
        AttendanceRecord("9 Desember 2025", AttendanceStatus.HADIR, "08:20", "17:20"),
        AttendanceRecord("10 Desember 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord("11 Desember 2025", AttendanceStatus.HADIR, "08:15", "17:05"),
        AttendanceRecord("12 Desember 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("15 Desember 2025", AttendanceStatus.HADIR, "08:10", "17:10"),
        AttendanceRecord("16 Desember 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("17 Desember 2025", AttendanceStatus.HADIR, "08:15", "17:15"),
        AttendanceRecord("18 Desember 2025", AttendanceStatus.HADIR, "08:05", "17:00"),
        AttendanceRecord("19 Desember 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
        AttendanceRecord("22 Desember 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("23 Desember 2025", AttendanceStatus.HADIR, "08:15", "17:10"),
        AttendanceRecord("24 Desember 2025", AttendanceStatus.ALPA), // Christmas Eve
        AttendanceRecord("25 Desember 2025", AttendanceStatus.ALPA), // Christmas
        AttendanceRecord("26 Desember 2025", AttendanceStatus.ALPA), // Boxing Day
        AttendanceRecord("29 Desember 2025", AttendanceStatus.HADIR, "08:00", "17:00"),
        AttendanceRecord("30 Desember 2025", AttendanceStatus.HADIR, "08:10", "17:05"),
        AttendanceRecord("31 Desember 2025", AttendanceStatus.ALPA), // New Year's Eve
    )

    /**
     * Get records for a specific month
     */
    fun getRecordsForMonth(month: String, year: String = "2025"): List<AttendanceRecord> {
        return when (month.lowercase()) {
            "januari", "january" -> januaryRecords
            "februari", "february" -> februaryRecords
            "maret", "march" -> marchRecords
            "april" -> aprilRecords
            "mei", "may" -> mayRecords
            "desember", "december" -> decemberRecords
            else -> emptyList()
        }
    }

    /**
     * Get all available months
     */
    fun getAvailableMonths(): List<String> {
        return listOf(
            "Januari",
            "Februari",
            "Maret",
            "April",
            "Mei",
            "Desember"
        )
    }
}