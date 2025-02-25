package bob.colbaskin.ufood.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import bob.colbaskin.ufood.R

val MadeInfinityFontFamily = FontFamily(
    Font(R.font.made_infinity_black, FontWeight.Black),
)

@Immutable
data class CustomTypography(
    val headLineLarge: TextStyle,
    val title: TextStyle,
    val body: TextStyle
)

val localCustomTypography = staticCompositionLocalOf {
    CustomTypography(
        headLineLarge = TextStyle.Default,
        title = TextStyle.Default,
        body = TextStyle.Default,
    )
}
val customTypography = CustomTypography(
    headLineLarge = TextStyle(
        fontFamily = MadeInfinityFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 80.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    title = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold),
    body = TextStyle(fontSize = 20.sp)
)