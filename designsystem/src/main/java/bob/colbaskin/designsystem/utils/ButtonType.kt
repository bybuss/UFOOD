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
    ButtonType.NEXT -> TextType.TITLE_MEDIUM
    ButtonType.BUY_INGREDIENTS -> TextType.TITLE_MEDIUM
    ButtonType.TEXT -> TextType.TITLE_SMALL
}

@Composable
fun ButtonType.getButtonElevation() = when(this) {
    ButtonType.NEXT -> ButtonDefaults.elevatedButtonElevation()
    ButtonType.BUY_INGREDIENTS -> ButtonDefaults.buttonElevation()
    ButtonType.TEXT -> ButtonDefaults.elevatedButtonElevation()
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
fun Modifier.buttonSize(isFulWidth: Boolean, isMainButton: Boolean) = if (isFulWidth) {
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
fun Modifier.iconSize(buttonType: ButtonType) = when(buttonType) {
    ButtonType.NEXT -> size(CustomTheme.dimensions.dimensions100)
    else -> size(CustomTheme.dimensions.dimensions24)
}
