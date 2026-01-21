package com.example.epresensikemendespdt.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.epresensikemendespdt.R
import kotlin.text.ifEmpty

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    modifier: Modifier = Modifier,
) {
//    val context = LocalContext.current
//    val authDataStore = remember { AuthDataStore(context) }
//    val viewModel : LoginViewModel = viewModel(
//        factory = LoginViewModelFactory(authDataStore)
//    )
//
//    val loginState by viewModel.loginState.collectAsState()

    var username by remember { mutableStateOf( "") }
    var password by remember { mutableStateOf( "") }
    var passwordVisible by remember { mutableStateOf( false) }

    var usernameError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }

//    LaunchedEffect(loginState) {
//        when(loginState) {
//            is LoginState.Success -> {
//                onLoginSuccess()
//                viewModel.resetState()
//            }
//            is LoginState.Error -> {
//
//            }
//            else -> {}
//        }
//    }

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
                .fillMaxHeight()
                .padding(top = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logologin),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f)
            )

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
                        .padding(20.dp)
                ) {
                    Text(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp),
                        text = "Selamat Datang!",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center

                    )


                    TextField(
                        value = "username",
                        onValueChange = {username = it},
                        label = { Text(usernameError.ifEmpty { "Username" }, color = if (usernameError.isNotEmpty()) Color.Red else Color.DarkGray) },
                        leadingIcon = {
                            Icon(Icons.Rounded.AccountCircle,
                                contentDescription = "")
                        },
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(start=10.dp, end = 10.dp, bottom = 28.dp),
                        shape = RoundedCornerShape(8.dp)

                    )

                    TextField(
                        value = "password",
                        onValueChange = {password = it},
                        label = { Text(passwordError.ifEmpty { "Password" }, color = if (passwordError.isNotEmpty()) Color.Red else Color.DarkGray) },
                        leadingIcon = {
                            Icon(Icons.Rounded.Lock,
                                contentDescription = "")
                        },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            val image = if (passwordVisible)
                                painterResource(R.drawable.visible)
                            else painterResource(id = R.drawable.invisible)

                            Icon(
                                painter = image,
                                contentDescription = "",
                                modifier = modifier.clickable { passwordVisible = !passwordVisible}
                            )
                        },
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(start=10.dp, end = 10.dp, bottom = 28.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Transparent,
                            unfocusedIndicatorColor = Transparent
                        ),
                        //enabled = loginState !is LoginState.Loading
                    )

//                    if (loginState is LoginState.Error) {
//                        Text(
//                            text = (loginState as LoginState.Error).message,
//                            color = Color.Red,
//                            modifier = modifier
//                                .fillMaxWidth()
//                                .padding(start = 10.dp, end = 10.dp, bottom = 16.dp),
//                            textAlign = TextAlign.Center
//                        )
//                    }

                    Button(
                        onClick = {
//                            var isValid = true
//
//                            if (username.isBlank()) {
//                                usernameError = "Username tidak boleh kosong"
//                                isValid = false
//                            }
//
//                            if (password.isBlank()) {
//                                passwordError = "Password tidak boleh kosong"
//                                isValid = false
//                            }
//
//                            if (isValid) {
//                                viewModel.login(username, password)
//                            }
                            onLoginSuccess()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF047BEC)),
                        shape = RoundedCornerShape(8.dp),
                        modifier = modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(start = 10.dp, end = 10.dp)
                    ) {
                        Text(
                            text = "Login",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.logo_kemendesa),
                        contentDescription = null,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(30.dp)
                    )
                }
            }
        }
    }
}