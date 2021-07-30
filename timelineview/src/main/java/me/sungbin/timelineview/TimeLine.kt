/*
 * Copyright (c) 2021. Sungbin Ji. All rights reserved.
 *
 * TimeLineView license is under the MIT license.
 */

package me.sungbin.timelineview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

private const val HeaderIndex = -1

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <K, E : TimeLineItem<K>> TimeLine(
    items: List<E>,
    modifier: Modifier = Modifier,
    timeLineOption: TimeLineOption = TimeLineOption(),
    timeLinePadding: TimeLinePadding = TimeLinePadding(),
    header: @Composable (K) -> Unit,
    content: @Composable (E) -> Unit
) {
    LazyColumn(modifier = modifier, contentPadding = timeLinePadding.defaultPadding) {
        val groupedItems = items.groupBy { it.key }

        groupedItems.onEachIndexed { groupIndex, (key, elements) ->
            stickyHeader {
                TimeLineView(
                    key = key,
                    item = elements.first(),
                    groupSize = groupedItems.size,
                    groupIndex = groupIndex,
                    elementsSize = elements.size,
                    elementsIndex = HeaderIndex,
                    timeLineOption = timeLineOption,
                    timeLinePadding = timeLinePadding,
                    isHeader = true,
                    header = header,
                    content = content
                )
            }

            itemsIndexed(elements) { elementIndex, element ->
                TimeLineView(
                    key = key,
                    item = element,
                    groupSize = groupedItems.size,
                    groupIndex = groupIndex,
                    elementsSize = elements.size,
                    elementsIndex = elementIndex,
                    timeLineOption = timeLineOption,
                    timeLinePadding = timeLinePadding,
                    isHeader = false,
                    header = header,
                    content = content
                )
            }
        }
    }
}

@Composable
private fun <K, E : TimeLineItem<K>> TimeLineView(
    key: K,
    item: E,
    groupSize: Int,
    groupIndex: Int,
    elementsSize: Int,
    elementsIndex: Int,
    timeLineOption: TimeLineOption,
    timeLinePadding: TimeLinePadding,
    isHeader: Boolean,
    header: @Composable (K) -> Unit,
    content: @Composable (E) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(timeLineOption.contentHeight)
    ) {
        val (circle, circleInnerLine, topLine, bottomLine, timeLineContent) = createRefs()

        Icon(
            painter = painterResource(timeLineOption.circleIcon),
            contentDescription = null,
            tint = if (isHeader) timeLineOption.circleColor else Color.Transparent,
            modifier = Modifier
                .size(timeLineOption.circleSize)
                .constrainAs(circle) {
                    start.linkTo(parent.start)
                    top.linkTo(timeLineContent.top)
                    bottom.linkTo(timeLineContent.bottom)
                }
        )
        if (!isHeader) {
            Divider(
                modifier = Modifier.constrainAs(circleInnerLine) {
                    top.linkTo(circle.top)
                    bottom.linkTo(circle.bottom)
                    start.linkTo(circle.start)
                    end.linkTo(circle.end)
                    width = Dimension.value(timeLineOption.lineWidth)
                    height = Dimension.fillToConstraints
                },
                color = timeLineOption.lineColor
            )
        }
        Surface(
            modifier = Modifier.constrainAs(timeLineContent) {
                start.linkTo(circle.end, timeLinePadding.contentStart)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        ) {
            if (isHeader) {
                header(key)
            } else {
                content(item)
            }
        }
        if (!(groupIndex == 0 && elementsIndex == HeaderIndex)) {
            Divider(
                modifier = Modifier.constrainAs(topLine) {
                    top.linkTo(parent.top)
                    bottom.linkTo(
                        circle.top,
                        if (isHeader) timeLinePadding.circleLineGap else 0.dp
                    )
                    start.linkTo(circle.start)
                    end.linkTo(circle.end)
                    width = Dimension.value(timeLineOption.lineWidth)
                    height = Dimension.fillToConstraints
                },
                color = timeLineOption.lineColor
            )
        }
        if (!(groupIndex == groupSize - 1 && elementsIndex == elementsSize - 1)) {
            Divider(
                modifier = Modifier.constrainAs(bottomLine) {
                    top.linkTo(
                        circle.bottom,
                        if (isHeader) timeLinePadding.circleLineGap else 0.dp
                    )
                    bottom.linkTo(parent.bottom)
                    start.linkTo(circle.start)
                    end.linkTo(circle.end)
                    width = Dimension.value(timeLineOption.lineWidth)
                    height = Dimension.fillToConstraints
                },
                color = timeLineOption.lineColor
            )
        }
    }
}
