# TimeLineView

android Sticky-TimeLineView that made with jetpack-compose.

---

# Download [![](https://img.shields.io/maven-central/v/io.github.jisungbin/timelineview)](https://search.maven.org/artifact/io.github.jisungbin/timelineview)

```groovy
implementation "io.github.jisungbin:timelineview:${version}"
```

# Preview

<img src="https://user-images.githubusercontent.com/40740128/127657575-2a0388e5-ad02-4274-a9d8-be51a52979eb.png" width="33%" />

# Usage

### 1. Create item model class

```kotlin
data class Item(override val key: Int) : TimeLineItem<Int>
```

**model class must be extends `TimeLineView<K>` !**



#### TimeLineView<K\>

`K` value will be `TimeLineView-Header` item.



### 2. Use TimeLineView

```kotlin
@Composable
fun <K, E : TimeLineItem<K>> TimeLine(
    items: List<E>,
    modifier: Modifier = Modifier,
    timeLineOption: TimeLineOption = TimeLineOption(),
    timeLinePadding: TimeLinePadding = TimeLinePadding(),
    header: @Composable (K) -> Unit,
    content: @Composable (E) -> Unit
)
```



 #### TimeLineOption

```kotlin
fun TimeLineOption(
    @DrawableRes circleIcon: Int = R.drawable.ic_outline_circle_24,
    circleSize: Dp = Dp.Unspecified,
    circleColor: Color = Color.Gray,
    lineColor: Color = Color(0xFF6200EE),
    lineWidth: Dp = 2.dp,
    contentHeight: Dp = 100.dp
): TimeLineOption
```



#### TimeLinePadding

```kotlin
fun TimeLinePadding(
    defaultPadding: PaddingValues = PaddingValues(16.dp),
    contentStart: Dp = 4.dp,
    circleLineGap: Dp = 1.dp
): TimeLinePadding
```



# License

`TimeLineView` license is under the MIT License.

Please see [license](https://github.com/jisungbin/TimeLineView/blob/master/LICENSE) file.


---

# 🤗 Happy Coding :)

