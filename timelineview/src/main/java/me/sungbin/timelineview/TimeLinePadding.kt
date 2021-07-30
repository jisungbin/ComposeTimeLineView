/*
 * Copyright (c) 2021. Sungbin Ji. All rights reserved.
 *
 * TimeLineView license is under the MIT license.
 */

package me.sungbin.timelineview

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class TimeLinePadding(
    val defaultPadding: PaddingValues = PaddingValues(16.dp),
    val contentStart: Dp = 4.dp,
    val circleLineGap: Dp = 1.dp
)
