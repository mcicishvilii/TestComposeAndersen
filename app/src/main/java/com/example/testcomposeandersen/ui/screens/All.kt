package com.example.testcomposeandersen.ui.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun All() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 20.dp)
        .background(Color.hsl(0.0f, 0.0f, 0.11f)), horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "All",)
        CustomProgressBar()
    }
}