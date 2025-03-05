package bob.colbaskin.designsystem.utils

import androidx.compose.runtime.Composable
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

@Composable
fun TextType.getTextStyle() = when(this) {
    TextType.DISPLAY_LARGE -> CustomTheme.typography.displayLarge
    TextType.DISPLAY_MEDIUM -> CustomTheme.typography.displayMedium
    TextType.DISPLAY_SMALL -> CustomTheme.typography.displaySmall
    TextType.HEADLINE_LARGE -> CustomTheme.typography.labelLarge
    TextType.HEADLINE_MEDIUM -> CustomTheme.typography.headlineMedium
    TextType.HEADLINE_SMALL -> CustomTheme.typography.headlineSmall
    TextType.TITLE_LARGE -> CustomTheme.typography.titleLarge
    TextType.TITLE_MEDIUM -> CustomTheme.typography.titleMedium
    TextType.TITLE_SMALL -> CustomTheme.typography.titleSmall
    TextType.BODY_LARGE -> CustomTheme.typography.bodyLarge
    TextType.BODY_MEDIUM -> CustomTheme.typography.bodyMedium
    TextType.BODY_SMALL -> CustomTheme.typography.bodySmall
    TextType.LABEL_LARGE -> CustomTheme.typography.labelLarge
    TextType.LABEL_MEDIUM -> CustomTheme.typography.labelMedium
    TextType.LABEL_SMALL -> CustomTheme.typography.labelSmall
}