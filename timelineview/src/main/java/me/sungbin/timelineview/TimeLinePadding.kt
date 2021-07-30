/*
 * Copyright (c) 2021. Sungbin Ji. All rights reserved.
 *
 * TimeLineView license is under the MIT license.
 */

package me.sungbin.timelineview

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

interface TimeLinePadding {
    val defaultPadding: PaddingValues
    val contentStart: Dp
    val circleLineGap: Dp
}

private class TimeLinePaddingImpl(
    override val defaultPadding: PaddingValues,
    override val contentStart: Dp,
    override val circleLineGap: Dp
) : TimeLinePadding

fun TimeLinePadding(
    defaultPadding: PaddingValues = PaddingValues(16.dp),
    contentStart: Dp = 4.dp,
    circleLineGap: Dp = 1.dp
): TimeLinePadding = TimeLinePaddingImpl(defaultPadding, contentStart, circleLineGap)
