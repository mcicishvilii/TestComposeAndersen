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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
                    CustomProgressBar()
                }
            }
        }
    }
}


@Composable
fun CustomProgressBar() {
    val context = LocalContext.current
    var progressCount: Int by remember { mutableStateOf(1) }
    var progress by remember { mutableStateOf(0f) }
    var image :Int = R.drawable.ic_28_forte_logo

    when (progressCount) {
        0 -> {
            progress = 0.0f;
            image = R.drawable.ic_launcher_background
        }
        1 -> {
            progress = 0.1f;
            image = R.drawable.ic_28_forte_logo
        }
        2 -> {
            progress = 0.2f
        }
        3 -> {
            progress = 0.3f
        }
        4 -> {
            progress = 0.4f
        }
        5 -> {
            progress = 0.5f
        }
        6 -> {
            progress = 0.6f
        }
        7 -> {
            progress = 0.7f
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 30.dp, end = 30.dp)
    ) {

        // Progress Bar
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(37.dp),
            painter = painterResource(image),
            contentDescription = "sdada"
        )
    }
}

