package bob.colbaskin.ufood.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

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