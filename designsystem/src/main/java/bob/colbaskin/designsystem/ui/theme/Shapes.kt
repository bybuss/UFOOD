package bob.colbaskin.designsystem.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class CustomShapes(
    val button: Shape = RoundedCornerShape(15.dp),
    val dot: Shape = CircleShape,
    val pageIndicator: Shape = RoundedCornerShape(percent = 50),
    val bar: Shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)
)

val localCustomShapes = compositionLocalOf { CustomShapes() }