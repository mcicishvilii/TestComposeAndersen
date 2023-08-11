package com.example.testcomposeandersen.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.testcomposeandersen.R

@Composable
fun FromForte() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ){
        Text(text = "FromForte", modifier = Modifier.background(Color.Cyan))

        Spacer(modifier = Modifier.height(20.dp))

        FillingIconScreen()

    }
}
