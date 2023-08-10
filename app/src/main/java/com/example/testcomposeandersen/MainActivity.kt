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
    var progressCount: Int by remember { mutableStateOf(0) }
    var progress by remember { mutableStateOf(0f) }

    when (progressCount) {
        0 -> {
            progress = 0.0f
        }
        1 -> {
            progress = 0.1f
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
//        8 -> progress = 0.8f
//        9 -> progress = 0.9f
//        10 -> progress = 1.0f
    }

    val size by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 30.dp, end = 30.dp)
    ) {
        // for the text above the progressBar
        Row(
            modifier = Modifier
                .widthIn(min = 30.dp)
                .fillMaxWidth(size),
            horizontalArrangement = Arrangement.End
        ) {
            androidx.compose.material3.Text(text = "$progress")
        }
        // Progress Bar
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(17.dp),
            painter = painterResource(id = R.drawable.ic_28_forte_logo),
            contentDescription = "sdada"

        )


        // controling only increase and decrease. buttons and toasts.
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            androidx.compose.material3.OutlinedButton(onClick = {
                if (progressCount > 0) {
                    progressCount -= 2
                } else {
                    Toast.makeText(context, "You cannot decrease any more", Toast.LENGTH_SHORT)
                        .show()
                }
            }) {
                androidx.compose.material3.Text(text = "Decrease")
            }
            androidx.compose.material3.Button(onClick = {
                if (progressCount < 10) {
                    progressCount += 2
                } else {
                    Toast.makeText(context, "You cannot increase more", Toast.LENGTH_SHORT).show()
                }
            }) {
                androidx.compose.material3.Text(text = "Increase")
            }
        }


    }
}



//{
//            // for the background of the ProgressBar
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .clip(RoundedCornerShape(9.dp))
//                    .background(Color.Gray)
//            )
//            // for the progress of the ProgressBar
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth(size)
//                    .fillMaxHeight()
//                    .clip(RoundedCornerShape(9.dp))
//                    .background(Color.Blue)
//                    .animateContentSize()
//            )
//}