package com.example.testcomposeandersen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.contentColor
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    val tabs = listOf(
        Tabs("All", 3),
        Tabs("Friends", 3),
        Tabs("FromForte", 0),
        Tabs("Partner", 0)
    )

    val indicatorColor = Color.hsv(336f, 0.85f, 0.89f)
    val backgroundColor = Color.hsv(0f, 0f, 0.97f)


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)

    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            modifier = Modifier.fillMaxWidth(),
            divider = {},
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[tabIndex])
                        .height(4.dp)
                        .padding(horizontal = 28.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = indicatorColor)
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    modifier = Modifier
                        .height(48.dp)
                        .background(Color.White)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        Text(
                            text = title.tabName,
                            color = if (tabIndex == index) {
                                Color.Black
                            } else {
                                Color.Gray
                            },
                            fontSize = 14.sp,

                            )
                        if (title.tabNotiCount > 0) {
                            Box(
                                modifier = Modifier
                                    .padding(start = 4.dp)
                                    .size(20.dp)
                                    .background(
                                        color = if (tabIndex == index) {
                                            Color.Blue
                                        } else {
                                            Color.Gray
                                        },
                                        shape = MaterialTheme.shapes.medium
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(20.dp)
                                        .background(
                                            color = Color.Transparent,
                                            shape = MaterialTheme.shapes.small
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = title.tabNotiCount.toString(),
                                        color = Color.White,
                                        fontSize = 12.sp,
                                    )
                                }
                            }
                        }
                    }
                }
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



data class Tabs(
    val tabName:String,
    val tabNotiCount:Int
)
