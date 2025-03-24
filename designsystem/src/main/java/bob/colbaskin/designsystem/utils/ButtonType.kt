package bob.colbaskin.designsystem.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import bob.colbaskin.designsystem.ui.theme.CustomTheme

enum class ButtonType {
    NEXT,
    BUY_INGREDIENTS,
    TEXT
}

fun ButtonType.getTextType(): TextType = when(this) {
    ButtonType.NEXT -> TextType.TITLE_LARGE
    ButtonType.BUY_INGREDIENTS -> TextType.TITLE_MEDIUM
    ButtonType.TEXT -> TextType.TITLE_LARGE
}

@Composable
fun ButtonType.getButtonColors() = when(this) {
    ButtonType.NEXT -> ButtonDefaults.buttonColors(
        containerColor = CustomTheme.colors.primaryButton,
        contentColor = CustomTheme.colors.sendButton
    )
    ButtonType.BUY_INGREDIENTS -> ButtonDefaults.elevatedButtonColors()
    ButtonType.TEXT -> ButtonDefaults.textButtonColors()
}

@Composable
fun Modifier.getButtonSize(isFullWidth: Boolean, isMainButton: Boolean) = if (isFullWidth) {
    fillMaxWidth()
} else {
    width(CustomTheme.dimensions.dimensions100)
}.height(
    if (isMainButton) {
        CustomTheme.dimensions.dimensions64
    } else {
        CustomTheme.dimensions.dimensions48
    }
)

@Composable
fun Modifier.getIconSize(buttonType: ButtonType) = when(buttonType) {
    ButtonType.NEXT -> size(CustomTheme.dimensions.dimensions80)
    else -> size(CustomTheme.dimensions.dimensions24)
}
