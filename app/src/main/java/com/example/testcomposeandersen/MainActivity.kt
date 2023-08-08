package com.example.testcomposeandersen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.testcomposeandersen.ui.screens.All
import com.example.testcomposeandersen.ui.screens.Friends
import com.example.testcomposeandersen.ui.screens.FromForte
import com.example.testcomposeandersen.ui.screens.Partner
import com.example.testcomposeandersen.ui.theme.TestComposeAndersenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeAndersenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TabScreen()
                }
            }
        }
    }
}

@Composable
fun TabScreen() {
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("All", "Friends", "FromForte","Partner")

    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp)) {
        TabRow(
            selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    selectedContentColor = MaterialTheme.colorScheme.primaryContainer,
                    unselectedContentColor = MaterialTheme.colorScheme.secondaryContainer,
                )
            }
        }
        when (tabIndex) {
            0 -> All()
            1 -> Friends()
            2 -> FromForte()
            3 -> Partner()
        }
    }
}