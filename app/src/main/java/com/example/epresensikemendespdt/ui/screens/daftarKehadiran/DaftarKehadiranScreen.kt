package com.example.epresensikemendespdt.ui.screens.daftarKehadiran

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices.PIXEL_9
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.epresensikemendespdt.data.local.AttendanceData
import com.example.epresensikemendespdt.data.local.AttendanceRecord
import com.example.epresensikemendespdt.ui.components.AttendanceCard
import com.example.epresensikemendespdt.ui.components.CustomDropdown

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceListScreen(
    onBackClick: () -> Unit = {}
) {
    var selectedMonth by remember { mutableStateOf("Desember") }
    var selectedYear by remember { mutableStateOf("2025") }

    // Get attendance records based on selected month
    val attendanceList by remember(selectedMonth, selectedYear) {
        derivedStateOf {
            AttendanceData.getRecordsForMonth(selectedMonth, selectedYear)
        }
    }


    // Available months (with data)
    val months = AttendanceData.getAvailableMonths()
    val years = listOf("2024", "2025", "2026")

    Scaffold(
        topBar = {
            GradientTopBar(
                title = "Daftar Kehadiran",
                onBackClick = onBackClick
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(paddingValues)
        ) {
            // Filter Section
            FilterSection(
                months = months,
                years = years,
                selectedMonth = selectedMonth,
                selectedYear = selectedYear,
                onMonthSelected = { selectedMonth = it },
                onYearSelected = { selectedYear = it }
            )

            // Attendance List
            if (attendanceList.isEmpty()) {
                EmptyState()
            } else {
                AttendanceList(
                    attendanceRecords = attendanceList,
                    onCardClick = { record ->
                        // Handle card click - navigate to detail screen
                        println("Clicked on: ${record.date}")
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GradientTopBar(
    title: String,
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier.background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xFF0098D8),
                    Color(0xFF00D4FF)
                )
            )
        )
    )
}

@Composable
private fun FilterSection(
    months: List<String>,
    years: List<String>,
    selectedMonth: String,
    selectedYear: String,
    onMonthSelected: (String) -> Unit,
    onYearSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF0098D8),
                        Color(0xFF00D4FF)
                    )
                )
            )
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Month Dropdown
        CustomDropdown(
            items = months,
            selectedItem = selectedMonth,
            onItemSelected = onMonthSelected,
            modifier = Modifier.weight(1f),
            backgroundColor = Color.White,
            textColor = Color.Black,
            iconTint = Color.Gray,
            cornerRadius = 8,
            fontSize = 14
        )

        // Year Dropdown
        CustomDropdown(
            items = years,
            selectedItem = selectedYear,
            onItemSelected = onYearSelected,
            modifier = Modifier.weight(1f),
            backgroundColor = Color.White,
            textColor = Color.Black,
            iconTint = Color.Gray,
            cornerRadius = 8,
            fontSize = 14
        )
    }
}

@Composable
private fun EmptyState() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "📅",
                fontSize = 48.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Tidak ada data kehadiran",
                fontSize = 16.sp,
                color = Color.Gray
            )
            Text(
                text = "untuk bulan ini",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
private fun AttendanceList(
    attendanceRecords: List<AttendanceRecord>,
    onCardClick: (AttendanceRecord) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(attendanceRecords) { record ->
            AttendanceCard(
                record = record,
                onCardClick = { onCardClick(record) }
            )
        }
    }
}

// Preview
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = PIXEL_9
)
@Composable
fun PreviewAttendanceListScreen() {
    AttendanceListScreen()
}