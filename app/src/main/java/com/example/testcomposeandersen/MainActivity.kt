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
    val maxProgressCount = 7

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp, start = 30.dp, end = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (index in 0 until maxProgressCount) {
            val logoVisible = index <= progressCount

            val logotype = painterResource(id = when {
                index == 0 -> R.drawable.logo_0
                index == 1 -> R.drawable.logo_1
                index == 2 -> R.drawable.logo_2
                index == 3 -> R.drawable.logo_3
                index == 4 -> R.drawable.logo_4
                index == 5 -> R.drawable.logo_5
                index == 6 -> R.drawable.logo_7
                else -> R.drawable.logo_7
            })

            Image(
                painter = logotype,
                contentDescription = null,
                modifier = Modifier
                    .height(37.dp)
                    .background(
                        color = if (logoVisible) Color.Green else Color.Transparent,
                        shape = MaterialTheme.shapes.small
                    )
            )
        }
    }
}
