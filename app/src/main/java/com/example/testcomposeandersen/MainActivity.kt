package com.example.testcomposeandersen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
            var selectedTabIndex by remember { mutableStateOf(0) }

            val tabs = listOf(
                Tabs("All", 3),
                Tabs("Friends", 3),
                Tabs("FromForte", 0),
                Tabs("Partner", 0)
            )
            TestComposeAndersenTheme {
                CustomScrollableTabRow(
                    tabs = tabs,
                    selectedTabIndex = selectedTabIndex,
                ) { tabIndex ->
                    selectedTabIndex = tabIndex
                }
            }
        }
    }
}


data class Tabs(
    val tabName: String,
    val tabNotiCount: Int
)

@Composable
fun CustomScrollableTabRow(
    tabs: List<Tabs>,
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit
) {
    val indicatorColor = Color.hsl(337f, 0.65f, 0.51f)
    val backgroundColor = Color.hsv(0f, 0f, 0.97f)
    val density = LocalDensity.current
    val tabWidths = remember {
        mutableStateListOf<Dp>().apply {
            repeat(tabs.size) {
                add(0.dp)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        TabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = selectedTabIndex,
            contentColor = Color.White,
            divider = {},
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .customTabIndicatorOffset(
                        currentTabPosition = tabPositions[selectedTabIndex],
                        tabWidth = tabWidths[selectedTabIndex],
                    )
                        .height(4.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(indicatorColor)
                )
            }
        ) {
            tabs.forEachIndexed { tabIndex, tab ->
                Tab(
                    selected = selectedTabIndex == tabIndex,
                    onClick = { onTabClick(tabIndex) },
                    modifier = Modifier
                        .height(48.dp)
                        .background(Color.White),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        Text(
                            text = tab.tabName,
                            color = if (selectedTabIndex == tabIndex) {
                                Color.Black
                            } else {
                                Color.Gray
                            },
                            fontSize = 14.sp,
                            onTextLayout = { textLayoutResult ->
                                tabWidths[tabIndex] = with(density) { textLayoutResult.size.width.toDp() }
                            }
                        )
                        if (tab.tabNotiCount > 0) {
                            Box(
                                modifier = Modifier
                                    .padding(start = 4.dp)
                                    .size(20.dp)
                                    .background(
                                        color = if (selectedTabIndex == tabIndex) {
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
                                        text = tab.tabNotiCount.toString(),
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

        when (selectedTabIndex) {
            0 -> All()
            1 -> Friends()
            2 -> FromForte()
            3 -> Partner()
        }
    }
}


fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition,
    tabWidth: Dp
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "customTabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = tabWidth,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    val indicatorOffset by animateDpAsState(
        targetValue = ((currentTabPosition.left + currentTabPosition.right - tabWidth) / 2),
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
}
