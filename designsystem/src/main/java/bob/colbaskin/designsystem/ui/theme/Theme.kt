package bob.colbaskin.designsystem.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember

@Composable
fun UFOODTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    val customColors = if (darkTheme) customColorsDark else customColorsLight
    val multiTypography = remember { createMultiTypography() }

    CompositionLocalProvider (
        localCustomColors provides customColors,
        localMultiTypography provides multiTypography,
        localCustomShapes provides CustomShapes(),
        localCustomDimensions provides CustomDimensions(),
        content = content
    )
}

private fun createMultiTypography() = MultiTypography(
    madeInfinity = createMaterial3Typography(MadeInfinityFontFamily),
    nunito = createMaterial3Typography(NunitoFontFamily),
    brightoWander = createMaterial3Typography(BrightoWanderFontFamily),
    gilroy = createMaterial3Typography(GilroyFontFamily),
    inter = createMaterial3Typography(InterFontFamily),
    adigianaUltra = createMaterial3Typography(AdigianaUltraFontFamily),
    airfool = createMaterial3Typography(AirfoolFontFamily)
)

object CustomTheme {
    val colors: CustomColors
        @Composable get() = localCustomColors.current
    val typography: MultiTypography
        @Composable get() = localMultiTypography.current
    val shapes: CustomShapes
        @Composable get() = localCustomShapes.current
    val dimensions: CustomDimensions
        @Composable get() = localCustomDimensions.current
}