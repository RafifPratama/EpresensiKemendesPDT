package com.example.epresensikemendespdt.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices.PIXEL_3
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.epresensikemendespdt.R

@Composable
fun ProfileScreen(

){
    ProfileContent(
        nama = "Fulan bin Wulan",
        idPegawai = "1234567890",
        unitKerja = "Pusat Data dan Informasi Desa dan Daerah Tertinggal",
        golongan = "Golongan XI",
        jabatan = "Analis Program"
    )
}

@Composable
fun ProfileContent(
    nama: String,
    idPegawai: String,
    unitKerja: String,
    golongan: String,
    jabatan: String,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.loginbg),
            contentDescription = null,
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .fillMaxHeight(0.4f)
                    .fillMaxWidth()
                    .padding(top = 40.dp, bottom = 10.dp, start = 30.dp, end = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(id = R.drawable.iupp),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .fillMaxWidth()
                )

                Text(
                    text = nama,
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )
            }

            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(15.dp, 20.dp)
                ) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                    ) {
                        Text(
                            text = "NIK/NIP:",
                            textAlign = TextAlign.End,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = modifier
                                .fillMaxWidth(0.5f)
                                .padding(end = 10.dp)
                        )

                        Text(
                            text = idPegawai,
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = modifier
                                .fillMaxWidth(1f)
                        )
                    }

                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                    ) {
                        Text(
                            text = "Unit Kerja:",
                            textAlign = TextAlign.End,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = modifier
                                .fillMaxWidth(0.5f)
                                .padding(end = 10.dp)
                        )

                        Text(
                            text = unitKerja,
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 3,
                            modifier = modifier
                                .fillMaxWidth(1f)
                        )
                    }

                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                    ) {
                        Text(
                            text = "Golongan:",
                            textAlign = TextAlign.End,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = modifier
                                .fillMaxWidth(0.5f)
                                .padding(end = 10.dp)
                        )

                        Text(
                            text = golongan,
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 2,
                            modifier = modifier
                                .fillMaxWidth(1f)
                        )
                    }

                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                    ) {
                        Text(
                            text = "Jabatan:",
                            textAlign = TextAlign.End,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = modifier
                                .fillMaxWidth(0.5f)
                                .padding(end = 10.dp)
                        )

                        Text(
                            text = jabatan,
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 2,
                            modifier = modifier
                                .fillMaxWidth(1f)
                        )
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = PIXEL_3,
)
@Composable
fun ProfileScreenPreview(){
    ProfileScreen()
}