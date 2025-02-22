package bob.colbaskin.ufood.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class CustomColors(
    val background: Color,
    val primaryButton: Color,
    val authButton: Color,
    val buyButton: Color,
    val sendButton: Color,
    val cardSurface: Color
)

val localCustomColors = staticCompositionLocalOf {
    CustomColors(
        background = Color.Unspecified,
        primaryButton = Color.Unspecified,
        authButton = Color.Unspecified,
        buyButton = Color.Unspecified,
        sendButton = Color.Unspecified,
        cardSurface = Color.Unspecified
    )
}

private val customColorsDark = CustomColors(
    background = Color(0xFF252830),
    primaryButton = Color(0xFF575C6A),
    authButton = Color(0xFFFE8745),
    buyButton = Color(0xFFB1FF9C),
    sendButton = Color(0xFFFFFFFF),
    cardSurface = Color(0xFF292C34)
)
private val customColorsLight = CustomColors(
    background = Color(0xFFADADA6),
    primaryButton = Color(0xFF575C6A),
    authButton = Color(0xFFFE8745),
    buyButton = Color(0xFFB1FF9C),
    sendButton = Color(0xFFFFFFFF),
    cardSurface = Color(0xFF292C34)
)

@Immutable
data class CustomTypography(
    val title: TextStyle,
    val body: TextStyle
)

val localCustomTypography = staticCompositionLocalOf {
    CustomTypography(
        title = TextStyle.Default,
        body = TextStyle.Default,
    )
}
private val customTypography = CustomTypography(
    title = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold),
    body = TextStyle(fontSize = 20.sp)
)

@Composable
fun UFOODTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    val customColors = if (darkTheme) customColorsDark else customColorsLight

    CompositionLocalProvider (
        localCustomColors provides customColors,
        localCustomTypography provides customTypography,
        content = content
    )
}

object CustomTheme {
    val colors: CustomColors
        @Composable get() = localCustomColors.current
    val typography: CustomTypography
        @Composable get() = localCustomTypography.current
}