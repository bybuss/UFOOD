package bob.colbaskin.designsystem.ui.theme

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
        localCustomTypography provides MadeInfinityTypography,
        localCustomShapes provides CustomShapes(),
        localCustomDimensions provides CustomDimensions(),
        content = content
    )
}

object CustomTheme {
    val colors: CustomColors
        @Composable get() = localCustomColors.current
    val typography: CustomTypography
        @Composable get() = localCustomTypography.current
    val shapes: CustomShapes
        @Composable get() = localCustomShapes.current
    val dimensions: CustomDimensions
        @Composable get() = localCustomDimensions.current
}