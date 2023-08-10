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
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.testcomposeandersen.R
import android.graphics.Path as AndroidPath

// Convert an Android Path to a Compose Path
fun convertAndroidPathToComposePath(androidPath: AndroidPath): Path {
    val composePath = Path()

    return composePath
}

@Composable
fun FillingIcon(progress: Float, iconResId: Int, androidIconPath: AndroidPath) {
    val drawable = LocalContext.current.getDrawable(iconResId)

    Canvas(
        modifier = Modifier
            .size(100.dp) // Set an appropriate size
            .padding(4.dp) // Add some padding
    ) {
        val fillColor = Color.Blue // Choose your desired fill color

        // Calculate the clip width based on progress
        val clipWidth = size.width * progress

        // Clip the canvas using the provided android.graphics.Path
        val composeIconPath = PathParser().parsePathString("M27.9124,12.5034C27.7645,12.185 27.4687,11.9939 27.1305,11.9939H24.7215C24.4891,11.9939 24.2777,12.0788 24.1298,12.2274C22.6506,13.5648 20.96,14.1804 18.9736,14.0743C15.508,13.8408 12.9088,11.2085 12.951,7.9606C12.9722,5.5193 14.9586,3.5451 17.4521,3.5451C18.4453,3.5451 19.4597,4.0121 20.0936,4.7764C20.1993,4.9037 20.3683,5.1372 20.474,5.3707C20.5374,5.5618 20.5374,5.7528 20.474,5.9439C20.3049,6.3685 19.8189,6.6232 19.3751,6.4958V6.4746C19.0793,6.3685 18.7834,6.326 18.4876,6.326C17.431,6.326 16.4801,7.0053 16.0997,8.003C15.7404,9.0008 16.0363,10.1046 16.8393,10.8052C16.8816,10.8476 16.9238,10.8901 16.9661,10.9113L17.0295,10.9538C17.0295,10.9538 17.0295,10.9538 17.0506,10.975C17.0718,10.9962 17.114,11.0387 17.1563,11.0599C18.4242,11.7604 19.9668,11.8241 21.277,11.1873C22.7774,10.4443 23.8551,8.9158 24.1298,7.0902C24.3834,5.4556 23.8974,3.7998 22.7774,2.4837C21.4883,0.934 19.5019,0.0212 17.4944,0H17.3887C13.0356,0 9.4643,3.5451 9.422,7.9181C9.4009,8.7885 9.5065,9.6376 9.7178,10.423C9.5699,10.423 9.422,10.4018 9.2741,10.3806C5.7239,10.1471 2.5541,11.6118 0.2085,14.5413C-0.024,14.8173 -0.0662,15.1782 0.1028,15.4966C0.2508,15.7938 0.5466,16.0061 0.8847,16.0061H3.2938C3.5262,16.0061 3.7375,15.9212 3.8854,15.7726C5.3647,14.4139 7.0764,13.7983 9.0416,13.9257C12.5073,14.138 15.1065,16.7703 15.0642,20.0394C15.0431,22.4807 13.0567,24.4549 10.5631,24.4549C9.5699,24.4337 8.5556,23.9666 7.9216,23.2237C7.816,23.0963 7.6469,22.8628 7.5413,22.608C7.4779,22.417 7.4779,22.2259 7.5413,22.0561C7.7103,21.6315 8.1964,21.3768 8.6401,21.5042C8.936,21.6103 9.2318,21.674 9.5277,21.674C10.5843,21.674 11.5352,20.9947 11.9156,19.997C12.2748,18.9992 11.979,17.8741 11.176,17.1736C11.1337,17.1312 11.1126,17.1099 11.0492,17.0887L10.9858,17.0462C10.9858,17.025 10.9858,17.025 10.9646,17.025C10.9435,16.9826 10.9012,16.9613 10.859,16.9401C9.5911,16.2183 8.0484,16.1759 6.7382,16.8127C5.2379,17.5557 4.1602,19.0842 3.8854,20.9098C3.6319,22.5444 4.1179,24.1789 5.2379,25.5163C6.5269,27.0447 8.5133,27.9788 10.5209,28H10.6265C14.9797,28 18.551,24.4337 18.5933,20.0819C18.6144,19.2115 18.4876,18.3624 18.2974,17.5557C18.4453,17.577 18.5933,17.5982 18.7412,17.5982C18.9948,17.6194 19.2272,17.6194 19.4597,17.6194C22.7351,17.6194 25.609,16.1759 27.8068,13.4375C28.0181,13.1827 28.0604,12.8218 27.9124,12.5034Z").toPath()

        clipPath(composeIconPath) {
            // Draw the filled portion based on the progress
            drawRect(
                color = fillColor,
                size = Size(clipWidth, size.height)
            )
        }

        // Draw the icon outline (using the outline of your drawable)
        drawIntoCanvas { canvas ->
            drawable?.setBounds(0, 0, size.width.toInt(), size.height.toInt())
            drawable?.draw(canvas.nativeCanvas)
        }
    }
}
@Composable
fun FillingIconScreen() {
    var progress by remember { mutableStateOf(0.5f) }

    // Create an android.graphics.Path instance from your XML data
    val androidIconPath = AndroidPath()
    // ... add path commands to androidIconPath ...

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        FillingIcon(progress, R.drawable.ic_28_forte_logo, androidIconPath)
        Slider(
            value = progress,
            onValueChange = { newProgress -> progress = newProgress },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}