package me.sungbin

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // private data class Item(override val key: Int) : TimeLineItem<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            /*TimeLine(
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
                modifier = Modifier.background(Color.White)
            ) { modifier, item ->
                Surface(
                    modifier = modifier,
                    elevation = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(30.dp)) {
                        Text(
                            text = item.key.toString(),
                            fontSize = 15.sp,
                            color = Color.White
                        )
                    }
                }
            }*/
        }
    }
}
