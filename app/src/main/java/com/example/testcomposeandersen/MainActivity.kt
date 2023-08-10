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
                        .fillMaxSize()
                        .background(Color.Gray)
                ) {
                    CustomProgressBar(1)
                }
            }
        }
    }
}


@Composable
fun CustomProgressBar(progressCount: Int) {
    val logos = List(7) { index ->
        val fillPercent = (index + 1) * 0.1f
        val image = if (index + 1 <= progressCount) R.drawable.ic_launcher_background else R.drawable.ic_28_forte_logo

        Column(
            modifier = Modifier
                .height(37.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(image),
                contentDescription = "Logo $index",
                colorFilter = ColorFilter.tint(Color.Red, BlendMode.SrcIn),
                contentScale = ContentScale.Inside
            )
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp, start = 30.dp, end = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        logos.forEach { logo ->
            logo
        }
    }
}
