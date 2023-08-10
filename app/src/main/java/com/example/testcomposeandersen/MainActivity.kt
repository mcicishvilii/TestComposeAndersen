package com.example.testcomposeandersen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
                        .background(Color.hsl(0.0f, 0.0f, 0.11f))
                ) {
                    CustomProgressBar(7)
                }
            }
        }
    }
}


@Composable
fun CustomProgressBar(progressCount: Int) {
    val maxProgressCount = 7

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 80.dp, end = 50.dp, bottom = 10.dp)
            ,
        horizontalArrangement = Arrangement.Start
    ) {
        for (index in 1..maxProgressCount) {
            if (index <= progressCount) {
                val logotype = painterResource(id = when (index) {
                    1 -> R.drawable.logo_0
                    2 -> R.drawable.logo_1
                    3 -> R.drawable.logo_2
                    4 -> R.drawable.logo_3
                    5 -> R.drawable.logo_4
                    6 -> R.drawable.logo_5
                    7 -> R.drawable.logo_6
                    else -> {
                        R.drawable.ic_launcher_background
                    }
                })

                Image(
                    painter = logotype,
                    contentDescription = null,
                    modifier = Modifier
                        .height(37.dp)
                )
            }
        }
    }
}

