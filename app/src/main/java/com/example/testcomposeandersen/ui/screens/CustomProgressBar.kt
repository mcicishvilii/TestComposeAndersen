package com.example.testcomposeandersen.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.testcomposeandersen.R

@Composable
fun CustomProgressBar() {
    var progressCount: Int by remember { mutableStateOf(0) }
    val maxProgressCount = 7
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
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
                        .height(57.dp)
                        .padding(5.dp)
                )
            }
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // decrease button
        OutlinedButton(onClick = {
            if (progressCount > 1) {
                progressCount -= 1
            } else {
                Toast.makeText(context, "You cannot decrease any more", Toast.LENGTH_SHORT)
                    .show()
            }
        }) {
            Text(text = "Decrease")
        }
        // increase Button
        Button(onClick = {
            if (progressCount < 7) {
                progressCount += 1
            } else {
                Toast.makeText(context, "You cannot increase more", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Increase")
        }
    }
}

