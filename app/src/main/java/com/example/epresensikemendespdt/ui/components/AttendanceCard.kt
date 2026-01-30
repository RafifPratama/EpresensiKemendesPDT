package com.example.epresensikemendespdt.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.epresensikemendespdt.data.local.AttendanceRecord
import com.example.epresensikemendespdt.data.local.AttendanceStatus

@Composable
fun AttendanceCard(
    record: AttendanceRecord,
    modifier: Modifier = Modifier,
    indicatorColor: Color = Color(0xFF0098D8),
    onCardClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        onClick = { onCardClick?.invoke() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Blue indicator line
            IndicatorLine(color = indicatorColor)

            Spacer(modifier = Modifier.width(12.dp))

            // Date and attendance info
            AttendanceInfo(
                date = record.date,
                masuk = record.masuk,
                keluar = record.keluar,
                modifier = Modifier.weight(1f)
            )

            // Status badge
            StatusBadge(status = record.status)
        }
    }
}

@Composable
private fun IndicatorLine(
    color: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(4.dp)
            .height(60.dp)
            .background(
                color = color,
                shape = RoundedCornerShape(2.dp)
            )
    )
}

@Composable
private fun AttendanceInfo(
    date: String,
    masuk: String,
    keluar: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = date,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))

        AttendanceTimeRow(label = "Masuk", time = masuk)

        Spacer(modifier = Modifier.height(4.dp))

        AttendanceTimeRow(label = "Keluar", time = keluar)
    }
}

@Composable
private fun AttendanceTimeRow(
    label: String,
    time: String
) {
    Row {
        Text(
            text = "$label :",
            fontSize = 14.sp,
            color = Color.Black
        )
        if (time.isNotEmpty()) {
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = time,
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun StatusBadge(
    status: AttendanceStatus,
    modifier: Modifier = Modifier
) {
    val (backgroundColor, text) = when (status) {
        AttendanceStatus.HADIR -> Color(0xFF00C853) to "Hadir"
        AttendanceStatus.ALPA -> Color(0xFFD32F2F) to "Alpa"
    }

    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(4.dp),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 6.dp),
        enabled = false,
        modifier = modifier
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium
        )
    }
}