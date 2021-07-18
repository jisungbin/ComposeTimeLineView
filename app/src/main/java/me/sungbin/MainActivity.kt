package me.sungbin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.sungbin.timelineview.TimeLine
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TimeLine(
                items = List(size = 10, init = { Random.nextInt() }),
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
                            text = item.toString(),
                            fontSize = 15.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
