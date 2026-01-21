package com.example.epresensikemendespdt.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Profile : Screen("Profile")
    object Login : Screen("Login")
    object DaftarKehadiran : Screen("DaftarKehadiran")
    object Presensi : Screen("Presensi")
    object Maps : Screen("Maps")
}