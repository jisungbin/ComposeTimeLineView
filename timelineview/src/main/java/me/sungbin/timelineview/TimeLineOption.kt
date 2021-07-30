/*
 * Copyright (c) 2021. Sungbin Ji. All rights reserved.
 *
 * TimeLineView license is under the MIT license.
 */

package me.sungbin.timelineview

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class TimeLineOption(
    @DrawableRes val circleIcon: Int = R.drawable.ic_outline_circle_24,
    val circleSize: Dp = Dp.Unspecified,
    val circleColor: Color = Color.Gray,
    val lineColor: Color = Color(0xFF6200EE),
    val lineWidth: Dp = 2.dp,
    val contentHeight: Dp = 100.dp
)
