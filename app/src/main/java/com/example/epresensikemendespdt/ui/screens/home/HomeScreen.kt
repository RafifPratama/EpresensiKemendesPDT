package com.example.epresensikemendespdt.ui.screens.home

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.epresensikemendespdt.R

@Composable
fun HomeScreen(
    onCheckPresensi: () -> Unit,
    onToDaftarKehadrian: () -> Unit,
    onToPengajuanIzin: () -> Unit,
    onLogoutSuccess:() -> Unit,
    homeViewModel: HomeViewModel = viewModel()
){
    val uiState by homeViewModel.uiState.collectAsState()

    NewHomeContent(
        uiState,
        onCheckPresensi,
        onLogoutSuccess
    )
}

@Composable
fun NewHomeContent(
    uiState: UiState,
    onCheckPresensi: () -> Unit,
    onLogoutSuccess: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.loginbg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
        ) {
            TopBar(onLogoutSuccess)

            AttendanceCard(onCheckPresensi)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color(0xFF5F5F5F5)
                    )
                    .padding(16.dp, 16.dp)
            ) {
                DateHeader(uiState)

                Spacer(modifier = Modifier.height(16.dp))

                StatsSection()

                Spacer(modifier = Modifier.height(16.dp))

                MenuItems()
            }
        }
    }
}

@Composable
fun TopBar(
    onLogoutSuccess: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo placeholder
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.3f)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_kemendesa),
                contentDescription = "logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Logout Icon
        IconButton(
            onClick = { onLogoutSuccess() },
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.3f))
        ) {
            Icon(
                imageVector = Icons.Default.ExitToApp,
                contentDescription = "Logout",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }

    }
}

@Composable
fun AttendanceCard(
    onCheckPresensi: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.iconcalender),
                    contentDescription = "Calendar",
                    modifier = Modifier.size(32.dp)
                )
                Text(
                    text = "Isi kehadiran hari ini",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Button(
                onClick = { onCheckPresensi() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE53935)
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .width(56.dp)
                    .height(40.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.preview),
                    contentDescription = "Check",
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}

@Composable
fun DateHeader(
    uiState: UiState
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            when (uiState) {
                UiState.Loading -> {
                    CircularProgressIndicator()
                }

                is UiState.Success -> {
                    val dateData = (uiState as UiState.Success).data

                    Text(
                        text = dateData.currentDay,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF047BEC)
                    )

                    Text(
                        text = dateData.currentDate,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                    )
                }

                is UiState.Error -> {
                    val errorMessage = (uiState as UiState.Error).errorMessage

                    Text(
                        text = errorMessage,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF047BEC)
                    )

                    Text(
                        text = errorMessage,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                    )
                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Masuk",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(end = 5.dp)
                )

                Text(
                    text = "Keluar",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(start = 5.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(end = 5.dp),
                    colors = CardDefaults.cardColors(Color.Gray),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Text(
                        text = "09.00",
                        fontSize = 26.sp,
                        color = Color.White
                    )
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(start = 5.dp),
                    colors = CardDefaults.cardColors(Color.Gray),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Text(
                        text = "16.00",
                        fontSize = 26.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun TimeInfo(label: String, time: String) {
    Column {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .width(150.dp)
                .background(Color(0xFFEEEEEE), RoundedCornerShape(8.dp))
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = time,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}

@Composable
fun StatsSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        StatCard(
            value = "80%",
            label = "Kehadiran",
            color = Color(0xFF2196F3),
            modifier = Modifier.weight(1f)
        )
        StatCard(
            value = "2",
            label = "Tidak Hadir",
            color = Color(0xFFE53935),
            modifier = Modifier.weight(1f)
        )
        StatCard(
            value = "10",
            label = "Hari Kerja",
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun StatCard(value: String, label: String, color: Color, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = value,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = color
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                fontSize = 12.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun MenuItems() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        MenuItem(
            icon = Icons.Default.List,
            text = "Daftar kehadiran",
            onClick = { /* Navigate to attendance list */ }
        )
        MenuItem(
            icon = Icons.Default.Create,
            text = "Izin dan Perjalanan Dinas",
            onClick = { /* Navigate to permits */ }
        )
    }
}

@Composable
fun MenuItem(icon: ImageVector, text: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = Color(0xFF2196F3),
                modifier = Modifier.size(28.dp)
            )
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}