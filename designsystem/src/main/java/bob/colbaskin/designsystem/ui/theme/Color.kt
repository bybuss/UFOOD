package bob.colbaskin.designsystem.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColors(
    val background: Color,
    val primaryButton: Color,
    val authButton: Color,
    val buyButton: Color,
    val sendButton: Color,
    val cardSurface: Color,
    val errorContainer: Color,
    val onErrorContainer: Color,
    val text: Color,
)

val localCustomColors = staticCompositionLocalOf {
    CustomColors(
        background = Color.Unspecified,
        primaryButton = Color.Unspecified,
        authButton = Color.Unspecified,
        buyButton = Color.Unspecified,
        sendButton = Color.Unspecified,
        cardSurface = Color.Unspecified,
        errorContainer = Color.Unspecified,
        onErrorContainer = Color.Unspecified,
        text = Color.Unspecified,
    )
}

val customColorsDark = CustomColors(
    background = Color(0xFF252830),
    primaryButton = Color(0xFF575C6A),
    authButton = Color(0xFFFE8745),
    buyButton = Color(0xFFB1FF9C),
    sendButton = Color(0xFFFFFFFF),
    cardSurface = Color(0xFF292C34),
    errorContainer = Color.Red,
    onErrorContainer = Color.White,
    text = Color(0xFFFFFFFF)
)
val customColorsLight = CustomColors(
    background = Color(0xFFADADA6),
    primaryButton = Color(0xFF575C6A),
    authButton = Color(0xFFFE8745),
    buyButton = Color(0xFFB1FF9C),
    sendButton = Color(0xFFFFFFFF),
    cardSurface = Color(0xFF292C34),
    errorContainer = Color.Red,
    onErrorContainer = Color.White,
    text = Color(0xFF000000)
)
