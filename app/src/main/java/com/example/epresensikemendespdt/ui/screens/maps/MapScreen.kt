package com.example.epresensikemendespdt.ui.screens.maps

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Circle
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(
    navController: NavController,
    viewModel: LocationViewModel = viewModel()
) {
    val context = LocalContext.current

    var hasPermission by remember { mutableStateOf(false) }
    var calculatedDistance by remember { mutableStateOf<Double?>(null) }
    var isCalculating by remember { mutableStateOf(true) }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        hasPermission = granted
        if (!granted) navController.popBackStack()
    }

    LaunchedEffect(Unit) {
        permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    if (!hasPermission) return

    val kemendesaKalibata = LatLng(-6.254944965335838, 106.85132348082455)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(kemendesaKalibata, 14f)
    }

    GoogleMap (
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        onMapLoaded = {
            isCalculating = true
            calculateDistance(
                context = context,
                target = kemendesaKalibata,
                onResult = { distance ->
                    calculatedDistance = distance
                    isCalculating = false
                }
            )
        }

    ){
        Marker(
            state = MarkerState(position = kemendesaKalibata),
            title = "KemendesaPDT Kalibata"
        )

        Circle(
            center = kemendesaKalibata,
            radius = 100.0,
            fillColor = Color.Blue.copy(alpha = 0.3f),
            strokeColor = Color.Blue,
            strokeWidth = 3f
        )
    }

    Button(
        onClick = {
            calculatedDistance?.let {
                viewModel.updateDistance(it)
                navController.popBackStack()
            }
        },
        enabled = calculatedDistance != null && !isCalculating,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color(0xFF047BEC))
    ) {
        Text("Simpan")
    }

    Text(
        text = when {
            isCalculating -> "Menghitung jarak..."
            calculatedDistance != null ->
                "Jarak: %.1f meter".format(calculatedDistance)
            else -> "Gagal menghitung jarak"
        },
        modifier = Modifier
            .padding(bottom = 80.dp)
    )
}

@SuppressLint("MissingPermission")
fun calculateDistance(
    context: Context,
    target: LatLng,
    onResult: (Double) -> Unit
) {
    val fusedClient =
        LocationServices.getFusedLocationProviderClient(context)

    fusedClient.getCurrentLocation(
        com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY,
        null
    ).addOnSuccessListener { location ->
        location?.let {
            val result = FloatArray(1)
            Location.distanceBetween(
                it.latitude,
                it.longitude,
                target.latitude,
                target.longitude,
                result
            )
            onResult(result[0].toDouble())
        }

    }
}