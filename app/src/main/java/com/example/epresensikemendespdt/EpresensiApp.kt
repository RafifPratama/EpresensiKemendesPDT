package com.example.epresensikemendespdt

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.epresensikemendespdt.data.local.token.TokenPreferences
import com.example.epresensikemendespdt.ui.navigation.NavigationItem
import com.example.epresensikemendespdt.ui.navigation.Screen
import com.example.epresensikemendespdt.ui.screens.home.HomeScreen
import com.example.epresensikemendespdt.ui.screens.login.LoginScreen
import com.example.epresensikemendespdt.ui.screens.login.LoginViewModel
import com.example.epresensikemendespdt.ui.screens.login.LoginViewModelFactory
import com.example.epresensikemendespdt.ui.screens.maps.MapScreen
import com.example.epresensikemendespdt.ui.screens.presensi.PresensiScreen
import com.example.epresensikemendespdt.ui.screens.profile.ProfileScreen
import kotlin.math.log

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")

@Composable
fun EpresensiApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val context = LocalContext.current
    val pref = TokenPreferences.getInstance(context.dataStore)

    Scaffold(
        bottomBar = {
//            if (currentRoute != Screen.Login.route) {
//                BottomBar(navController)
//            } else if (currentRoute != Screen.DaftarKehadiran.route) {
//                BottomBar(navController)
//            } else if (currentRoute != Screen.Presensi.route) {
//                BottomBar(navController)
//            } else if (currentRoute != Screen.Maps.route)
//                BottomBar(navController)
            if (currentRoute == Screen.Home.route) {
                BottomBar(navController)
            } else if (currentRoute == Screen.Profile.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = modifier.padding(innerPadding)
        ){
            composable(Screen.Home.route) {
                HomeScreen(
                    onCheckPresensi = {
                        navController.navigate(Screen.Presensi.route) {
                            popUpTo(Screen.Home.route) {
                                inclusive = true
                            }
                        }
                    },
                    onToDaftarKehadrian = {
                        navController.navigate(Screen.DaftarKehadiran.route) {
                            popUpTo(Screen.Home.route) {
                                inclusive = false
                            }
                        }
                    },
                    onToPengajuanIzin = {},
                    onLogoutSuccess = {
                        navController.navigate(Screen.Login.route) {
                            popUpTo(Screen.Home.route) {
                                inclusive = true
                            }
                        }
                    }

                )
            }

            composable(Screen.Login.route) {
                val loginViewModel: LoginViewModel = viewModel(
                    factory = LoginViewModelFactory(pref)
                )

                LoginScreen(
                    loginViewModel = loginViewModel,
                    onLoginSuccess = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Login.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable(Screen.Presensi.route) {
                PresensiScreen(
                    onBackToHome = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Presensi.route) {
                                inclusive = true
                            }
                        }
                    },

                    onOpenMaps = {
                        navController.navigate(Screen.Maps.route) {
                            popUpTo(Screen.Presensi.route) {
                                inclusive = false
                            }
                        }
                    }
                )
            }

            composable(Screen.Profile.route) {
                ProfileScreen()
            }

            composable(Screen.Maps.route) {
                MapScreen(navController)
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavigationBar(
        modifier = modifier
            .background(Color.White)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = "Home",
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = "Profile",
                icon = Icons.Default.AccountCircle,
                screen = Screen.Profile
            ),
        )

        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}