package com.example.epresensikemendespdt.ui.screens.presensi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Face
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.epresensikemendespdt.R
import com.example.epresensikemendespdt.ui.screens.maps.LocationViewModel

@Composable
fun PresensiScreen(
    onBackToHome: () -> Unit,
    onOpenMaps: () -> Unit,
    presensiViewModel: PresensiViewModel = viewModel(),
    locationViewModel: LocationViewModel = viewModel()
) {
    val dateUiState by presensiViewModel.uiState.collectAsState()
    val distance by locationViewModel.distance.collectAsState()

    PresensiContent(
        dateUiState = dateUiState,
        distance = distance,
        onBackToHome = onBackToHome,
        onOpenMaps = onOpenMaps
    )
}

@Composable
fun PresensiContent(
    dateUiState: PresensiUiStete,
    distance: Double?,
    onBackToHome: () -> Unit,
    onOpenMaps: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFEDECEC))
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp)

        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = {
                        onBackToHome()
                    },
                    modifier = modifier
                        .fillMaxWidth(0.3f),
                ) {
                    Row(
                        modifier = modifier.fillMaxWidth()
                    ) {
                        Icon(
                            Icons.Outlined.ArrowBack,
                            contentDescription = null
                        )
                        Text(
                            text = "Kembali",
                            textAlign = TextAlign.Center,
                            modifier = modifier
                                .padding(top = 4.dp, start = 5.dp)
                        )
                    }
                }
            }
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.warning),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = modifier
                        .fillMaxWidth(0.35f)
                )

                Column(
                    modifier = modifier,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Harap perhatikan waktu kehadiran Anda!",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        text = "Pastikan Anda berada di lingkungan Kementerian Desa dan Pembangunan Daerah Tertinggal",
                        fontSize = 12.sp,

                        )
                }
            }

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {

                when (dateUiState) {
                    PresensiUiStete.Loading -> {
                        CircularProgressIndicator()
                    }

                    is PresensiUiStete.Success-> {
                        val dateData = (dateUiState as PresensiUiStete.Success).data

                        Text(
                            text = dateData.currentDay,
                            modifier = modifier
                                .fillMaxWidth(0.5f)
                                .padding(top = 10.dp, bottom = 10.dp)

                        )

                        Text(
                            text = dateData.currentTime,
                            modifier = modifier
                                .fillMaxWidth(1f)
                                .padding(top = 10.dp, bottom = 10.dp),
                            textAlign = TextAlign.End
                        )
                    }
                }

            }

            Column(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = distance?.let {
                        "Jarak Anda %.2f meter".format(it)
                    } ?: "Jarak belum dihitung"
                    ,
                    modifier = modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                )

                Button(
                    onClick = {
                        onOpenMaps()
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFF047BEC)),
                    modifier = modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Buka Map",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }

            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Masuk:",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = modifier
                            .padding(end = 10.dp)
                    )

                    Text(
                        text = "09.00",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = modifier
                            .height(60.dp)

                    ) {
                        Icon(
                            Icons.Outlined.Face,
                            contentDescription = null
                        )
                    }
                }
            }

            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Keluar:",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = modifier
                            .padding(end = 10.dp)
                    )

                    Text(
                        text = "16.00",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Button(
                        onClick = {
                        },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = modifier
                            .height(60.dp)

                    ) {
                        Icon(
                            Icons.Outlined.Face,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}