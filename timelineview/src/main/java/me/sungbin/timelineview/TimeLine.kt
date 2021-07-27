package me.sungbin.timelineview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <K, E : TimeLineItem<K>> TimeLine(
    items: List<E>,
    modifier: Modifier = Modifier,
    timeLineOption: TimeLineOption = TimeLineOption(),
    timeLinePadding: TimeLinePadding = TimeLinePadding(),
    content: @Composable (Modifier, E) -> Unit
) {
    LazyColumn(modifier = modifier, contentPadding = timeLinePadding.defaultPadding) {
        val groupedItems = items.groupBy { it.key }

        groupedItems.onEachIndexed { index, entry ->
            val values = entry.value

            if (values.size == 1) {
                stickyHeader {
                    TimeLineContent(
                        item = values.first(),
                        timeLineOption = timeLineOption,
                        timeLinePadding = timeLinePadding,
                        index = index,
                        groupedSize = groupedItems.size,
                        content = content
                    )
                }
            } else {
                stickyHeader {
                    TimeLineContent(
                        item = values.first(),
                        timeLineOption = timeLineOption,
                        timeLinePadding = timeLinePadding,
                        index = index,
                        groupedSize = groupedItems.size,
                        hideCircle = true,
                        content = content
                    )
                }

                items(values.drop(1)) { item ->
                    TimeLineContent(
                        item = item,
                        timeLineOption = timeLineOption,
                        timeLinePadding = timeLinePadding,
                        index = index,
                        groupedSize = groupedItems.size,
                        content = content
                    )
                }
            }
        }
    }
}

@Composable
private fun <E> TimeLineContent(
    item: E,
    timeLineOption: TimeLineOption,
    timeLinePadding: TimeLinePadding,
    index: Int,
    groupedSize: Int,
    hideCircle: Boolean = false,
    content: @Composable (Modifier, E) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(timeLineOption.contentHeight)
    ) {
        val (circle, topLine, bottomLine, timeLineContent) = createRefs()

        if (!hideCircle) {
            Icon(
                painter = painterResource(timeLineOption.circleIcon),
                contentDescription = null,
                tint = timeLineOption.circleColor,
                modifier = Modifier
                    .size(timeLineOption.circleSize)
                    .constrainAs(circle) {
                        start.linkTo(parent.start)
                        top.linkTo(timeLineContent.top)
                        bottom.linkTo(timeLineContent.bottom)
                    }
            )
        } else {
            Divider(
                modifier = Modifier.constrainAs(circle) {
                    start.linkTo(parent.start)
                    top.linkTo(timeLineContent.top)
                    bottom.linkTo(timeLineContent.bottom)
                    width = Dimension.value(timeLineOption.lineWidth)
                    height = Dimension.fillToConstraints
                },
                color = timeLineOption.lineColor
            )
        }
        content(
            Modifier.constrainAs(timeLineContent) {
                start.linkTo(circle.end, timeLinePadding.contentStart)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
            item
        )
        if (index != 0) {
            Divider(
                modifier = Modifier.constrainAs(topLine) {
                    top.linkTo(parent.top)
                    bottom.linkTo(circle.top, timeLinePadding.circleLineGap)
                    start.linkTo(circle.start)
                    end.linkTo(circle.end)
                    width = Dimension.value(timeLineOption.lineWidth)
                    height = Dimension.fillToConstraints
                },
                color = timeLineOption.lineColor
            )
        }
        if (index != groupedSize - 1) {
            Divider(
                modifier = Modifier.constrainAs(bottomLine) {
                    top.linkTo(circle.bottom, timeLinePadding.circleLineGap)
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
