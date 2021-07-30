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

interface TimeLineOption {
    val circleIcon: Int
    val circleSize: Dp
    val circleColor: Color
    val lineColor: Color
    val lineWidth: Dp
    val contentHeight: Dp
}

private class TimeLineOptionImpl(
    override val circleIcon: Int,
    override val circleSize: Dp,
    override val circleColor: Color,
    override val lineColor: Color,
    override val lineWidth: Dp,
    override val contentHeight: Dp
) : TimeLineOption

fun TimeLineOption(
    @DrawableRes circleIcon: Int = R.drawable.ic_outline_circle_24,
    circleSize: Dp = Dp.Unspecified,
    circleColor: Color = Color.Gray,
    lineColor: Color = Color(0xFF6200EE),
    lineWidth: Dp = 2.dp,
    contentHeight: Dp = 100.dp
): TimeLineOption =
    TimeLineOptionImpl(circleIcon, circleSize, circleColor, lineColor, lineWidth, contentHeight)
