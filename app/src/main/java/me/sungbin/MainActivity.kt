package me.sungbin

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import me.sungbin.timelineview.TimeLine
import me.sungbin.timelineview.TimeLineItem

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
                modifier = Modifier.background(Color.White),
                header = { index ->
                    Text(text = "This is $index index header.")
                },
                content = { item ->
                    Text(text = "This is ${item.key} item.")
                }
            )
        }
    }
}
