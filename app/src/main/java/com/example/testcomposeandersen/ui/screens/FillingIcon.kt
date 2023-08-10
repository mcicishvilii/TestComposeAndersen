package com.example.testcomposeandersen.ui.screens

import android.graphics.drawable.Drawable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.drawable.toDrawable
import com.example.testcomposeandersen.R

@Composable
fun FillingIcon(progress: Float, iconResId: Int) {
    val drawable = LocalContext.current.getDrawable(iconResId)
    Canvas(
        modifier = Modifier
            .size(100.dp) // Set an appropriate size
            .padding(4.dp) // Add some padding
    ) {
        val fillColor = Color.Blue // Choose your desired fill color

        // Draw the icon outline (using the outline of your drawable)
        drawIntoCanvas { canvas ->
            drawable!!.setBounds(0, 0, size.width.toInt(), size.height.toInt())
            drawable!!.draw(canvas.nativeCanvas)
        }

        // Draw the filled portion based on the progress
        drawRect(
            color = fillColor,
            size = Size(size.width * progress, size.height)
        )
    }
}

@Composable
fun FillingIconWithAnimation(progress: Float, iconResId: Int) {
    val animatedProgress = remember { Animatable(initialValue = 0f) }

    LaunchedEffect(progress) {
        animatedProgress.animateTo(targetValue = progress, animationSpec = tween(durationMillis = 500))
    }

    FillingIcon(animatedProgress.value, iconResId)
}
@Composable
fun FillingIconScreen() {
    var progress by remember { mutableStateOf(0.5f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        FillingIconWithAnimation(progress, R.drawable.ic_28_forte_logo)
        Slider(
            value = progress,
            onValueChange = { newProgress -> progress = newProgress },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}