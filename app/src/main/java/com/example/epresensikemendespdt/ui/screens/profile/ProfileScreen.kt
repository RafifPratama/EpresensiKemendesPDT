package com.example.epresensikemendespdt.ui.screens.profile

import android.util.Log
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.epresensikemendespdt.R
import com.example.epresensikemendespdt.data.local.token.TokenViewModel
import com.example.epresensikemendespdt.data.remote.response.UserDetail

@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel,
    tokenViewModel: TokenViewModel
){
    val token by tokenViewModel.getToken().observeAsState()
    val userId by tokenViewModel.getUserid().observeAsState()
    Log.e("ProfileScreen", userId.toString())

    userId?.let {
        LaunchedEffect(Unit) {
            profileViewModel.getProfile(userId = userId.toString(), token = token.toString())
        }
    }

    val profileResponse by profileViewModel.profileResponse.observeAsState()
    val isLoading by profileViewModel.isLoading.observeAsState()
    val errorMessage by profileViewModel.errorMessage.observeAsState()

    when {
        isLoading == true -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        errorMessage != null -> {
            Text(
                text = errorMessage ?: "Error",
                color = Color.Red
            )
        }

        profileResponse != null -> {
            ProfileContent(
                profileResponse!!.data
            )
        }
    }
}

@Composable
fun ProfileContent(
    userDetail: UserDetail,
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
//                Image(
//                    painterResource(id = R.drawable.iupp),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = modifier
//                        .size(200.dp)
//                        .clip(CircleShape)
//                        .fillMaxWidth()
//                )

                val urlFoto = "http://103.125.203.88:8080/foto_pegawai/${userDetail.foto}"
                AsyncImage(
                    model = urlFoto,
                    contentDescription = "Profile Photo",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = userDetail.name,
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
                            text = userDetail.enroll_number.toString(),
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
                            text = userDetail.unitKerja,
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
                            text = userDetail.golongan,
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
                            text = userDetail.jabatan,
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
