package com.example.testcomposeandersen

import android.os.Bundle
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
    val maxProgressCount = 6

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp, start = 30.dp, end = 30.dp, bottom = 100.dp),
    ) {
        for (index in 0 until maxProgressCount) {
            if (index <= progressCount) {
                val logotype = painterResource(id = when (index) {
                    0 -> R.drawable.logo_0
                    1 -> R.drawable.logo_1
                    2 -> R.drawable.logo_2
                    3 -> R.drawable.logo_3
                    4 -> R.drawable.logo_4
                    5 -> R.drawable.logo_5
                    else -> R.drawable.logo_6
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