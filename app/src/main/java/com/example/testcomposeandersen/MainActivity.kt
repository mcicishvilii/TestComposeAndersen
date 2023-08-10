package com.example.testcomposeandersen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.testcomposeandersen.ui.theme.TestComposeAndersenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeAndersenTheme() {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                ) {
                    CustomProgressBar(4)
                }
            }
        }
    }
}


@Composable
fun CustomProgressBar(progressCount: Int) {
    val maxProgressCount = 7
    val logos = List(maxProgressCount) { index ->
        val fillPercentage =
            if (index < progressCount) (index + 1) * 100 / maxProgressCount.toFloat() else 0f
        val color = if (index < progressCount) Color.Red else Color.Gray

        Image(
            painter = painterResource(id = R.drawable.ic_28_forte_logo),
            "asda",
            modifier = Modifier
                .height(37.dp)
                .background(
                    color = color,
                    shape = MaterialTheme.shapes.small
                )
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp, start = 30.dp, end = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        logos.forEach { logo ->
            Spacer(modifier = Modifier.weight(1f))
            logo
        }
    }
}

@Composable
fun ProgressBarFill(fillPercentage: Float, color: Color) {
    val size = (fillPercentage / 100f).coerceIn(0f, 1f)
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(size.dp)
            .background(color)
    )
}