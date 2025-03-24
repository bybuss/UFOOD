package bob.colbaskin.designsystem.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import bob.colbaskin.designsystem.ui.theme.CustomTheme

enum class TextType {
    DISPLAY_LARGE,
    DISPLAY_MEDIUM,
    DISPLAY_SMALL,
    HEADLINE_LARGE,
    HEADLINE_MEDIUM,
    HEADLINE_SMALL,
    TITLE_LARGE,
    TITLE_MEDIUM,
    TITLE_SMALL,
    BODY_LARGE,
    BODY_MEDIUM,
    BODY_SMALL,
    LABEL_LARGE,
    LABEL_MEDIUM,
    LABEL_SMALL,
}

enum class FontFamilyKey {
    MADE_INFINITY,
    NUNITO,
    BRIGHTO_WANDER,
    GILROY,
    INTER,
    ADIGIANA_ULTRA,
    AIRFOOL
}

@Composable
fun TextType.getTextStyle(fontFamily: FontFamilyKey = FontFamilyKey.INTER): TextStyle {
    val typography = when(fontFamily) {
        FontFamilyKey.MADE_INFINITY -> CustomTheme.typography.madeInfinity
        FontFamilyKey.NUNITO -> CustomTheme.typography.nunito
        FontFamilyKey.BRIGHTO_WANDER -> CustomTheme.typography.brightoWander
        FontFamilyKey.GILROY -> CustomTheme.typography.gilroy
        FontFamilyKey.INTER -> CustomTheme.typography.inter
        FontFamilyKey.ADIGIANA_ULTRA -> CustomTheme.typography.adigianaUltra
        FontFamilyKey.AIRFOOL -> CustomTheme.typography.airfool
    }

    return when(this) {
        TextType.DISPLAY_LARGE -> typography.displayLarge
        TextType.DISPLAY_MEDIUM -> typography.displayMedium
        TextType.DISPLAY_SMALL -> typography.displaySmall
        TextType.HEADLINE_LARGE -> typography.headlineLarge
        TextType.HEADLINE_MEDIUM -> typography.headlineMedium
        TextType.HEADLINE_SMALL -> typography.headlineSmall
        TextType.TITLE_LARGE -> typography.titleLarge
        TextType.TITLE_MEDIUM -> typography.titleMedium
        TextType.TITLE_SMALL -> typography.titleSmall
        TextType.BODY_LARGE -> typography.bodyLarge
        TextType.BODY_MEDIUM -> typography.bodyMedium
        TextType.BODY_SMALL -> typography.bodySmall
        TextType.LABEL_LARGE -> typography.labelLarge
        TextType.LABEL_MEDIUM -> typography.labelMedium
        TextType.LABEL_SMALL -> typography.labelSmall
    }
}