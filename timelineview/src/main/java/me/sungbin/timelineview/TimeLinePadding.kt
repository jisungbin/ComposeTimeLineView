package me.sungbin.timelineview

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class TimeLinePadding(
    val defaultPadding: PaddingValues = PaddingValues(16.dp),
    val contentStart: Dp = 4.dp,
    val contentTop: Dp = 4.dp,
    val contentBottom: Dp = 4.dp,
    val circleLineGap: Dp = 1.dp
)
