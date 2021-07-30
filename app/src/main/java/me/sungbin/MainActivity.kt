package me.sungbin

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.sungbin.timelineview.TimeLine
import me.sungbin.timelineview.TimeLineItem
import me.sungbin.timelineview.TimeLineOption

class MainActivity : AppCompatActivity() {

    private data class Item(override val key: Int) : TimeLineItem<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TimeLine(
                items = listOf(
                    Item(1),
                    Item(1),
                    Item(1),
                    Item(1),
                    Item(1),
                    Item(1),
                    Item(2),
                    Item(3),
                    Item(4),
                    Item(4),
                    Item(4),
                    Item(4),
                    Item(5),
                ),
                timeLineOption = TimeLineOption(contentHeight = 50.dp),
                modifier = Modifier.background(Color.White),
                header = { key ->
                    Text(text = "This is $key index header.")
                },
                content = { item ->
                    Text(text = "This is ${item.key} item.")
                }
            )
        }
    }
}
