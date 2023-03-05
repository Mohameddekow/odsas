package com.example.odsas.students_module.presentation.home_screen.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


//BottomShadow(alpha = .9f, height = 68.dp)

@Composable
fun BottomShadow(alpha: Float = 0.1f, height: Dp = 2.dp) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(1.dp))
        .fillMaxWidth(0.98f)
        .height(height)
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color.Black.copy(alpha = alpha),
                    Color.Transparent,
                )
            )
        )

    )
}