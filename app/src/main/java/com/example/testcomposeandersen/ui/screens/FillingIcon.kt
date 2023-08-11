package com.example.testcomposeandersen.ui.screens


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.testcomposeandersen.R
import android.graphics.Path as AndroidPath

@Composable
fun FillingIcon(progress: Float, fillColor: Color, strokeColor: Int) {

    val vectorPathData = "M239.25,107.17C237.98,104.44 235.45,102.8 232.55,102.8L211.9,102.8C209.91,102.8 208.09,103.53 206.83,104.8C194.15,116.27 179.66,121.55 162.63,120.64C132.93,118.64 110.65,96.07 111.01,68.23C111.19,47.31 128.21,30.39 149.59,30.39C158.1,30.39 166.8,34.39 172.23,40.94C173.14,42.03 174.59,44.03 175.49,46.04C176.04,47.67 176.04,49.31 175.49,50.95C174.04,54.59 169.88,56.77 166.07,55.68L166.07,55.5C163.54,54.59 161,54.22 158.46,54.22C149.41,54.22 141.26,60.05 138,68.6C134.92,77.15 137.45,86.61 144.34,92.62C144.7,92.98 145.06,93.34 145.42,93.53L145.97,93.89C145.97,93.89 145.97,93.89 146.15,94.07C146.33,94.25 146.69,94.62 147.05,94.8C157.92,100.8 171.14,101.35 182.38,95.89C195.23,89.52 204.47,76.42 206.83,60.77C209,46.76 204.84,32.57 195.23,21.29C184.18,8 167.16,0.18 149.95,0L149.05,0C111.73,0 81.12,30.39 80.76,67.87C80.58,75.33 81.48,82.61 83.3,89.34C82.03,89.34 80.76,89.16 79.49,88.98C49.06,86.98 21.89,99.53 1.79,124.64C-0.21,127 -0.57,130.1 0.88,132.83C2.15,135.38 4.68,137.2 7.58,137.2L28.23,137.2C30.22,137.2 32.04,136.47 33.3,135.2C45.98,123.55 60.66,118.27 77.5,119.36C107.21,121.18 129.48,143.75 129.12,171.77C128.94,192.69 111.91,209.61 90.54,209.61C82.03,209.43 73.33,205.43 67.9,199.06C67,197.97 65.54,195.97 64.64,193.78C64.1,192.14 64.1,190.51 64.64,189.05C66.09,185.41 70.25,183.23 74.06,184.32C76.59,185.23 79.13,185.78 81.66,185.78C90.72,185.78 98.88,179.95 102.13,171.4C105.21,162.85 102.68,153.21 95.79,147.2C95.43,146.84 95.25,146.66 94.71,146.47L94.16,146.11C94.16,145.93 94.16,145.93 93.98,145.93C93.8,145.57 93.44,145.38 93.08,145.2C82.21,139.02 68.98,138.65 57.76,144.11C44.89,150.48 35.66,163.58 33.3,179.23C31.13,193.24 35.3,207.25 44.89,218.71C55.95,231.81 72.97,239.82 90.18,240L91.09,240C128.4,240 159.01,209.43 159.37,172.13C159.55,164.67 158.46,157.39 156.84,150.48C158.1,150.66 159.37,150.84 160.64,150.84C162.81,151.02 164.8,151.02 166.8,151.02C194.87,151.02 219.5,138.65 238.34,115.18C240.16,113 240.52,109.9 239.25,107.17ZM239.25,107.17" // Replace with your vector path data

    Canvas(
        modifier = Modifier
            .size(700.dp)
            .padding(15.dp)
    ) {
        val clipWidth = size.height * progress / 4
        val vectorPath = PathParser().parsePathString(vectorPathData).toPath()

        clipPath(vectorPath) {
            drawRect(
                color = fillColor,
                size = Size(clipWidth, size.height)// Adjust the stroke width as needed,
            )
        }
    }
}



//@Composable
//fun FillingIconScreen() {
//    var progress by remember { mutableStateOf(0.5f) }
//    val androidIconPath = AndroidPath()
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        FillingIcon(progress)
//        Slider(
//            value = progress,
//            onValueChange = { newProgress -> progress = newProgress },
//            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
//        )
//    }
//}